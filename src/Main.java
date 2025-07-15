import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Department department = new Department(1,"Books");
        System.out.println(department);
        Seller seller = new Seller(21,"Bob","bob@email.com",new Date(), 3000.0, department);
        System.out.println(seller);

    }
}