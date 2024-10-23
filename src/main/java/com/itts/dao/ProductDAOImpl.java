package com.itts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.itts.model.Product;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public boolean addProduct(Product product) {
		Connection con = DBUtill.getConnection();
		System.out.println("we got connection:" + con);
		boolean status = false;
		String query = "insert into product values(?,?,?)";
		// Get the PreparedStatement object by passing a query with positional
		// parameters.
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			// Now we replace the positional parameters with the values.
			pstmt.setInt(1, product.getPid());
			pstmt.setString(2, product.getPname());
			pstmt.setDouble(3, product.getPrice());

			// Execute the query
			int no = pstmt.executeUpdate();
			status = (no >= 1) ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Product> getAllProducts() {
		// Write the jdbc code to get all the product from the table
		// and store into the list and return it

		Connection con = DBUtill.getConnection();
		String query = "SELECT * FROM PRODUCT";
		List<Product> lists= new ArrayList<Product>();
		try (Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				int pid=rs.getInt("pid");
				String pname=rs.getString("pname");
				double price=rs.getDouble("price");
				//create an object for Product and store the data which you have take from db
				Product product=new Product();
				product.setPid(pid);
				product.setPname(pname);
				product.setPrice(price);
				//Now finally add this product object into the list
				lists.add(product);
				
			}

		} catch (SQLException se) {
			se.printStackTrace();
		}

		return lists;
	}

}
