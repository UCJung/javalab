package com.mykumi.designpattern.state;

public class OrderClient {

	public static void main(String[] args) {
		OrderModel order = new OrderModel();
		order.setProductName("A Product");
		order.setTotalAmount(12000);
		
		OrderProcessingContext orderProcessingContext = new OrderProcessingContext(order);
		orderProcessingContext.changeState(1);
		orderProcessingContext.cancelOrder();
	}

}
