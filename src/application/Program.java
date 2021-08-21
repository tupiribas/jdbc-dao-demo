package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Department obj = new Department(1, "Bocks");

		Seller seller = new Seller(1, "Tupi Guedes Ribas", "tupyribas@outlook.com", sdf.parse("21/10/2002"), 1200.0,
				obj);
		System.out.println(seller);
	}

}
