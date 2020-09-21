public class Dog extends Animal{
    public void sleep() {
        System.out.println(this.name + " zzz");
    }
    /*
    public static void main(String[] args){
        Dog dog = new Dog();
        Animal dog2 = new Dog(); 
        // 자식 객체는 부모 클래스의 자료형인 것처럼 사용할 수 있습니다.
        // 부모 클래스로 만든 개체는 자식클래스의 자료형으로 사용할 수 없습니다.
        dog.setName("poppy");
        System.out.println(dog.name);
        dog.sleep();
        // 자바에서 만드는 모든 클래스는 Object라는 클래스를 상속받게 되어 있습니다.
    }
    */
}
