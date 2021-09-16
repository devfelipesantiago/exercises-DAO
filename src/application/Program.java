package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

import static java.lang.System.out;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        out.println("===TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        out.println(seller);

        out.println("===TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) out.println(obj);

        out.println("===TEST 3: seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj : list) out.println(obj);

        out.println("===TEST 4 : seller insert ===");
        Seller newSeller = new Seller(null, "Greg", "email@mail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        out.println("Insert! " + newSeller.getId());
    }


}
