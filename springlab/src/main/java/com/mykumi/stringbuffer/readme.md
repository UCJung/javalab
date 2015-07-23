# StringBuilder vs StringBuffer 

## 개요

StringBuilder와 StringBuffer의 구조적인 차이점에 대한 이해를 위해 작성한 코드임
기본적인 차이는 Multi-Thread에서의 사용여부

## 설명

### 공통점

두 Class는 모두 AbstractStringBuilder 추상클래스를 상속한 구상클래스
기능 결과 측면에서 동일한 기능을 제공함.

### 차이점

StringBuffer의 경우 "synchronized" 선언을 통하여 동기화 적용

	// Method가 synchronized(동기화)로 선언 되어 있음
	public synchronized StringBuffer append(String str) {
 
### 동작성능

StringBuffer의 경우 내부에 메소드를 수행하기 위하여 해당 메소드에 대한 접근을 Lock하고 UnLock하는 부가적인 작업이 들어가기 때문에 동시성 제어가 필요하지 않을 경우 StringBuilder를 사용하는게 성능상 좋다.

### synchronized

* Multi Thread 기능 수행 시 특정 코드 블럭에 대한 동시성 제어를 하고자 할 경우 사용
* 특정 Thread 요청이 들어오면 다른 Thread 요청을 대기 시키고 선행작업이 끝나야 다음 작업이 수행됨
* 동시 요청에 대한 직렬화를 보장하기 위해 사용됨


## Code 설명

### ThreadRunner.java
StringBuilder와 StringBuffer에 Loop를 통하여 160000개의 "a" 문자를 Append하는 로직을 Multi-Thread에서 동작하도록 구현함

### ThreadRunnerTest.java : 테스트
4개의 Thread를 생성하여 위의 모듈을 수행

* StringBuffer에 Append된 문자의 개수는 160000개임을 보장
* StringBuilder의 경우 160000개임을 보장하지 못함 



 
