/*
 * @(#)OrderProcessingContext.java $version 2015. 6. 19.
 *
 * Copyright 2015 Godosoft. All rights Reserved.
 * Godosoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.yjwee.designpattern.state;

/**
 * @author YeongJong Wee
 */
public class OrderProcessingContext {

	private OrderModel order;

	public OrderProcessingContext(OrderModel order) {
		this.order = order;
	}

	public void changeState(int state) {
		switch (state) {
			case 0:
				System.out.println(state + " change state");
				break;

			case 1:
				System.out.println(state + " change state");
				break;

			case 2:
				System.out.println(state + " change state");
				break;

			default:
				System.out.println(state + " is not allowed");
				break;
		}

		this.order.setState(state);
	}

	// State 패턴만 적용된 경우
	public void cancelOrder() {
		int currentState = this.order.getState();
		OrderState orderState = null;

		switch (currentState) {
			case 0:
				orderState = new OrderState0(this.order);
				break;

			case 1:
				orderState = new OrderState1(this.order);
				break;

			case 2:
				orderState = new OrderState2(this.order);
				break;

			default:
				orderState = new OrderStateDefault(this.order);
				break;
		}

		orderState.cancelOrder();
		this.order.setState(2);
	}

	// State 패턴이 적용된 OrderState의 구상클래스에 Factory을 적용한 경우
	public void cancelOrderFactory() {
		OrderStateFactory.getOrderState(this.order).cancelOrder();
	}

	// Strategy 패턴이 적용된 경우
	public void cancelOrderStrategy(OrderState orderState) {
		orderState.cancelOrder();
	}
}
