package bathongshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bathongshop.JDBCUtil.JDBCUtil;
import bathongshop.constant.PublicConstant;
import bathongshop.entity.Product;
import bathongshop.model.ProductModel;

public class ProductDAO {

	public List<Product> selectAllProducts() {
		List<Product> products = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(PublicConstant.SELECT_ALL_PRODUCT);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int inventoryQuantity = rs.getInt("inventory_quantity");
				double price = rs.getDouble("price");
				double discountPrice = rs.getDouble("discount_price");
				int brandId = rs.getInt("brand_id");
				int categoryId = rs.getInt("category_id");
				String description = rs.getString("description");
				String image = rs.getString("image");
				products.add(new Product(id, name, inventoryQuantity, price, discountPrice, brandId, categoryId,
						description, image));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public void insertProduct(Product product) throws SQLException {
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(PublicConstant.INSERT_PRODUCT_SQL)) {
			preparedStatement.setString(1, product.getName());
			preparedStatement.setInt(2, product.getInventoryQuantity());
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

	public int takeInventoryQuantity(int productId) {
		int inventoryQuantity = 0;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(PublicConstant.TAKE_INVENTORY_QUANTITY)) {
			preparedStatement.setInt(1, productId);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				inventoryQuantity = rs.getInt("inventory_quantity");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inventoryQuantity;
	}

	public boolean updateQuantityByProductId(int productId, int quantity) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(PublicConstant.UPDATE_QUANTITY_BY_PRODUCTID)) {
			preparedStatement.setInt(1, quantity);
			preparedStatement.setInt(2, productId);
			System.out.println(preparedStatement);
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	public boolean deleteProduct(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(PublicConstant.DELETE_PRODUCT_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public ProductModel selectProduct(int id) {
		ProductModel product = null;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(PublicConstant.SELECT_PRODUCT_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				int inventoryQuantity = rs.getInt("inventory_quantity");
				double price = rs.getDouble("price");
				double discountPrice = rs.getDouble("discount_price");
				String brandName = rs.getString("brandName");
				String categoryName = rs.getString("categoryName");
				String description = rs.getString("description");
				String image = rs.getString("image");
				product = new ProductModel(id, name, inventoryQuantity, price, discountPrice, description, image,
						brandName, categoryName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	public List<Product> selectPopularProducts() {
		List<Product> products = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(PublicConstant.SELECT_POPULAR_PRODUCT);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int inventoryQuantity = rs.getInt("inventory_quantity");
				double price = rs.getDouble("price");
				double discountPrice = rs.getDouble("discount_price");
				int brandId = rs.getInt("brand_id");
				int categoryId = rs.getInt("category_id");
				String description = rs.getString("description");
				String image = rs.getString("image");
				products.add(new Product(id, name, inventoryQuantity, price, discountPrice, brandId, categoryId,
						description, image));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public List<Product> selectLatestProducts() {
		List<Product> products = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(PublicConstant.SELECT_LATEST_PRODUCT);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int inventoryQuantity = rs.getInt("inventory_quantity");
				double price = rs.getDouble("price");
				double discountPrice = rs.getDouble("discount_price");
				int brandId = rs.getInt("brand_id");
				int categoryId = rs.getInt("category_id");
				String description = rs.getString("description");
				String image = rs.getString("image");
				products.add(new Product(id, name, inventoryQuantity, price, discountPrice, brandId, categoryId,
						description, image));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public List<Product> selectService() {
		List<Product> products = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(PublicConstant.SELECT_SERVICE);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int inventoryQuantity = rs.getInt("inventory_quantity");
				double price = rs.getDouble("price");
				double discountPrice = rs.getDouble("discount_price");
				int brandId = rs.getInt("brand_id");
				int categoryId = rs.getInt("category_id");
				String description = rs.getString("description");
				String image = rs.getString("image");
				products.add(new Product(id, name, inventoryQuantity, price, discountPrice, brandId, categoryId,
						description, image));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public List<Product> selectRelatedProducts() {
		List<Product> products = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(PublicConstant.SELECT_RELATED_PRODUCTS);) {

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int inventoryQuantity = rs.getInt("inventory_quantity");
				double price = rs.getDouble("price");
				double discountPrice = rs.getDouble("discount_price");
				int brandId = rs.getInt("brand_id");
				int categoryId = rs.getInt("category_id");
				String description = rs.getString("description");
				String image = rs.getString("image");
				products.add(new Product(id, name, inventoryQuantity, price, discountPrice, brandId, categoryId,
						description, image));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public int totalCategoryProduct(int categoryId) {
		int totalProducts = 0;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(PublicConstant.COUNT_CATEGORY_PRODUCTS);) {
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

	public List<Product> selectAllProductByCategoryId(int categoryId, int startItem, int itemPerPage, String sortColumn,
			String sortType, int brandId) {
		List<Product> products = new ArrayList<>();
		if (brandId == 0) {
			try (Connection connection = JDBCUtil.getConnection();
					PreparedStatement preparedStatement = connection
							.prepareStatement("select * from product where category_id =?" + "  ORDER by " + sortColumn
									+ sortType + " limit ?,?");) {
				preparedStatement.setInt(1, categoryId);
				preparedStatement.setInt(2, startItem);
				preparedStatement.setInt(3, itemPerPage);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int inventoryQuantity = rs.getInt("inventory_quantity");
					double price = rs.getDouble("price");
					double discountPrice = rs.getDouble("discount_price");
					brandId = rs.getInt("brand_id");
					String description = rs.getString("description");
					String image = rs.getString("image");
					products.add(new Product(id, name, inventoryQuantity, price, discountPrice, brandId, categoryId,
							description, image));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try (Connection connection = JDBCUtil.getConnection();
					PreparedStatement preparedStatement = connection.prepareStatement(
							"select product.id, product.name, product.inventory_quantity, product.discount_price, product.price, product.image, brand.name from product "
									+ " join brand on brand.id = product.brand_id"
									+ " where category_id =? and brand.id = ?" + "  ORDER by " + "product." + sortColumn
									+ sortType + " limit ?,?");) {
				preparedStatement.setInt(1, categoryId);
				preparedStatement.setInt(2, brandId);
				preparedStatement.setInt(3, startItem);
				preparedStatement.setInt(4, itemPerPage);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					int inventoryQuantity = rs.getInt("inventory_quantity");
					double price = rs.getDouble("price");
					double discountPrice = rs.getDouble("discount_price");
					String image = rs.getString("image");
					products.add(new Product(id, name, inventoryQuantity, price, discountPrice, categoryId, image));
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return products;
	}

	public List<Product> searchProducts(String searchString) {
		List<Product> products = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(PublicConstant.SEARCH_PRODUCTS);) {
			preparedStatement.setString(1, "%" + searchString + "%");
			preparedStatement.setString(2, "%" + searchString + "%");
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int inventoryQuantity = rs.getInt("inventory_quantity");
				double price = rs.getDouble("price");
				double discountPrice = rs.getDouble("discount_price");
				int brandId = rs.getInt("brand_id");
				int categoryId = rs.getInt("category_id");
				String description = rs.getString("description");
				String image = rs.getString("image");
				products.add(new Product(id, name, inventoryQuantity, price, discountPrice, brandId, categoryId,
						description, image));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public List<ProductModel> selectAllProductByOrderId(int orderId) {
		List<ProductModel> products = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(PublicConstant.SELECT_PRODUCT_BY_ORDER_ID);) {
			preparedStatement.setInt(1, orderId);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int inputQuantity = rs.getInt("quantity");
				double price = rs.getDouble("price");
				double discountPrice = rs.getDouble("discount_price");
				String image = rs.getString("image");
				products.add(new ProductModel(id, name, inputQuantity, price, discountPrice, image));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public List<Product> selectSaleOffProduct() {
		List<Product> products = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(PublicConstant.SELECT_SALE_OFF_PRODDUCTS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int inventoryQuantity = rs.getInt("inventory_quantity");
				double price = rs.getDouble("price");
				double discountPrice = rs.getDouble("discount_price");
				int brandId = rs.getInt("brand_id");
				int categoryId = rs.getInt("category_id");
				String description = rs.getString("description");
				String image = rs.getString("image");
				products.add(new Product(id, name, inventoryQuantity, price, discountPrice, brandId, categoryId,
						description, image));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

}
