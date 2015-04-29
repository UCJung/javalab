package co.kr.godo.test.stub;

public class TestObject {
	StubInterface stub;
	public void setStubInterface(StubInterface stub) {
		this.stub = stub;
	}
	
	public Integer Calculate(int[] integers) {
		Integer plusResult = this.stub.plus(integers);
		Integer minusResult = this.stub.minus(integers);
		
		Integer result = plusResult * minusResult;
		
		return result;
	}
}
