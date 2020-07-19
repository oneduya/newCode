package com.designPattern.decorate;

/**
 * @ClassName: YeguoMilkTea
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/7/10 20:53
 * @Version: V0.1
 */
public class YeguoMilkTea extends MilkDecorater {

	public YeguoMilkTea(MilkTea milkTea) {
		super(milkTea);
	}

	@Override
	public String getDescription() {
		return super.getDescription() + "\n" + "加了椰果";
	}

	@Override
	public double getPrice() {
		return super.getPrice() + 1;
	}

	public static void main(String[] args) {
		MilkTea milkTea = new ChocolateMT();
		MilkTea yeguoMilkTea = new YeguoMilkTea(milkTea);
		System.out.println(yeguoMilkTea.getDescription());
		System.out.println(yeguoMilkTea.getPrice());
	}
}
