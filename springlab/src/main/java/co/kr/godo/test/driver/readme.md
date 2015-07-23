# Test Driver Sample Code
## Test Driver 이란?

전통적인 방식에서는 Buttom-Up 형태의 개발 방식을 사용할 경우
작성된 모듈이 정상 동작하는지 확인을 위하여 작성된 모듈을 호출하는 Dummy Test Code

## Java 에서의 Test Driver

### Test Driver  
OOP의 TDD방식의 개발에서는 기본적으로 테스트 코드를 작성 후 테스트를 통과하는 모듈을 개발하는 방식으로 진행된다.
모듈 개발전에 작성되는 테스트코드가 바로 Test Driver라 할 수 있다.

1. DBC 관점에서 대상 모듈(Class)에 대한 선행/후행/불변 조건 정의 
2. 대상의 조건에 대한 테스트 개발
3. 테스트를 통과 대상 모듈(Class) 개발 

### Source 설명
* TestObject.java : 테스트 대상 Class
* TestObjectDriver.java : 테스트 대상 Class를 사용하기 위해 만든 테스트 Driver
* TestObjectTest.java : Test 대상에 대한 JUnit Test

