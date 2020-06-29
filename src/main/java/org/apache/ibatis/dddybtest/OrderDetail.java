package org.apache.ibatis.dddybtest;

/**
 * @ClassName: OrderDetail
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/6/27 14:27
 * @Version: V0.1
 */
public class OrderDetail {
	private Integer id;
	private Integer orderId;
	private Double totalPrice;
	private Integer status;
	private Item item;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "OrderDetail{" +
				"id=" + id +
				", orderId=" + orderId +
				", totalPrice=" + totalPrice +
				", status=" + status +
				", item=" + item +
				'}';
	}
}
