package com.designPattern.decorate;

/**
 * @ClassName: QQMT
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/7/10 20:50
 * @Version: V0.1
 */
public class QQMT implements MilkTea {
	private String description = "QQ奶茶";
	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public double getPrice() {
		return 10;
	}
}
