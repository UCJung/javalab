/*
 * @(#)OrderState1.java $version 2015. 6. 19.
 *
 * Copyright 2015 Godosoft. All rights Reserved.
 * Godosoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.yjwee.designpattern.state;

/**
 * @author YeongJong Wee
 */
public class OrderState2 implements OrderState {

	private OrderModel order;

	public OrderState2(OrderModel order) {
		this.order = order;
	}

	/**
	 * @see com.yjwee.designpattern.state.OrderState#cancelOrder()
	 */
	public void cancelOrder() {
		int currentState = this.order.getState();
		System.out.println(currentState + " canceled");
	}
}
