package co.kr.godo.test.driver;

public class TestObjectDriver {

	public static void main(String[] args) {
		TestObject testObject = new TestObject();
		
		testObject.setAppender("Test");
		testObject.setAppendee("Driver");
		
		if (testObject.append().equals("TestDriver")) {
			System.out.println("정상");
		} else {
			System.out.println("오류");
		}
	}
}
