package application;

import java.text.ParseException;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SellerDAO sellerDAO = DaoFactory.createSellerDao();
		
//		Seller seller = sellerDAO.findById(5);
//		
//		if (seller != null) {
//			System.out.println(seller);
//		}
//		else {
//			System.out.println("Nenhum resultado encontrado!");
//		}
		
		List<Seller> listSeller = sellerDAO.findByDepartment(new Department(2)); 
		
		System.out.println("Mostrar os funcionários correspondentes ao id do departamento: \n");
		for (Seller seller : listSeller) {
			if (listSeller != null) {
				System.out.println(seller);
			}
			else {
				System.out.println("Nenhum outro resultado encontrado.");
			}
		}
	}

}
