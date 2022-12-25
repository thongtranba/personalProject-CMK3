package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.JDBCUtil;
import model.Product;


public class ProductDAO {
	

	private static final String INSERT_PRODUCT_SQL = "INSERT INTO product"
			+ "  (name, inventoryQuantity, price, brandId, categoryId, description) VALUES " + " (?, ?, ?, ?, ?, ?);";
	private static final String SELECT_PRODUCT_BY_ID = "select product.*, brand.name as brandName from product join brand on product.brandId = brand.id where product.id =?";
	private static final String SELECT_ALL_PRODUCT = "select * from product";
	private static final String DELETE_PRODUCT_SQL = "delete from product where id = ?;";
	private static final String UPDATE_PRODUCT_SQL = "update product set name = ?, inventoryQuantity= ?, price= ?, brandId= ?, categoryId =?, description =? where id = ?";
	private static final String SELECT_PRODUCT_BY_CATEGORYID = "select * from product where categoryId =?";
	
	

	public void insertProduct(Product product) throws SQLException {
		System.out.println(INSERT_PRODUCT_SQL);
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
			preparedStatement.setString(1, product.getName());
			preparedStatement.setInt(2, product.getInventory_quantity());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setInt(4, product.getBrandId());
			preparedStatement.setInt(5, product.getCategoryId());
			preparedStatement.setString(6, product.getDescription());
			preparedStatement.setString(7, product.getImage());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean updateProduct(Product product) throws SQLException {

		boolean rowUpdated;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL)) {
			statement.setString(1, product.getName());
			statement.setInt(2, product.getInventory_quantity());
			statement.setDouble(3, product.getPrice());
			statement.setInt(4, product.getBrandId());
			statement.setInt(5, product.getCategoryId());
			statement.setString(6, product.getDescription());
			statement.setInt(7, product.getId());
			statement.setString(8, product.getImage());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	public boolean deleteProduct(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public Product selectProduct(int id) {
		Product product = null;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				int inventory_quantity = rs.getInt("inventory_quantity");
				double price = rs.getDouble("price");
				String brandName = rs.getString("brandName");
				int categoryId = rs.getInt("categoryId");
				String description = rs.getString("description");
				String image = rs.getString("image");
				product = new Product(id, name, inventory_quantity, price, brandName, categoryId, description, image);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	

	public List<Product> selectAllProducts() {
		List<Product> products = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
			
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int inventory_quantity = rs.getInt("inventory_quantity");
				double price = rs.getDouble("price");
				int brandId = rs.getInt("brandId");
				int categoryId = rs.getInt("categoryId");
				String description = rs.getString("description");
				String image = rs.getString("image");
				products.add(new Product(id, name, inventory_quantity, price, brandId, categoryId, description, image));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	public List<Product> selectAllProductByCategoryId(int categoryId) {
		List<Product> products = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_CATEGORYID);) {
			preparedStatement.setInt(1, categoryId);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int inventory_quantity = rs.getInt("inventory_quantity");
				double price = rs.getDouble("price");
				int brandId = rs.getInt("brandId");
				String description = rs.getString("description");
				String image = rs.getString("image");
				products.add(new Product(id, name, inventory_quantity, price, brandId, categoryId, description, image));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	
	

}
