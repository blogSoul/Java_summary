package Thread_test;

public class Thread_test extends Thread{
	public void run() {
		String tname = Thread.currentThread().getName();
		System.out.println(tname + " 시작");
		for(int i =0; i < 10;i++) {
			System.out.println(tname + "-" + i);
			// try, catch문으로  멀티스레드와 스레드의 차이를 알아보자
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(tname + " 종료");
	}
	
	public static void main(String[] args) {
		Thread_test app = new Thread_test();
		for(int i = 0; i <2 ; i++) {
			Thread t = new Thread(app);
			t.start();
		}
		System.out.println("main 종료!!");
	}
}
