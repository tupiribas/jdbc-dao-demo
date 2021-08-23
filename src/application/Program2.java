package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDAO departmentDAO = DaoFactory.createDepartmentDao();
		Department dep = new Department();

		System.out.println("=====TESTE 01===== \nMostrar dados do departamento específico");
		dep = departmentDAO.findById(3);
		System.out.println(dep);
		
		System.out.println("\n=====TESTE 02===== \nMostrar todos dados de departamento");
		List<Department> listDepartments = departmentDAO.findAll();
		for (Department department : listDepartments) {
			System.out.println(department);
		}
		
		System.out.println("\n=====TESTE 03===== \nInserir os dados do departamento");
		System.out.println("Name in new department: ");
		String name = sc.nextLine();
		dep.setName(name);
		departmentDAO.insert(dep);
		System.out.println("Departamento inserido com sucesso!");
		
		System.out.println("\n=====TESTE 04===== \nAtualizar os dados do departamento");
		dep = departmentDAO.findById(6);
		dep.setName("Salada");
		departmentDAO.update(dep);
		System.out.println("Departamento alterado com sucesso");
		
		System.out.println("\n=====TESTE 05===== \nDeletar os dados do departamento");
		System.out.print("Id: ");
		int id = sc.nextInt();
		departmentDAO.deleteById(id);
		System.out.println("Departamento deletado com sucesso");
		
		sc.close();
		
	}

}
