public class Bouncer {
    public void barkAnimal(Barkable animal){
        animal.bark();
    } // 이렇게 하나의 객체가 여러개의 자료형 타입을 가질 수 있는 것을 다형성, Polymorphism이라고 합니다.
    /*
    public void barkAnimal(Animal animal){
        if(animal instanceof Tiger){
            System.out.println("어흥");
        } else if (animal instanceof Lion) {
            System.out.println("으르렁");
        } // instanceof는 특정 객체가 특정 클래스의 객체인지 조사할 때, 사용되는 자바 내장 키워드입니다.
    }
    */
    public static void main(String[] args){
        Tiger tiger = new Tiger(); // Tiger class와 Animal class는 IS-A 관계입니다.
        // is-a : 한 항목이 다른 항목을 상속
        // has-a : 한 항목이 다른 항목을 합성했거나 어떤 특성을 가졌다. 객체 합성을 사용
        Lion lion = new Lion();
        Bouncer bouncer = new Bouncer();
        bouncer.barkAnimal(tiger);
        bouncer.barkAnimal(lion);

        Predator predator = new Tiger();
        Barkable barkable = new Tiger();
        System.out.println(predator.getFood());
        barkable.bark();
        
        //BarkablePredator Lioncheck = new Lion();
        //Lioncheck.bark();
    }
}
