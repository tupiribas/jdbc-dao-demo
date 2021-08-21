package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDAO {

	private Connection conn = null;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated methasod stub
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT seller.*, department.Name AS DepName " 
					+ "FROM seller INNER JOIN department " 
					+ "ON seller.DepartmentId = department.Id " 
					+ "WHERE seller.Id = ?";
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			if (rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("DepartmentId"));
				dep.setName(rs.getString("DepName"));
				Seller obj = new Seller();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setBirthDate(rs.getDate("BirthDate"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setDepartment(dep);
				return obj;
			}
			return null;
		} 
		catch (SQLException e) {
			throw new DbException("FAILED TO SHOW SELLER DATA cod.:04>>> " + e.getMessage());
		}
		finally {
			DB.closeConnection(stmt, rs);
		}
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
