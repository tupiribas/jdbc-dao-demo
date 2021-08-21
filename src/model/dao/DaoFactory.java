package model.dao;

import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	public static DepartmentDAO createDepartmentDao() {
		return new DepartmentDaoJDBC();
	}
	
	public static SellerDAO createSellerDao() {
		return new SellerDaoJDBC();
	}
}
