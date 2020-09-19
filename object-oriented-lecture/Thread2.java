package Thread_test;

public class Thread_test extends Thread{
	public int total;
	private SellManager sm;
	
	public Thread_test() {
		sm = new SellManager();
		total = 100;
	}
	
	class SellManager{
		int sell() {
			total--;
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return total;
		}
	}
	
	public void run() {
		String tname = Thread.currentThread().getName();
		for(int i = 0; i < 3; i++) {
			System.out.println(tname + "-판매:" + sm.sell());
		}
		System.out.println(tname + " 종료");
	}
	
	public static void main(String[] args) {
		System.out.println("## 티켓 예매 프로그램 ##");
		Thread_test app = new Thread_test();
		for(int i = 0; i < 10; i++) {
			Thread mt = new Thread(app);
			mt.start();
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		//System.out.println("main 종료!!");
	}
}
