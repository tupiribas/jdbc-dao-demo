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
		Seller seller = new Seller();

		List<Seller> listSeller = sellerDAO.findAll();

		for (Seller seller2 : listSeller) {
			System.out.println(seller2);
		}

		Seller newSeller = new Seller("Anderson Arcenélio Alves", "anderson@gmail.com", sdf.parse("21/10/2002"), 1200.0,
				new Department(2));
		
		sellerDAO.insert(newSeller);

		for (Seller seller3 : listSeller) {
			System.out.println("\n" + seller3);
		}
		
		System.out.println("Mudando o nome do usuário: ");
		seller = sellerDAO.findById(1);
		seller.setName("Martha Waine");
		seller = sellerDAO.findById(1);
		seller.setEmail("marthaW@outlook.com");
		
		sellerDAO.update(seller);
		System.out.println("Nome alterado com sucesso!");
		for (Seller seller2 : listSeller) {
			System.out.println(seller2);
		}
	}

}
