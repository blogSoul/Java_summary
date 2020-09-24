package com.java_select_text_book.first;

import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
    
public class Texter{    
	public static void main(String[] args) {                  
        JFrame f = new JFrame();  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("과제 1");
        f.setLayout(new FlowLayout());
        f.setSize(500,400);  
                        
        JMenuBar m = new JMenuBar();
        f.setJMenuBar( m );
        
        JMenu fileMenu = new JMenu("파일");
        m.add( fileMenu);
        
        JMenuItem textnew = new JMenuItem("새로만들기"); 
        JMenuItem textload = new JMenuItem("열기"); 
        JMenuItem textsavetosame = new JMenuItem("저장");
        JMenuItem textsave = new JMenuItem("다른이름저장"); 
        JMenuItem textend = new JMenuItem("끝내기"); 
        
        fileMenu.add( textnew);
        fileMenu.add( textsave);
        fileMenu.add( textload); 
        fileMenu.add( textsavetosame);
        fileMenu.add( textend);
       
        JMenu textMenu = new JMenu("보기");
        m.add( textMenu);
        
        JMenuItem textsmall = new JMenuItem("작게"); 
        JMenuItem textmid = new JMenuItem("보통"); 
        JMenuItem textbig = new JMenuItem("크게");
        
        textMenu.add( textsmall);
        textMenu.add( textmid);
        textMenu.add( textbig); 
        
        JMenu textsMenu = new JMenu("도움말");
        m.add( textsMenu);
        
        JMenuItem texthelp = new JMenuItem("도움말"); 
        textsMenu.add( texthelp);
        
        JTextArea t = new JTextArea();      
        f.add(t);
        f.setVisible(true);
       
        textnew.addActionListener(new ActionListener() {         	
            public void actionPerformed(ActionEvent e) {           	
            	String txt = "new" ;
                String fileName = "C:/test.txt" ;   
                try{ 
                    // 파일 객체 생성
                    File file = new File(fileName) ;
                    // true 지정시 파일의 기존 내용에 이어서 작성이 가능하다.
                    FileWriter fw = new FileWriter(file, true) ;
                    fw.write(txt);
                    fw.flush();
                    fw.close();                 
                } catch(IOException e1){
                	JOptionPane.showMessageDialog(null,"파일 경로를 바꾸시면 파일 생성이 가능합니다!");
                	System.out.println("파일경로 오류");
                }    
            }            
        }); 
        
        textsave.addActionListener(new ActionListener() {         	
            public void actionPerformed(ActionEvent e) {           	
                FileDialog dialog = new FileDialog(f, "저장", FileDialog.SAVE);           
                dialog.setVisible(true);    
                String path = dialog.getDirectory() + dialog.getFile();
                
                try {               
                   FileWriter w = new FileWriter( path );
                   String s = t.getText();
                   s = s.replace("\n","\r\n");
                   w.write( s  ); 
                   w.close();            
                } catch (Exception e2) {              
                    System.out.println("저장오류"+e2);
                }  
            }            
        }); 
        
        textsavetosame.addActionListener(new ActionListener() {            
            public void actionPerformed(ActionEvent e) {               
                FileDialog dialog = new FileDialog(f, "저장", FileDialog.SAVE);           
                dialog.setVisible(true);    
                String path = dialog.getDirectory() + dialog.getFile();
                
                try {                   
                   FileWriter w = new FileWriter( path , true);
                // 기존 파일의 내용에 이어서 쓰고 싶으면 true로 지정해준다
                   String s = t.getText();
                   s = s.replace("\n","\r\n");
                   w.write( s  ); 
                   w.close();           
                } catch (Exception e2) {              
                    System.out.println("저장오류"+e2);
                }  
            }            
        }); //변경했는데 똑같은 파일에 저장하면 대화창이 나올 필요가 없다!
        
        textload.addActionListener(new ActionListener() {             
            public void actionPerformed(ActionEvent e) {                          
                   FileDialog dialog = new FileDialog(f, "로드", FileDialog.LOAD);
                   dialog.setFile("*.txt;");
                   dialog.setVisible(true);        
                   
                   String path = dialog.getDirectory() + dialog.getFile();                 
                   String s ="";
                   
                   if( dialog.getFile() == null ) return;
                           
                   try {                     
                      FileReader r = new FileReader( path );
                      
                      int k;              
                      
                      for( ;  ; ) {                    
                          k = r.read();
                          if( k == -1) break;
                          s += (char)k;               
                      }           
                      
                      r.close();
               
                   } catch (Exception e2) {                   
                       System.out.println("오류"+e);
                   } 
                   
                   t.setText(s);   
            }            
        }); 
        
        textend.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {                   
            	System.out.println("끝내기");
				System.exit(0);
            }            
        }); 
        
        textsmall.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {   
            	System.out.println("작게");
            	t.setFont(new Font("맑은고딕", Font.BOLD, 5));
            	f.add(t);
                f.setVisible(true);
            }            
        }); 
        
        textmid.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {  
            	System.out.println("보통으로");
            	t.setFont(new Font("맑은고딕", Font.BOLD, 20));
            	f.add(t);
                f.setVisible(true);
            }            
        }); 
        
        textbig.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {  
            	System.out.println("크게");
            	t.setFont(new Font("맑은고딕", Font.BOLD, 70));
            	f.add(t);
                f.setVisible(true);
            }            
        }); 
        
        texthelp.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {                   
            	JOptionPane.showMessageDialog(null,"메모장을 구현해 보았습니다. 14010384 설민욱");
				System.out.println("도움말");
            }            
        }); 
    }       
}
