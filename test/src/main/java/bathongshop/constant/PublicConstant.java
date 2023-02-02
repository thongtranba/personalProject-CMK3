package bathongshop.constant;

public class PublicConstant {

	// JDBCUtil
//	public static final String jdbcURL = "jdbc:mysql://db-mysql-bathongshop-do-user-13241251-0.b.db.ondigitalocean.com:25060/bathongshop?useSSL=false";
//	public static final String jdbcUsername = "doadmin";
//	public static final String jdbcPassword = "AVNS_uDp9UhuFWJQLdR-OqdU";
	public static final String jdbcURL = "jdbc:mysql://localhost:3306/bathongshop?useSSL=false";
	public static final String jdbcUsername = "bathong";
	public static final String jdbcPassword = "123123";

	// BrandDAO
	public static final String SELECT_ALL_BRAND = "select * from brand";

	// CustomerDAO
	public static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer"
			+ "  (username, password, mobile, email, address) VALUES " + " (?, ?, ?, ?, ?)";
	public static final String SELECT_ALL_CUSTOMER = "select * from customer";
	public static final String SELECT_CUSTOMER_BY_ID = "select id, username, password, mobile, email, address from customer where id =?";
	public static final String DELETE_CUSTOMER_SQL = "delete from customer where id =?";
	public static final String UPDATE_CUSTOMER_SQL = "update customer set username =?, password=?, mobile=?, email=?, address =? where id =?";
	public static final String LOGIN_BY_USERNAME_PASSWORD = "select * from customer where email = ? and password = ? ";

	// OrderDAO
	public static final String INSERT_NEW_ORDER = "INSERT INTO `order` (customer_id, created_date) VALUES (?, ?)";
	public static final String SELECT_ORDER_BY_CUTOMER_ID = "select * from bathongshop.order where customer_id = ?";

	// OrderItemDAO
	public static final String INSERT_ORDER_ITEM = "INSERT order_item (order_id, product_id, quantity) VALUES (?, ?, ?)";

	// ProductDAO
	public static final String SELECT_ALL_PRODUCT = "select * from product";
	public static final String INSERT_PRODUCT_SQL = "INSERT INTO product"
			+ "  (name, inventory_quantity, price, brand_id, category_id, description) VALUES "
			+ " (?, ?, ?, ?, ?, ?);";
	public static final String TAKE_INVENTORY_QUANTITY = "select product.inventory_quantity from product"
			+ " where id = ?";
	public static final String UPDATE_QUANTITY_BY_PRODUCTID = "update product set  inventory_quantity= ? where id =?";
	public static final String DELETE_PRODUCT_SQL = "delete from product where id = ?";
	public static final String SELECT_PRODUCT_BY_ID = "select product.*, brand.name as brandName, category.name as categoryName from product"
			+ " join brand on product.brand_id = brand.id" + " join category on product.category_id = category.id"
			+ " where product.id =?";
	public static final String SELECT_POPULAR_PRODUCT = "select * from product where price < 90 limit 8";
	public static final String SELECT_LATEST_PRODUCT = "select * from product where price < 100 and discount_price = 0 limit 4";
	public static final String SELECT_SERVICE = "select * from product where category_id = '5' limit 6";
	public static final String SELECT_RELATED_PRODUCTS = "select * from product where price < 100 limit 8";
	public static final String COUNT_CATEGORY_PRODUCTS = "select count(*) from product where category_id=? ";
	public static final String SEARCH_PRODUCTS = "select * from product join brand on brand.id = product.brand_id where product.name like ? or brand.name like ? ";
	public static final String SELECT_PRODUCT_BY_ORDER_ID = "select product.id, product.name, product.price, product.discount_price,product.image, order_item.quantity from product "
			+ " join order_item on order_item.product_id = product.id "
			+ " join bathongshop.order on bathongshop.order.id = order_item.order_id"
			+ " where bathongshop.order.id = ?";
	public static final String SELECT_SALE_OFF_PRODDUCTS = "select * from product where discount_price > '0' ";

	// Authentication controller
	public static final String AUTH_URL = "/authentication";
	public static final String LOGIN = "LOGIN";
	public static final String LOGOUT = "LOGOUT";
	public static final String REGISTER = "REGISTER";
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String LOGIN_NOTIFICATION = "loginNotification";
	public static final String LOGIN_NOTIFICATION_MESSAGE = "Login fail!!";
	public static final String CUSTOMERID = "customerId";
	public static final String USERNAME = "username";
	public static final String MOBILE = "mobile";
	public static final String ADDRESS = "address";
	public static final String REGISTER_NOTIFICATION = "registerNotification";
	public static final String REGISTER_NOTIFICATION_MESSAGE = "Registered Successfully!";

	// Cart controller
	public static final String CART_URL = "/cart";
	public static final String ADD_TO_CART = "ADD_TO_CART";
	public static final String REMOVE = "REMOVE";
	public static final String SUBMIT_CART = "SUBMIT_CART";
	public static final String MY_ORDER = "MY_ORDER";
	public static final String MY_ORDER_DETAILS = "MY_ORDER_DETAILS";
	public static final String PRODUCTID = "productId";
	public static final String JSON_STRING = "JSONString";
	public static final String CART = "cart";
	public static final String ADD_TO_CART_NOTIFICATION_MESSAGE = "you added to cart! check your cart.";
	public static final String PRODUCT = "product";
	public static final String ADD_TO_CART_NOTIFICATION = "notification";
	public static final String PRODUCT_DETAIL_PAGE_BY_ID = "product?id=";
	public static final String ORDER_LIST = "orderList";
	public static final String ORDER_ID = "orderId";

	// Category controller
	public static final String CATEGORY_URL = "/category";
	public static final String CATEGORY_COMMAND = "CATEGORY";
	public static final String SALEOFF_COMMAND = "SALEOFF";
	public static final String CATEGORY_PARAMETER = "category";
	public static final String PAGEID_PARAMETER = "pageId";
	public static final String SORT_PARAMETER = "sort";
	public static final String BRAND_ID = "brandId";
	public static final String CATEGORYID_DEFAULT = "0";
	public static final String RACKETS_PAGE_COMMAND = "rackets";
	public static final String BAGS_PAGE_COMMAND = "bags";
	public static final String CLOTHING_PAGE_COMMAND = "clothing";
	public static final String SHOES_PAGE_COMMAND = "shoes";
	public static final String STRING_PAGE_COMMAND = "strings";
	public static final String RACKETS_CATEGORYID = "1";
	public static final String BAGS_CATEGORYID = "2";
	public static final String CLOTHING_CATEGORYID = "3";
	public static final String SHOES_CATEGORYID = "4";
	public static final String STRING_CATEGORYID = "5";
	public static final String DEFAULT_COMMAND = "Default";
	public static final String PRICE_ASC_COMMAND = "Price ASC";
	public static final String PRICE_DESC_COMMAND = "Price DESC";
	public static final String AZ_COMMAND = "AZ";
	public static final String ZA_COMMAND = "ZA";
	public static final String PRICE_COLUMN = "price";
	public static final String NAME_COLUMN = "name";
	public static final String ASC = " ASC";
	public static final String DESC = " DESC";
	public static final String ITEM_PER_PAGE = "9";
	public static final String CONSTANT_1 = "1";
	public static final String CONSTANT_DOUBLE_1 = "1.0";
	public static final String BRAND_LIST = "brandList";
	public static final String SORT_SELECT = "sortSelect";
	public static final String SORT_SELECTED = "sortSelected";
	public static final String CATEGORY_PAGE = "categoryPage";
	public static final String CATEGORY_LIST = "categoryList";
	public static final String TOTAL_PAGE = "totalPage";
	public static final String CURRENT_PAGE = "currentPage";
	public static final String SALE_OFF_PRODUCT = "saleOffProduct";

	// Home controller
	public static final String HOME_URL = "/home";

	// shared variables
	public static final String COMMAND = "command";
	public static final String ID = "id";
	public static final String EMPTY_STRING = "";

	// JSP
	public static final String NOTIFICATION_JSP = "notification.jsp";
	public static final String PAYMENT_JSP = "payment.jsp";
	public static final String MY_PURCHASE_JSP = "my-purchase.jsp";
	public static final String MY_ORDER_DETAIL_JSP = "my-order-detail.jsp";
	public static final String CATEGORY_JSP = "category.jsp";
	public static final String SALEOFF_JSP = "sale-off-product.jsp";

}
