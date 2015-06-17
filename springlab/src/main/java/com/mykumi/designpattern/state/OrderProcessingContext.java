package com.mykumi.designpattern.state;

public class OrderProcessingContext {
	private OrderModel order;
	
	public OrderProcessingContext(OrderModel order) {
		this.order = order;
	}
	
	public void changeState(int state) {
		switch (state) {
		case 0 :
			System.out.println(state + " 상태로 변경 ");
			break;

		case 1 :
			System.out.println(state + " 상태로 변경 ");
			break;

		case 2 :
			System.out.println(state + " 상태로 변경 ");
			break;
			
		default:
			System.out.println(state + " 상태는 지원하지 않음");
			break;
		}
		
		this.order.setState(state);
	}
	
	public void cancelOrder() {
		int currentState = this.order.getState(); 
		switch (currentState) {
		case 0 :
			System.out.println(currentState + " 상태에서 취소 ");
			break;

		case 1 :
			System.out.println(currentState + " 상태에서 취소 ");
			break;

		case 2 :
			System.out.println(currentState + " 상태에서 취소 ");
			break;
			
		default:
			System.out.println(currentState + " 상태는 지원하지 않음 ");
			break;
		}
		
		this.order.setState(2);
	}	
}
