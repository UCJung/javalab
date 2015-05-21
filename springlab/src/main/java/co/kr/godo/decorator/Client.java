package co.kr.godo.decorator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	private static IComponent target;
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new GenericXmlApplicationContext(
				"/co/kr/godo/decorator/applicationContext.xml");
		target = context.getBean("wrapperClass2Decorator", IComponent.class);
		
		target.setFirstName("Jung");
		target.setLastName("Woochul");
		System.out.println(target.getWelcomeMessage());
	}
}
