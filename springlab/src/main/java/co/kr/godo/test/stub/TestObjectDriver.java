package co.kr.godo.test.stub;

public class TestObjectDriver {
	public static void main(String[] args) {
		TestObject testObject = new TestObject();
		testObject.setStubInterface(new Stub());
		
		int[] params = {10,10};
		int result = testObject.Calculate(params);
		System.out.println(result);
		if (result == -400) {
			System.out.println("정상");
		} else {
			System.out.println("오류");
		}
	}
}
