package bathongshop.constant;

public enum ConstantIntegerEnum {
	
	CONSTANT_1(1), CONSTANT_0(0);

	private int value;

	private ConstantIntegerEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
