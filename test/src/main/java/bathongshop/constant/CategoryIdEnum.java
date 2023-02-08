package bathongshop.constant;

public enum CategoryIdEnum {
	CATEGORYID_DEFAULT(0), RACKETS_CATEGORYID(1), BAGS_CATEGORYID(2), CLOTHING_CATEGORYID(3), SHOES_CATEGORYID(4),
	STRING_CATEGORYID(5);

	int value;

	private CategoryIdEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
