package com.designPattern.templatePattern;

/**
 * @ClassName: SingletonDemo
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/7/4 19:29
 * @Version: V0.1
 */
public class SingletonDemo {

	static class GetHandler {
		private static SingletonDemo instance = new SingletonDemo();
	}

	public static SingletonDemo getInstance() {
		return GetHandler.instance;
	}

	public static void main(String[] args) {
		SingletonDemo.getInstance();
	}
}
