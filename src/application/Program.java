package application;

import java.text.ParseException;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SellerDAO sellerDAO = DaoFactory.createSellerDao();
		
		List<Seller> listSeller = sellerDAO.findAll();
		
		for (Seller seller : listSeller) {
			System.out.println(seller);
		}
	}

}
