package com.java_select_text_book.first;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.SQLException;

public class Texter {
	Scanner scanner = new Scanner(System.in);
	
	String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	String jdbcUrl = "jdbc:mysql://localhost:3306/sample?characterEncoding=UTF-8&serverTimezone=UTC";
	Connection conn;
	
	PreparedStatement pstmt;
	ResultSet rs;
	
	//이벤트 등록
	public void EventRegist() {
		System.out.println("## 이벤트 등록을 위해 이름과 이메일을 입력하세요.");
		System.out.print("이름: ");
		String uname = scanner.next();
		System.out.print("이메일: ");
		String email = scanner.next();
		
		connectDB();
		registerUser(uname, email);
		printList();
		closeDB();
	}

	public void connectDB() {
		try {
			//1단계 : JDBC 드라이버 로드
			Class.forName(jdbcDriver);
			//2단계: 데이터베이스 연결
			conn = DriverManager.getConnection(jdbcUrl, "root", "0000");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void closeDB() {
		try {
			//6단계 : 연결 해제
			pstmt.close();
			rs.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void registerUser(String uname,String email) {
		String sql = "insert into test(uname, email) value(?, ?)";
		try {
			//3단계 : Statement 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, email);
			
			//4단계 : SQL 문 전송
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printList() {
		System.out.println("# 등록자 명단");
		String sql = "select uname, email from test";
		try {
			pstmt = conn.prepareStatement(sql);
			
			//5단계 : 결과 받기 
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("uname") + ", " + rs.getString(2));
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		Texter a = new Texter();
		a.EventRegist();
	}
}
