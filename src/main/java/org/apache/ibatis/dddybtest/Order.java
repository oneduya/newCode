package org.apache.ibatis.dddybtest;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: Order
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/6/27 11:14
 * @Version: V0.1
 */
public class Order {
	private Integer id;
	private Long userId;
	private String orderNumber;
	private Date created;
	private Date updated;
	private User user;
	private List<OrderDetail> detailList;

	public List<OrderDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<OrderDetail> detailList) {
		this.detailList = detailList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", userId=" + userId +
				", orderNumber='" + orderNumber + '\'' +
				", created=" + created +
				", updated=" + updated +
				'}';
	}
}
