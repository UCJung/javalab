/*
 * @(#)OrderStateFactory.java $version 2015. 6. 19.
 *
 * Copyright 2015 Godosoft. All rights Reserved.
 * Godosoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.yjwee.designpattern.state;

/**
 * @author YeongJong Wee
 */
public class OrderStateFactory {

	public static OrderState getOrderState(OrderModel order) {
		switch (order.getState()) {
			case 0:
				return new OrderState0(order);
			case 1:
				return new OrderState1(order);
			case 2:
				return new OrderState2(order);
			default:
				return new OrderStateDefault(order);
		}
	}
}
