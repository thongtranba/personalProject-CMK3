package model;

public class Product {
	private int id;
	private String name;
	private int inventory_quantity;
	private double price;
	private int brandId;
	private int categoryId;
	private String description;
	private String image;
	private String brandName;

	public Product(int id, String name, int inventory_quantity, double price, int brandId, int categoryId,
			String description, String image) {
		super();
		this.id = id;
		this.name = name;
		this.inventory_quantity = inventory_quantity;
		this.price = price;
		this.brandId = brandId;
		this.categoryId = categoryId;
		this.description = description;
		this.image = image;
	}
	

	public Product(int id, String name, int inventory_quantity, double price, String brandName, int categoryId,
			String description, String image) {
		super();
		this.id = id;
		this.name = name;
		this.inventory_quantity = inventory_quantity;
		this.price = price;
		this.brandName = brandName;
		this.categoryId = categoryId;
		this.description = description;
		this.image = image;
		
	}


	public String getBrandName() {
		return brandName;
	}


	public void setBrandName(String brandName) {
		this.brandName = brandName;
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

	public int getInventory_quantity() {
		return inventory_quantity;
	}

	public void setInventory_quantity(int inventory_quantity) {
		this.inventory_quantity = inventory_quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
