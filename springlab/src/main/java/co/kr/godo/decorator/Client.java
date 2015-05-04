package co.kr.godo.decorator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	private static IComponent iComponent;
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new GenericXmlApplicationContext(
				"/co/kr/godo/decorator/applicationContext.xml");
		iComponent = context.getBean("iComponent", IComponent.class);
		
		iComponent.setFirstName("Jung");
		iComponent.setLastName("Woochul");
		System.out.println(iComponent.getWelcomeMessage());
	}
}
