package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Seller> listSeller = new ArrayList<>();
		SellerDAO sellerDAO = DaoFactory.createSellerDao();

		System.out.println("=====TESTE 01=====Mostrar todos dados os vendedores");
		listSeller = sellerDAO.findAll();
		for (Seller seller : listSeller) {
			System.out.println(seller);
		}

		System.out.println("\n=====TESTE 02=====Mostrar todos dados os vendedores com o identificador específico");
		Department dep = new Department(2);
		listSeller = sellerDAO.findByDepartment(dep);
		for (Seller seller : listSeller) {
			System.out.println(seller);
		}

		System.out.println("\n=====TESTE 03=====Mostrar dados de um vendedor específico");
		Seller obj = new Seller();
		obj = sellerDAO.findById(2);
		System.out.println(obj);

		System.out.println("\n=====TESTE 04=====Inserir os dados de um vendedor");
		obj = new Seller("Clorisvaldo Freitas", "cloris@outlook.com", sdf.parse("21/10/2002"), 1200.0,
				new Department(2));
		sellerDAO.insert(obj);
		System.out.println("Dados adicionados com sucesso!");

		System.out.println("\n=====TESTE 05=====Atualizar os dados de um vendedor");
		Seller seller = sellerDAO.findById(2);
		seller.setName("Alfredo");
		sellerDAO.update(seller);

		System.out.println("\n=====TESTE 06=====Deletar os dados de um vendedor");
		System.out.print("Id: ");
		int id = sc.nextInt();
		sellerDAO.deleteById(id);

		sc.close();
	}
}
