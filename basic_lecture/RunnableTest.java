import java.util.ArrayList;

public class RunnableTest implements Runnable {
    // implements은 interface 상속에 사용되고 부모의 메소드를 반드시 오버라이딩(재정의)해야 한다. 그리고 다중 상속이 가능합니다.
    int seq;
    public RunnableTest(int seq) {
        this.seq = seq;
    }
    public void run() {
        System.out.println(this.seq + " thread start.");
        try {
            Thread.sleep(1000);
        } catch(Exception e) {

        }
        System.out.println(this.seq + " thread end.");
    }
    public static void main(String[] args){
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(new RunnableTest(i));
            thread.start();
            threads.add(thread);
        }
        for(int i = 0; i < threads.size(); i++){
            Thread t = threads.get(i);
            try {
                t.join(); //  join 메소드는 쓰레드가 종료될 때까지 기다리게 하는 메서드입니다.
            } catch(Exception e) {
            }
        }
        System.out.println("main end.");
    }
}