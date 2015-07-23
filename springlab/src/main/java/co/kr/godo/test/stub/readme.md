# Test Stub Sample Code
## Test Stub 이란?

전통적인 방식에서는 TOP-Down 형태의 개발 방식을 사용할 경우
상위 모듈에 대한 단위테스트를 할 때 하위 모듈이 개발이 되지 않은 상황에서
테스트를위하여 만들어지는 더미 코드

## Java 에서의 Test Stub

### Test Stub  
의존관계에 있는 Layer 간에 Interface나 Abstract Class로 사전 규약을 하고 Mockito를 이용하거나 해당 Interface를 구현한 테스트용 더미 클래스를 만들어서 활용

1. 대상 모듈의 개발자와 Interface Signature 정의
2. DBC 관점에서 대상 Interface에 대한 선행/후행/불변 조건 정의 
3. 해당 Interface를 구현한 Dumy Class 생성 및 테스트 코드 작성 혹은 Mockito를 통한 Mock 기반 테스트 코드 작성

### Source 설명
* StubInterface.java : 미구현된 의존 모듈의 Interface
* Stub.java : StubInterface.java를 구현한 Dumy Test Stub
* TestObject.java : 테스트 대상 Class
* TestObjectDriver.java : 테스트 대상 Class를 사용하기 위해 만든 테스트 Driver (Stub.java Dummy 사용)
* TestObjectTest.java : Test 대상에 대한 JUnit Test (Mokito 사용)