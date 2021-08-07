public class AccessModifier {
    private String secret;
    private String getSecret() {
        return this.secret;
    }
}
/*
public class HouseHim {
    String lastname = "kim";
}
*/
// private이 붙은 변수, 메소드는 해당 클래스에서만 접근이 가능합니다.
// 접근제어자를 별도로 설정하지 않는다면 접근제어자가 없는 변수, 메소드는 default 접근제어자가 되어 해당 패키지 내에서만 접근이 가능합니다.
// 접근제어자가 protected로 설정되었다면 protected가 붙은 변수, 메소드는 동일 패키지 내의 클래스 또는 해당 클래스를 상속받은 외부 패키지의 클래스에서 접근이 가능합니다.
// 접근제어자가 public으로 설정되었다면 public 접근제어자가 붙은 변수, 메소드는 어떤 클래스에서라도 접근이 가능하다.
