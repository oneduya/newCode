package com.designPattern.decorate;

/**
 * @ClassName: MilkDecorater
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/7/10 20:51
 * @Version: V0.1
 */
public class MilkDecorater implements MilkTea {
	private MilkTea milkTea;
	public MilkDecorater(MilkTea milkTea) {
		this.milkTea = milkTea;
	}

	@Override
	public String getDescription() {
		return milkTea.getDescription();
	}

	@Override
	public double getPrice() {
		return milkTea.getPrice();
	}
}
