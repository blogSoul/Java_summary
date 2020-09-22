public class ZooKeeper {
    public void feed(Predator predator){
        System.out.println("feed " + predator.getFood());
    }
    public static void main(String[] args){
        ZooKeeper zookeeper = new ZooKeeper();
        Tiger tiger = new Tiger(); // Tiger 클래스의 객체, Predator 인터페이스의 객체
        Lion lion = new Lion(); // Lion 클래스의 객체, Predator 인터페이스의 객체
        // 객체가 한 개 이상의 자료형 타입을 갖게 되는 특성을 다형성(폴리모피즘, Polymorphism)이라고 합니다.
        zookeeper.feed(tiger);
        zookeeper.feed(lion);
    }
}
