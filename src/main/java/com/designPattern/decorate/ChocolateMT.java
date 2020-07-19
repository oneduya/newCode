package com.designPattern.decorate;

/**
 * @ClassName: ChocolateMT
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/7/10 20:48
 * @Version: V0.1
 */
public class ChocolateMT implements MilkTea {
	private String description = "巧克力奶茶";
	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public double getPrice() {
		return 15;
	}
}
