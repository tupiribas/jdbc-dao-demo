package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		SellerDAO sellerDAO = DaoFactory.createSellerDao();

		List<Seller> listSeller = sellerDAO.findAll();

		for (Seller seller : listSeller) {
			System.out.println(seller);
		}

		Seller newSeller = new Seller("Anderson Arcenélio Alves", "anderson@gmail.com", sdf.parse("21/10/2002"), 1200.0,
				new Department(2));
		
		sellerDAO.insert(newSeller);

		for (Seller seller : listSeller) {
			System.out.println("\n" + seller);
		}
	}

}
