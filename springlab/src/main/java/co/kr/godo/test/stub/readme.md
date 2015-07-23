# Test Stub Sample Code
## Test Stub 이란?

전통적인 방식에서는 TOP-Down 형태의 개발 방식을 사용할 경우
상위 모듈에 대한 단위테스트를 할 때 하위 모듈이 개발이 되지 않은 상황에서
테스트를위하여 만들어지는 더미 코드

## Java 에서의 Test Stub

### Test Stub 
의존관계에 있는 Layer 간에 Interface나 Abstract Class로 사전 규약이 되어 있는 경우
Mockito를 이용한 Mock를 만드는 방식으로 테스트 코드 작성 추천

1. 대상 모듈의 개발자와 Interface Signature 정의
2. DBC 관점에서 대상 Interface에 대한 선행/후행/불변 조건 정의 
3. Test코드 작성 시 Mockito를 이용한 Mock을 사용한 코드 작성

