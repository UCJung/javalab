package co.kr.godo.decorator;

public class WrapperClass extends Decorator {

	public WrapperClass(){
		super();
	}
	
	public WrapperClass(IComponent iComponent) {
		super(iComponent);
	}

	public String getWelcomeMessage() {
		String result = "Hi! Nice to meet You. ";
		result = result + this.iComponent.getWelcomeMessage();
		return result;
	}
}
