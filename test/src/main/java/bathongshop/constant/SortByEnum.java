package bathongshop.constant;

public enum SortByEnum {
	ASC(" ASC"), DESC(" DESC"), PRICE_COLUMN("price"), NAME_COLUMN("name");

	String value;

	private SortByEnum(String value) {
		this.value = value;
	}

	public String getString() {
		return value;
	}

}
