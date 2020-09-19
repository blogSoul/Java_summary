package javaFX;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	public static void main(String []args) {
		try {
			ServerSocket sc = new ServerSocket(5000);
			System.out.println("## 서버 실행..");
			while(true) {
				Socket s = sc.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				System.out.println("## 클라이언트 연결됨!!");
				System.out.println("## 클라이언트 메세지: " + br.readLine());
				br.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
