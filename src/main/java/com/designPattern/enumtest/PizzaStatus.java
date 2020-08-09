package com.designPattern.enumtest;

public enum PizzaStatus {
	ORDERED,
	READY,
	DELIVERED;

	public static void main(String[] args) {
		System.out.println(PizzaStatus.ORDERED.name());
		System.out.println(PizzaStatus.ORDERED);
		System.out.println(PizzaStatus.ORDERED.name().getClass());
		System.out.println(PizzaStatus.ORDERED.getClass());
	}
}
