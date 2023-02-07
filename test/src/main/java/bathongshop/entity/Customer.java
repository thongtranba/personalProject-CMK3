package bathongshop.entity;

public class Customer {
	private int id;
	private String username;
	private String password;
	private String mobile;
	private String email;
	private String address;

	public Customer() {
		super();
	}

	public Customer(int id, String username, String mobile, String email, String address) {
		super();
		this.id = id;
		this.username = username;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
	}

	public Customer(String username, String password, String mobile, String email, String address) {
		super();
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
	}

	public Customer(int id, String username, String password, String mobile, String email, String address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}