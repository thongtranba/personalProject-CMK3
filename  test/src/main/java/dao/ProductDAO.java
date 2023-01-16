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
	private static final String SELECT_POPULAR_PRODUCT = "select * from product where price < 90 limit 8";
	private static final String SELECT_LATEST_PRODUCT = "select * from product where price < 150 limit 4";
	private static final String SELECT_SERVICE = "select * from product where categoryId = '5' limit 6";
	private static final String SELECT_RELATED_PRODUCTS = "select * from product where price < 100 limit 8";
	private static final String DELETE_PRODUCT_SQL = "delete from product where id = ?;";
	private static final String UPDATE_PRODUCT_SQL = "update product set name = ?, inventoryQuantity= ?, price= ?, brandId= ?, categoryId =?, description =? where id = ?";

	private static final String SELECT_ALL_PRODUCT = "select * from product";

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

	public List<Product> selectPopularProducts() {
		List<Product> products = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POPULAR_PRODUCT);) {

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

	public List<Product> selectLatestProducts() {
		List<Product> products = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LATEST_PRODUCT);) {

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

	public List<Product> selectService() {
		List<Product> products = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE);) {

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

	public List<Product> selectRelatedProducts() {
		List<Product> products = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RELATED_PRODUCTS);) {

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

	private static final String COUNT_CATEGORY_PRODUCTS = "select count(*) from product where categoryId=? ";

	public int totalCategoryProduct(int categoryId) {
		int totalProducts = 0;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(COUNT_CATEGORY_PRODUCTS);) {
			preparedStatement.setInt(1, categoryId);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				totalProducts = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalProducts;
	}

	private static final String SELECT_PRODUCT_BY_CATEGORYID = "select * from product where categoryId =? limit ?,?";

	public List<Product> selectAllProductByCategoryId(int categoryId, int pageId, int itemPerPage) {
		int startItem = (pageId - 1) * itemPerPage;
		List<Product> products = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_CATEGORYID);) {
			preparedStatement.setInt(1, categoryId);
			preparedStatement.setInt(2, startItem);
			preparedStatement.setInt(3, itemPerPage);
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

	private static final String SEARCH_PRODUCTS = "select * from product join brand on brand.id = product.brandId where product.name = ? or brand.name = ?";

	public List<Product> searchProducts(String searchString) {
		List<Product> products = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCTS);) {
			preparedStatement.setString(1, searchString);
			preparedStatement.setString(2, searchString);
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

	private static final String SELECT_PRODUCT_BY_ORDER_ID = "select * from product join orderItem on orderItem.productId = product.id join bathongshop.order on bathongshop.order.id = orderItem.orderId where bathongshop.order.id = ?";

	public List<Product> selectAllProductByOrderId(int orderId) {
		List<Product> products = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ORDER_ID);) {
			preparedStatement.setInt(1, orderId);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String image = rs.getString("image");
				products.add(new Product(id, name, price, image));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

}
