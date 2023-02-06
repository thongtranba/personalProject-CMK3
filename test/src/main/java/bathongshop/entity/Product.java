package bathongshop.entity;

public class Product {
	private int id;
	private String name;
	private int inventoryQuantity;
	private double price;
	private double discountPrice;
	private int brandId;
	private int categoryId;
	private String description;
	private String image;

	public Product(int id, String name, int inventoryQuantity, double price, double discountPrice, int brandId,
			int categoryId, String description, String image) {
		super();
		this.id = id;
		this.name = name;
		this.inventoryQuantity = inventoryQuantity;
		this.price = price;
		this.discountPrice = discountPrice;
		this.brandId = brandId;
		this.categoryId = categoryId;
		this.description = description;
		this.image = image;

	}

	public Product(int id, String name, int inventoryQuantity, double price, double discountPrice, int categoryId,
			String image) {
		super();
		this.id = id;
		this.name = name;
		this.inventoryQuantity = inventoryQuantity;
		this.price = price;
		this.discountPrice = discountPrice;
		this.categoryId = categoryId;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInventoryQuantity() {
		return inventoryQuantity;
	}

	public void setInventoryQuantity(int inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
