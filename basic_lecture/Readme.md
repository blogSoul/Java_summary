# 😎 간단 정리

JVM은 자바 가상머신(Java Virtual Machine)의 약자이다.  

* 기능:
1. 바이너리 코드를 읽는다.
2. 바이너리 코드를 검증한다.
3. 바이너리 코드를 실행한다.
4. 실행환경(Runtime Environment)의 규격을 제공한다. (필요한 라이브러리 및 기타파일) 

__JRE__ 는 자바 실행환경(Java Runtime Environment)의 약자이다.  
__JRE__ 는 JVM의 실행환경을 구현했다고 할 수 있다.  

__JDK__ 는 자바 개발도구(Java Development Kit)의 약자이다.(XML-RPC)  
__JDK__ 는 JRE + 개발을 위해 필요한 도구(javac, java등)들을 포함한다.

파일명(MyProgram.java) 때문이다. 클래스명 앞에 public 키워드를 추가하면 그 클래스의 이름은 파일명과 동일해야만 하는 규칙이 있습니다. 
이유는 __"제임스고슬링이 그렇게 하라고 했기 때문"__ 입니다.  

## TDD(Test Driven Development) : 테스트 주도적 개발  

테스트=>코드=>리팩토링 순으로 프로그램 개발이 이루어집니다.  

TDD의 목적은 Clean code that works! (작동하는 깨끗한 코드!)

TDD를 위한 freamework : junit

1. 테스트 코드는 위처럼 junit 프레임워크에 포함되어있는 TestCase라는 클래스를 extends하여 작성한다.
2. 위 샘플코드의 "test1"메써드명처럼 "test"로 시작하는 메써드는 자동으로 실행이 된다.

Ex)  
assertEquals(a, b) - a와 b가 같은지를 조사한다.  
assertTrue(a) - a가 참인지 조사한다.  
assertFalse(a) - a가 거짓인지를 조사한다.  
