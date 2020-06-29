package org.apache.ibatis.dddybtest;

import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: OrderMapper
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/6/27 11:16
 * @Version: V0.1
 */
public interface OrderMapper {
	OrderUser queryOrderUserByOrderNumber(@Param("number") String number);

	/**
	 * 根据订单号查询订单用户的信息
	 * @param number
	 * @return
	 */
	Order queryOrderWithUserByOrderNumber(@Param("number") String number);

	/**
	 * 根据订单号查询订单用户的信息及订单详情
	 * @param number
	 * @return
	 */
	Order queryOrderWithUserAndDetailByOrderNumber(@Param("number") String number);

	/**
	 * 根据订单号查询订单用户的信息及订单详情及订单详情对应的商品信息
	 * @param number
	 * @return
	 */
	Order queryOrderWithUserAndDetailItemByOrderNumber(@Param("number") String number);

	/**
	 * 延迟加载
	 * @param number
	 */
	public Order queryOrderAndUserBuOrderNumberLazy(@Param("number") String number);
}
