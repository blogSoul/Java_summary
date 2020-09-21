public class HouseDog extends Dog{
    public HouseDog(String name){ // Constructor
        this.setName(name);
        // 1. 클래스명과 메소드명이 동일합니다.
        // 2. 리턴타입을 정의하지 않습니다.
    }
    public void sleep() {
        System.out.println(this.name + " zzz in house");
    } // Dog의 sleep method에 대해 Method overriding
    public void sleep(int hour){
        System.out.println(this.name + " zzz in house for " + hour + " hours");
    } // HouseDog의 sleep 메소드를 method overloading
    public static void main(String[] args){
        HouseDog houseDog = new HouseDog("happy");
        // houseDog.setName("happy"); <= Animal class에 있는 method도 사용할 수 있습니다.
        // houseDog.sleep();
        // houseDog.sleep(2);
        System.out.println(houseDog.name);
    }
    // 자바는 다중 상속을 지원하지 않습니다.
    // 만약 클래스에 생성자가 하나도 없다면 컴파일러는 자동으로 디폴트 생성자를 추가합니다.
    // 생성자 또한 overloading이 가능합니다.
}
