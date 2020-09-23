import jdk.jshell.spi.ExecutionControl.RunException;

// RuntimeException는 serializable을 상속하는 상위 클래스, 혹은 인터페이스를 상속 또는 구현하기 때문입니다.
// RuntimeException는 실행 시 발생하는 예외입니다.
// Exception는 컴파일 시 발생하는 예외입니다.
@SuppressWarnings("serial")
public class FoolException extends Exception {
    public static void main(String[] args){
        System.out.println("it is FoolException");
    }
}
