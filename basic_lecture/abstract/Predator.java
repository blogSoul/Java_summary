public abstract class Predator extends Animal{
    public abstract String getFood();
    // abstract 클래스를 상속하는 클래스에서 해당 abstract 메소드를 구현해야만 합니다.
    // 추상 클래스에 abstract로 선언된 메소드는 추상클래스를 상속하는 클래스에서 반드시 구현해야만 합니다.
    public boolean isPredator() {
        return true;
    }
}
