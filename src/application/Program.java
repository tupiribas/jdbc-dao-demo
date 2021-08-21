package application;

import java.text.ParseException;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SellerDAO sellerDAO = DaoFactory.createSellerDao();
		
		Seller seller = sellerDAO.findById(5);
		
		if (seller != null) {
			System.out.println(seller);
		}
		else {
			System.out.println("Nenhum resultado encontrado!");
		}
	}

}
