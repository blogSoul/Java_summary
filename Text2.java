package com.java_select_text_book.first;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Texter {
	static class MyGUI extends JFrame {
		String fileName;
		JTextArea content;
		
		MyGUI() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    setTitle("이벤트 처리 4");
			this.setLayout(new FlowLayout());
			createMenu();
		    setSize(500,400);
		    
			JTextArea t = new JTextArea();
			add(t);
			
			setVisible(true);
		}
		
		void createMenu() { 
			JFrame f = new JFrame();
			JMenuBar mb = new JMenuBar(); // 메뉴바 생성
			JMenuItem [] menuItem = new JMenuItem [10];
			String[] itemTitle = {"새로만들기", "열기", "저장", "다른이름저장", "끝내기"};
			JMenu screenMenu = new JMenu("파일");

			MenuActionListener listener = new MenuActionListener(); 
			for(int i=0; i<5; i++) {
				menuItem[i] = new JMenuItem(itemTitle[i]); 
				menuItem[i].addActionListener(listener); 
				screenMenu.add(menuItem[i]);
			}
			mb.add(screenMenu); 
			setJMenuBar(mb); // 메뉴바를 프레임에 부착
		
			String[] itemTitles = {"작게", "보통", "크게"};
			JMenu textMenu = new JMenu("보기");

			for(int i=0; i<3; i++) {
				menuItem[i+5] = new JMenuItem(itemTitles[i]); 
				menuItem[i+5].addActionListener(listener); 
				textMenu.add(menuItem[i+5]);
			}
			mb.add(textMenu); 
			setJMenuBar(mb); // 메뉴바를 프레임에 부착
			
			String[] itemTitlez = {"도움말"};
			JMenu orderMenu = new JMenu("도움말");

			for(int i=0; i<1; i++) {
				menuItem[i+7] = new JMenuItem(itemTitlez[i]); 
				menuItem[i+7].addActionListener(listener); 
				orderMenu.add(menuItem[i+7]);
			}
			mb.add(orderMenu); 
			setJMenuBar(mb); // 메뉴바를 프레임에 부착
		}
		
		class MenuActionListener implements ActionListener { 
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand(); 
				JTextArea contents;
				switch(cmd) { // 메뉴 아이템의 종류 구분
					case "열기" :
						System.out.println("열기");
						break;
					case "새로만들기" :
						System.out.println("새로만들기");
						break;
					case "저장" :
						System.out.println("저장");
						break;
					case "다른이름저장" :
						System.out.println("다른이름저장");
						break;
					case "작게" :
						System.out.println("작게");
					    break;
					case "보통" :
						System.out.println("보통");
						break;
					case "크게" :
						System.out.println("크게");
						break;
					case "끝내기" :
						System.out.println("끝내기");
						System.exit(0);
						break;
					case "도움말" :
						JOptionPane.showMessageDialog(null,"메모장을 구현해 보았습니다. 14010384 설민욱");
						System.out.println("도움말");
						break;
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		new MyGUI();
		JFrame f = new JFrame();
	}
}
