package com.mykumi.designpattern.state;

public class OrderProcessingContext {
	private OrderModel order;
	
	public OrderProcessingContext(OrderModel order) {
		this.order = order;
	}
	
	public void changeState(int state) {
		switch (state) {
		case 0 :
			System.out.println(state + " change state");
			break;

		case 1 :
			System.out.println(state + " change state");
			break;

		case 2 :
			System.out.println(state + " change state");
			break;
			
		default:
			System.out.println(state + " is not allowed");
			break;
		}
		
		this.order.setState(state);
	}
	
	public void cancelOrder() {
		int currentState = this.order.getState(); 
		switch (currentState) {
		case 0 :
			System.out.println(currentState + " canceled ");
			break;

		case 1 :
			System.out.println(currentState + " canceled");
			break;

		case 2 :
			System.out.println(currentState + " canceled");
			break;
			
		default:
			System.out.println(currentState + " is not allowed");
			break;
		}
		
		this.order.setState(2);
	}	
}
