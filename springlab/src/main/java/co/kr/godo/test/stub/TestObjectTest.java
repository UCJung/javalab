package co.kr.godo.test.stub;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

public class TestObjectTest {

	@Test
	public final void testCalculate() {
		int[] params = {10,10};
		
		StubInterface mockedStub = mock(StubInterface.class);
		when(mockedStub.plus(params)).thenReturn(20);
		when(mockedStub.minus(params)).thenReturn(-20);
		when(mockedStub.multifly(params)).thenReturn(400);
		
		TestObject testObject = new TestObject();
		testObject.setStubInterface(mockedStub);
		
		int result = testObject.Calculate(params);
		assertThat(result,is(-400));
	}
}
