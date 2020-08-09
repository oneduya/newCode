package com.designPattern.enumtest;

/**
 * @ClassName: Pizza
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/6/30 10:47
 * @Version: V0.1
 */
public class Pizza {
	private PizzaStatus status;

	public void setStatus(PizzaStatus status) {
		this.status = status;
	}

	public enum PizzaStatus {
		ORDERED (5) {
			@Override
			public boolean isOrdered() {
				return true;
			}
		},
		READY (2){
			@Override
			public boolean isReady() {
				return true;
			}
		},
		DELIVERED (0){
			@Override
			public boolean isDelivered() {
				return true;
			}
		};
		private int timeToDelivery;

		public boolean isOrdered() {return false;}

		public boolean isReady() {return false;}

		public boolean isDelivered(){return false;}

		public int getTimeToDelivery() {
			return timeToDelivery;
		}

		PizzaStatus (int timeToDelivery) {
			this.timeToDelivery = timeToDelivery;
		}
	}

	public boolean isDeliverable() {
		return this.status.isReady();
	}

	public void printTimeToDeliver() {
		System.out.println("Time to delivery is " +
				this.getStatus().getTimeToDelivery());
	}

	public PizzaStatus getStatus() {
		return status;
	}

	public static void main(String[] args) {
		Pizza pizza = new Pizza();
		pizza.setStatus(PizzaStatus.READY);
		if(pizza.isDeliverable()) {
			pizza.printTimeToDeliver();
		}
	}
}
