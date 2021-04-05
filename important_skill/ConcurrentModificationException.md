# 📕 ConcurrentModificationException

컬렉션에서 순회 중 데이터의 조작이 발생하는 경우에도 문제가 될 수 있습니다.  
ConcurrentModificationException은 해당 컬렉션 객체의 데이터 일관성에 대한 Exception으로서 컬렉션의 객체가 변함으로 인한 비정상적인 환경이 발생할 수 있다는 것을 알려주는 Exception입니다.

enhanced for loop에선 hasNext()때문에 ConcurrentModificationException가 발생 안하는 경우도 존재합니다.

ConcurrentModificationException를 방지하기 위해 불변 컬렉션을 이용하는 방법을 추천합니다. 에를 들면, filer(Stream 인터페이스에 보면 여러 메소드들)이 존재합니다.

참고 사이트 : [Go to Link](https://m.blog.naver.com/tmondev/220393974518)
