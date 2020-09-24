package com.java_select_text_book.first;

import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class Texter {
	static class MyGUI extends JFrame {
		MyGUI() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("이벤트 처리 3");
			this.setLayout(new FlowLayout());
			
			JTextField txt = new JTextField(10);
			JTextArea area = new JTextArea(10,10);
			this.add(txt);
			this.add(area);
			
			txt.addKeyListener(new KeyAdapter() {
				public void KeyReleased(KeyEvent e) {
					int key = e.getKeyCode();
					//눌린 키의 정수 값을 key변수에 저장한다.
					if(key == KeyEvent.VK_ENTER) {
						String str = txt.getText();
						area.setText(area.getText() + str + '\n');
						txt.setText("");
					}
					
					if(!(key >= KeyEvent.VK_0 && key <= KeyEvent.VK_9)) {
						String str = txt.getText();
						int strlen = str.length();
						if(strlen != 0) {
							txt.setText(str.substring(0, strlen -1));
						}
					}
				}
			});
			
			setSize(200, 200);
			setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new MyGUI();
	}
}
