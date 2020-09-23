public class staticCounter {
    static int count = 0;
    staticCounter() {
        staticCounter.count++;
    } // static은 static 클래스에서만 사용할 수 있도록 합니다.
    public static int getCount(){
        return count;
    }
    public static void main(String[] args) {
        staticCounter c1 = new staticCounter();
        staticCounter c2 = new staticCounter();
        // static은 메모리를 별도로 할당해 메모리 사용할 수 있습니다.
        // static 키워드 앞에 final이라는 키워드를 붙이면  그 값을 변경하지 못하게 합니다.
        System.out.println(staticCounter.getCount());
        // static method 안에서는 인스턴스 변수 접근이 불가능합니다.
    }
    // the static method from the type should be accessed in a static way를 해결하기 위해서는 어디 class를 이용할 것인지 명확히 얘기해야 합니다.
}

