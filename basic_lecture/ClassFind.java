// import java.util.ArrayList;
public class ClassFind {
    String name;

    public void setName(String name){ // method의 대표적인 예
        this.name = name;
    }
    public static void main(final String[] args) {
        // 인스턴스화(Instantiation) : 범주나 개념으로부터 실재하는 객체를 만드는 과정
        Animal cat = new Animal(); // class -> instance
        // Animal 객체(object)를 만드는 기능을 가지고 있습니다.
        // cat이라는 객체는 Animal의 instance이다. 
        
        // Class란? 객체를 만들어 내기 위한 설계도 혹은 틀, 객체지향적이다.(Object oriented)
        // Object란? 소프트웨어 세계에 구현할 대상, 클래스의 인스턴스(instance)
        // Instance란? 설계도를 바탕으로 소프트웨어 세계에 구현된 구체적인 실체
        //  oop의 관점에서 객체가 메모리에 할당되어 실제 사용될 때 "인스턴스"라고 부릅니다.
        // 분류(Classification) : 객체 -> 클래스 : 실재하는 객체들을 공통적인 속성을 공유하는 범부 또는 추상적인 개념으로 묶는 것

        cat.setName("boby");
        System.out.println(cat.name);
    }
}