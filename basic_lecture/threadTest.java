import java.util.ArrayList;

public class threadTest extends Thread {
    int seq;
    public threadTest(int seq) {
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
            Thread thread = new threadTest(i);
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