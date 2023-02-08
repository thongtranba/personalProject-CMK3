package bathongshop.constant;

public enum ConstantDoubleEnum {

	CONSTANT_1(1.0), CONSTANT_0(0),CONSTANT_SHIPPINGFEE(3.9) ;

	private double value;

	private ConstantDoubleEnum(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}
}
