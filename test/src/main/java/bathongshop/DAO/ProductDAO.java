package bathongshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.*;

import bathongshop.JDBCUtil.JDBCUtil;
import bathongshop.constant.PublicConstant;
import bathongshop.entity.Product;
import bathongshop.model.ProductModel;

public class ProductDAO {
	private static Logger logger = LogManager.getLogger(ProductDAO.class);

	public List<Product> selectAllProducts() {
		List<Product> products = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(PublicConstant.SELECT_ALL_PRODUCT);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(PublicConstant.ID);
				String name = rs.getString(PublicConstant.NAME_COLUMN);
				int inventoryQuantity = rs.getInt(PublicConstant.INVENTORY_QUANTITY_COLUMN);
				double price = rs.getDouble(PublicConstant.PRICE_COLUMN);
				double discountPrice = rs.getDouble(PublicConstant.DISCOUNT_PRICE_COLUMN);
				int brandId = rs.getInt(PublicConstant.BRAND_ID_COLUMN);
				int categoryId = rs.getInt(PublicConstant.CATEGORY_ID_COLUMN);
				String description = rs.getString(PublicConstant.DESCRIPTION_COLUMN);
				String image = rs.getString(PublicConstant.IMAGE_COLUMN);
				products.add(new Product(id, name, inventoryQuantity, price, discountPrice, brandId, categoryId,
						description, image));
			}
		} catch (Exception e) {
			logger.info("Infor message!", e);
			logger.warn("Warn message!", e);
			logger.error("Exceptions happen!", e);
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
			logger.info("Infor message!", e);
			logger.warn("Warn message!", e);
			logger.error("Exceptions happen!", e);
		}
	}

	public int takeInventoryQuantity(int productId) {
		int inventoryQuantity = Integer.parseInt(PublicConstant.CONSTANT_0);
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(PublicConstant.TAKE_INVENTORY_QUANTITY)) {
			preparedStatement.setInt(1, productId);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				inventoryQuantity = rs.getInt(PublicConstant.INVENTORY_QUANTITY_COLUMN);
			}
		} catch (Exception e) {
			logger.info("Infor message!", e);
			logger.warn("Warn message!", e);
			logger.error("Exceptions happen!", e);
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
			rowUpdated = preparedStatement.executeUpdate() > Integer.parseInt(PublicConstant.CONSTANT_0);
		}
		return rowUpdated;
	}

	public boolean deleteProduct(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(PublicConstant.DELETE_PRODUCT_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > Integer.parseInt(PublicConstant.CONSTANT_0);
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
				String name = rs.getString(PublicConstant.NAME_COLUMN);
				int inventoryQuantity = rs.getInt(PublicConstant.INVENTORY_QUANTITY_COLUMN);
				double price = rs.getDouble(PublicConstant.PRICE_COLUMN);
				double discountPrice = rs.getDouble(PublicConstant.DISCOUNT_PRICE_COLUMN);
				String brandName = rs.getString(PublicConstant.BRAND_NAME_COLUMN);
				String categoryName = rs.getString(PublicConstant.CATEGORY_NAME_COLUMN);
				String description = rs.getString(PublicConstant.DESCRIPTION_COLUMN);
				String image = rs.getString(PublicConstant.IMAGE_COLUMN);
				product = new ProductModel(id, name, inventoryQuantity, price, discountPrice, description, image,
						brandName, categoryName);
			}
		} catch (Exception e) {
			logger.info("Infor message!", e);
			logger.warn("Warn message!", e);
			logger.error("Exceptions happen!", e);
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
				int id = rs.getInt(PublicConstant.ID);
				String name = rs.getString(PublicConstant.NAME_COLUMN);
				int inventoryQuantity = rs.getInt(PublicConstant.INVENTORY_QUANTITY_COLUMN);
				double price = rs.getDouble(PublicConstant.PRICE_COLUMN);
				double discountPrice = rs.getDouble(PublicConstant.DISCOUNT_PRICE_COLUMN);
				int brandId = rs.getInt(PublicConstant.BRAND_ID_COLUMN);
				int categoryId = rs.getInt(PublicConstant.CATEGORY_ID_COLUMN);
				String description = rs.getString(PublicConstant.DESCRIPTION_COLUMN);
				String image = rs.getString(PublicConstant.IMAGE_COLUMN);
				products.add(new Product(id, name, inventoryQuantity, price, discountPrice, brandId, categoryId,
						description, image));
			}
		} catch (Exception e) {
			logger.info("Infor message!", e);
			logger.warn("Warn message!", e);
			logger.error("Exceptions happen!", e);
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
				int id = rs.getInt(PublicConstant.ID);
				String name = rs.getString(PublicConstant.NAME_COLUMN);
				int inventoryQuantity = rs.getInt(PublicConstant.INVENTORY_QUANTITY_COLUMN);
				double price = rs.getDouble(PublicConstant.PRICE_COLUMN);
				double discountPrice = rs.getDouble(PublicConstant.DISCOUNT_PRICE_COLUMN);
				int brandId = rs.getInt(PublicConstant.BRAND_ID_COLUMN);
				int categoryId = rs.getInt(PublicConstant.CATEGORY_ID_COLUMN);
				String description = rs.getString(PublicConstant.DESCRIPTION_COLUMN);
				String image = rs.getString(PublicConstant.IMAGE_COLUMN);
				products.add(new Product(id, name, inventoryQuantity, price, discountPrice, brandId, categoryId,
						description, image));
			}
		} catch (Exception e) {
			logger.info("Infor message!", e);
			logger.warn("Warn message!", e);
			logger.error("Exceptions happen!", e);
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
				int id = rs.getInt(PublicConstant.ID);
				String name = rs.getString(PublicConstant.NAME_COLUMN);
				int inventoryQuantity = rs.getInt(PublicConstant.INVENTORY_QUANTITY_COLUMN);
				double price = rs.getDouble(PublicConstant.PRICE_COLUMN);
				double discountPrice = rs.getDouble(PublicConstant.DISCOUNT_PRICE_COLUMN);
				int brandId = rs.getInt(PublicConstant.BRAND_ID_COLUMN);
				int categoryId = rs.getInt(PublicConstant.CATEGORY_ID_COLUMN);
				String description = rs.getString(PublicConstant.DESCRIPTION_COLUMN);
				String image = rs.getString(PublicConstant.IMAGE_COLUMN);
				products.add(new Product(id, name, inventoryQuantity, price, discountPrice, brandId, categoryId,
						description, image));
			}
		} catch (Exception e) {
			logger.info("Infor message!", e);
			logger.warn("Warn message!", e);
			logger.error("Exceptions happen!", e);
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
				int id = rs.getInt(PublicConstant.ID);
				String name = rs.getString(PublicConstant.NAME_COLUMN);
				int inventoryQuantity = rs.getInt(PublicConstant.INVENTORY_QUANTITY_COLUMN);
				double price = rs.getDouble(PublicConstant.PRICE_COLUMN);
				double discountPrice = rs.getDouble(PublicConstant.DISCOUNT_PRICE_COLUMN);
				int brandId = rs.getInt(PublicConstant.BRAND_ID_COLUMN);
				int categoryId = rs.getInt(PublicConstant.CATEGORY_ID_COLUMN);
				String description = rs.getString(PublicConstant.DESCRIPTION_COLUMN);
				String image = rs.getString(PublicConstant.IMAGE_COLUMN);
				products.add(new Product(id, name, inventoryQuantity, price, discountPrice, brandId, categoryId,
						description, image));
			}
		} catch (Exception e) {
			logger.info("Infor message!", e);
			logger.warn("Warn message!", e);
			logger.error("Exceptions happen!", e);
		}
		return products;
	}

	public int totalCategoryProduct(int categoryId) {
		int totalProducts = Integer.parseInt(PublicConstant.CONSTANT_0);
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection
						.prepareStatement(PublicConstant.COUNT_CATEGORY_PRODUCTS);) {
			preparedStatement.setInt(1, categoryId);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				totalProducts = rs.getInt(PublicConstant.COUNT_ALL);
			}
		} catch (Exception e) {
			logger.info("Infor message!", e);
			logger.warn("Warn message!", e);
			logger.error("Exceptions happen!", e);
		}
		return totalProducts;
	}

	public List<Product> selectAllProductByCategoryId(int categoryId, int startItem, int itemPerPage, String sortColumn,
			String sortType, int brandId) {
		List<Product> products = new ArrayList<>();
		if (brandId == Integer.parseInt(PublicConstant.CONSTANT_0)) {
			try (Connection connection = JDBCUtil.getConnection();
					PreparedStatement preparedStatement = connection
							.prepareStatement(PublicConstant.SELECT_PRODUCT_ORDER_BY + sortColumn + sortType
									+ PublicConstant.SELECT_PRODUCT_LIMIT);) {
				preparedStatement.setInt(1, categoryId);
				preparedStatement.setInt(2, startItem);
				preparedStatement.setInt(3, itemPerPage);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					int id = rs.getInt(PublicConstant.ID);
					String name = rs.getString(PublicConstant.NAME_COLUMN);
					int inventoryQuantity = rs.getInt(PublicConstant.INVENTORY_QUANTITY_COLUMN);
					double price = rs.getDouble(PublicConstant.PRICE_COLUMN);
					double discountPrice = rs.getDouble(PublicConstant.DISCOUNT_PRICE_COLUMN);
					String description = rs.getString(PublicConstant.DESCRIPTION_COLUMN);
					String image = rs.getString(PublicConstant.IMAGE_COLUMN);
					products.add(new Product(id, name, inventoryQuantity, price, discountPrice, brandId, categoryId,
							description, image));
				}
			} catch (Exception e) {
				logger.info("Infor message!", e);
				logger.warn("Warn message!", e);
				logger.error("Exceptions happen!", e);
			}
		} else {
			try (Connection connection = JDBCUtil.getConnection();
					PreparedStatement preparedStatement = connection
							.prepareStatement(PublicConstant.SELECT_PRODUCT_ORDER_BY_WITH_BRANDID + sortColumn
									+ sortType + PublicConstant.SELECT_PRODUCT_LIMIT);) {
				preparedStatement.setInt(1, categoryId);
				preparedStatement.setInt(2, brandId);
				preparedStatement.setInt(3, startItem);
				preparedStatement.setInt(4, itemPerPage);
				System.out.println(preparedStatement);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					int id = rs.getInt(PublicConstant.ID);
					String name = rs.getString(PublicConstant.NAME_COLUMN);
					int inventoryQuantity = rs.getInt(PublicConstant.INVENTORY_QUANTITY_COLUMN);
					double price = rs.getDouble(PublicConstant.PRICE_COLUMN);
					double discountPrice = rs.getDouble(PublicConstant.DISCOUNT_PRICE_COLUMN);
					String image = rs.getString(PublicConstant.IMAGE_COLUMN);
					products.add(new Product(id, name, inventoryQuantity, price, discountPrice, categoryId, image));
				}

			} catch (Exception e) {
				logger.info("Infor message!", e);
				logger.warn("Warn message!", e);
				logger.error("Exceptions happen!", e);
			}
		}
		return products;
	}

	public List<Product> searchProducts(String searchString) {
		List<Product> products = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(PublicConstant.SEARCH_PRODUCTS);) {
			preparedStatement.setString(1, PublicConstant.SEARCH_SYMBOL + searchString + PublicConstant.SEARCH_SYMBOL);
			preparedStatement.setString(2, PublicConstant.SEARCH_SYMBOL + searchString + PublicConstant.SEARCH_SYMBOL);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(PublicConstant.ID);
				String name = rs.getString(PublicConstant.NAME_COLUMN);
				int inventoryQuantity = rs.getInt(PublicConstant.INVENTORY_QUANTITY_COLUMN);
				double price = rs.getDouble(PublicConstant.PRICE_COLUMN);
				double discountPrice = rs.getDouble(PublicConstant.DISCOUNT_PRICE_COLUMN);
				int brandId = rs.getInt(PublicConstant.BRAND_ID_COLUMN);
				int categoryId = rs.getInt(PublicConstant.CATEGORY_ID_COLUMN);
				String description = rs.getString(PublicConstant.DESCRIPTION_COLUMN);
				String image = rs.getString(PublicConstant.IMAGE_COLUMN);
				products.add(new Product(id, name, inventoryQuantity, price, discountPrice, brandId, categoryId,
						description, image));
			}

		} catch (Exception e) {
			logger.info("Infor message!", e);
			logger.warn("Warn message!", e);
			logger.error("Exceptions happen!", e);
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
				int id = rs.getInt(PublicConstant.ID);
				String name = rs.getString(PublicConstant.NAME_COLUMN);
				int inputQuantity = rs.getInt(PublicConstant.ORDER_QUANTITY);
				double price = rs.getDouble(PublicConstant.PRICE_COLUMN);
				double discountPrice = rs.getDouble(PublicConstant.DISCOUNT_PRICE_COLUMN);
				String image = rs.getString(PublicConstant.IMAGE_COLUMN);
				products.add(new ProductModel(id, name, inputQuantity, price, discountPrice, image));
			}
		} catch (Exception e) {
			logger.info("Infor message!", e);
			logger.warn("Warn message!", e);
			logger.error("Exceptions happen!", e);
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
				int id = rs.getInt(PublicConstant.ID);
				String name = rs.getString(PublicConstant.NAME_COLUMN);
				int inventoryQuantity = rs.getInt(PublicConstant.INVENTORY_QUANTITY_COLUMN);
				double price = rs.getDouble(PublicConstant.PRICE_COLUMN);
				double discountPrice = rs.getDouble(PublicConstant.DISCOUNT_PRICE_COLUMN);
				int brandId = rs.getInt(PublicConstant.BRAND_ID_COLUMN);
				int categoryId = rs.getInt(PublicConstant.CATEGORY_ID_COLUMN);
				String description = rs.getString(PublicConstant.DESCRIPTION_COLUMN);
				String image = rs.getString(PublicConstant.IMAGE_COLUMN);
				products.add(new Product(id, name, inventoryQuantity, price, discountPrice, brandId, categoryId,
						description, image));
			}
		} catch (Exception e) {
			logger.info("Infor message!", e);
			logger.warn("Warn message!", e);
			logger.error("Exceptions happen!", e);
		}
		return products;
	}

}
