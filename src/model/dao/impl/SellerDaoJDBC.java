package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
				Department dep = instantiateDepartment(rs);
				return instantiateSeller(rs, dep);
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

	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setDepartment(dep);
		return obj;
	}
	
	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT seller.*, department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE department.Id = ? ORDER BY Name";
			stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, department.getId());
			
			rs = stmt.executeQuery();
			
			List<Seller> listSeller = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>(); 
			
			while (rs.next()) {
				
				Department dep = map.get(rs.getInt("DepartmentId"));
				
				if (dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				Seller obj = instantiateSeller(rs, dep);
//				listSeller.stream().map(p -> !p.equals(obj));
				listSeller.add(obj);
			}
			return listSeller;
		} 
		catch (SQLException e) {
			throw new DbException("FAILED TO SHOW SELLER DATA cod.:05>>> " + e.getMessage());
		}
		finally {
			DB.closeConnection(stmt, rs);
		}
	}

}
