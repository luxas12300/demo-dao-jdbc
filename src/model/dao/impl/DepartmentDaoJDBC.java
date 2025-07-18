package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {
    private Connection conn;

    public DepartmentDaoJDBC(Connection conn){this.conn = conn;}
    @Override
    public void insert(Department obj) {
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("Insert Into department "
            + "(Name) "
            +"VALUES (?)",
            Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, obj.getName());

            int rowsAffected = ps.executeUpdate();
            if(rowsAffected > 0){
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            }else {
                throw new DbException("Error! No rows affected");
            }
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("UPDATE department "
            +"SET Name = ? "
            +"where Id = ?");

            ps.setString(1, obj.getName());
            ps.setInt(2,obj.getId());

            ps.executeUpdate();
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement ps = null;
        try{
            ps= conn.prepareStatement("DELETE FROM department "
            +"where Id = ?");

            ps.setInt(1,id);

            int rowsAffected = ps.executeUpdate();

            if(rowsAffected == 0){
                throw new DbException("Id não encontrado");
            }

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs= null;
        try{
            ps = conn.prepareStatement("SELECT department.* from department " +
                    "WHERE department .Id = ?");

            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()){
                Department dep = instantiateDepartment(rs);
                return dep;
            }
            return null;
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeResultSet(rs);
            DB.closeStatement(ps);
        }
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException{
        Department dep = new Department();
        dep.setId(rs.getInt("Id"));
        dep.setName(rs.getString("Name"));
        return dep;
    }

    @Override
    public List<Department> findAll() {
       PreparedStatement ps = null;
       ResultSet rs = null;
       try{
           ps = conn.prepareStatement("SELECT * from department "
           +"ORDER BY Name");

           rs = ps.executeQuery();

           List<Department> list = new ArrayList<>();

           while (rs.next()){
               Department dep = instantiateDepartment(rs);
               list.add(dep);
           }
           return list;

       }catch (SQLException e){
           throw new DbException(e.getMessage());
       }
    }



}
