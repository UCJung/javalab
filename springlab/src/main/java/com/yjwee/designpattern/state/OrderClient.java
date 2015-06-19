/*
 * @(#)OrderClient.java $version 2015. 6. 19.
 *
 * Copyright 2015 Godosoft. All rights Reserved.
 * Godosoft PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.yjwee.designpattern.state;

/**
 * @author YeongJong Wee
 */
public class OrderClient {

	public static void main(String[] args) {
		OrderModel order = new OrderModel();
		order.setProductName("A Product");
		order.setTotalAmount(12000);

		OrderProcessingContext orderProcessingContext = new OrderProcessingContext(order);
		orderProcessingContext.changeState(0);
		orderProcessingContext.cancelOrder(); // State 패턴을 이용하여 주문 취소를 수행하는 OrderState 를 switch 문 생성하여 실행

		orderProcessingContext.changeState(1);
		orderProcessingContext.cancelOrderFactory(); // State 패턴을 이용하여 주문 취소를 수행하는 OrderState 를 Factory Pattern 으로 생성하여 실행

		// Strategy Pattern으로 주문 취소 수행 Client에서 주문 취소 전략을 생성하여 실행
		orderProcessingContext.changeState(2);
		orderProcessingContext.cancelOrderStrategy(new OrderState2(order));
	}
}
