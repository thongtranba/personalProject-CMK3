package bathongshop.constant;

public enum ConstantVariableEnum {
	
	CONSTANT_1(1), CONSTANT_0(0);

	private int value;

	private ConstantVariableEnum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
