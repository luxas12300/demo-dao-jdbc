import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        /*SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("===== TEST 1: findById ======");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("===== TEST 2: findByDepartment ======");
        Department department = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for(Seller obj : list){
            System.out.println(obj);

        }

        System.out.println("===== TEST 3: findAll ======");
        list = sellerDao.findALl();

        for(Seller obj : list){
            System.out.println(obj);
        }

        System.out.println("===== TEST 4: insert ======");
        Seller seller1 = new Seller(9, "Greg", "greg@mail", new Date(), 4000.0, department);
        sellerDao.insert(seller1);

        System.out.println("Inserted! New Id: "+seller1.getId());

        System.out.println("===== TEST 5: Update seller ======");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("===== TEST 6: deleteById ======");
        sellerDao.deleteById(seller1.getId());

        System.out.println("Delete completed");*/

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("===== TEST 1: findById ======");
        Department dep = departmentDao.findById(3);
        System.out.println(dep);


        System.out.println("===== TEST 2: findAll ======");
        List<Department> list = departmentDao.findAll();

        list = departmentDao.findAll();

        for(Department obj : list){
            System.out.println(obj);
        }

        System.out.println("===== TEST 3: insert ======");
        Department dep1 = new Department(9,"sales");
        departmentDao.insert(dep1);

        System.out.println("Inserted! New Id: "+dep1.getId());

        System.out.println("===== TEST 4: Update seller ======");
        dep = departmentDao.findById(1);
        dep.setName("Cleaning");
        departmentDao.update(dep);
        System.out.println("Update completed");

        System.out.println("===== TEST 5: deleteById ======");
        departmentDao.deleteById(dep1.getId());

        System.out.println("Delete completed");
    }
}