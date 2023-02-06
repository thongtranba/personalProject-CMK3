package bathongshop.entity;

public class Staff {
	private int id;
	private String userName;
	private String password;
	private String mobile;
	private String email;
	private int roleId;

	public Staff(int id, String mobile, String email, String userName, String password, int roleId) {
		super();
		this.id = id;

		this.mobile = mobile;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
	}

	public Staff() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
