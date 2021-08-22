package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDAO departmentDAO = DaoFactory.createDepartmentDao();
		Department dep = new Department();

		System.out.println("=====TESTE 01===== \nMostrar dados do departamento específico");
		dep = departmentDAO.findById(3);
		System.out.println(dep);
		
	}

}
