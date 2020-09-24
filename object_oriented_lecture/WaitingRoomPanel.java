package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import Handler.btnWaitListener;

import Data.Message;
import Data.MessageDAO;

public class WaitingRoomPanel extends JPanel {

	//data
	public JLabel			profileLabel;
	public JLabel			idLabel;
	public JLabel			rankLabel;
	public JLabel            idscoreLabel;

	ImageIcon				waiticon	= new ImageIcon("img/waitbtn.png");
	ImageIcon				starticon	= new ImageIcon("img/startbtn.png");

	public ImageIcon		bgImage;
	public BufferedImage	backPicture;

	public JButton			logoutButton;
	public JButton			exitButton;
	public JButton			waitButton;

	public JTextArea		rankArea;

	public JTable			roomTabel;

	private PrimaryPanel	parent;

	public MessageDAO		dao;
	protected ArrayList<Message>	datas;
	//method
	public WaitingRoomPanel(PrimaryPanel p) throws IOException {
		//일반데이터 설정
		 dao = new MessageDAO();
		 datas = dao.getAll();
		  
		this.parent = p;
		btnWaitListener listener = new btnWaitListener(parent, this);

		bgImage			= new ImageIcon("img/testbg.jpg");

		// 프로필사진 레이블
		profileLabel	= new JLabel();
		backPicture		= ImageIO.read(new File("img/profile.jpg"));
		profileLabel.setIcon(new ImageIcon(backPicture));
		profileLabel.setBounds(97, 110, 200, 145);
		profileLabel.setHorizontalAlignment(SwingConstants.CENTER);
		profileLabel.setVisible(true);
		this.add(profileLabel);

		// ID 레이블
		idLabel = new JLabel(parent.Plogin.idTextField.getText());
		idLabel.setBounds(97, 240, 200, 80);
		idLabel.setForeground(Color.WHITE);
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
		idLabel.setVisible(true);
		this.add(idLabel);
		
		// 아이디 전적 레이블
	    // 아이디 전적 관련 내용입니다.
	    String name = parent.Plogin.idTextField.getText();
	    int win = 0;
	    int lose = 0;
		if (datas != null) {
	    //ArrayList의 전체 데이터에서 아이디 찾기
			for (Message d : datas) {
				if (name.equals(d.getId())) {
					win = d.getId_win();
					lose = d.getId_lose();
					}
				}
			} //if	  
	      // 랭킹 관련 내용입니다.
	    idscoreLabel = new JLabel("Win : " + Integer.toString(win) +" Lose : " + Integer.toString(lose));
	    idscoreLabel.setBounds(47, 280, 300, 80);
	    idscoreLabel.setForeground(Color.WHITE);
	    idscoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
	    idscoreLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
	    idscoreLabel.setVisible(true);
	    add(idscoreLabel);
	    
		// 랭킹 레이블
		rankLabel = new JLabel("RANK");
		rankLabel.setBounds(120, 340, 150, 40);
		rankLabel.setForeground(Color.WHITE);
		rankLabel.setFont(new Font("휴먼모음T", Font.PLAIN, 25));
		rankLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rankLabel.setVisible(true);
		add(rankLabel);

		// 랭킹 출력 필드
		rankArea = new JTextArea();
		rankArea.setBounds(70, 380, 270, 290);
		rankArea.setForeground(Color.white);
		rankArea.setBackground(Color.black);
		rankArea.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		rankArea.setEditable(false);
		rankArea.setFont(new Font("휴먼모음T", Font.PLAIN, 15));
		rankArea.append(" 순위\t아이디\t승패차이\n");
		
		//랭킹 관련 내용입니다.
		if (datas != null) {
			int i = 1;
			int a, b;
			int difference;
	    //ArrayList의 전체 데이터를 형식에 맞춰 출력
			for (Message d : datas) {
				StringBuffer sb = new StringBuffer();
				sb.append(Integer.toString(i) + "\t");
				sb.append(d.getId() + "\t");
				a = d.getId_win();
				b = d.getId_lose();
				difference = a - b;
				sb.append(Integer.toString(difference) + "\n");
				rankArea.append(sb.toString());
				i += 1;
				} //for
			} //if
		else {
			rankArea.append("등록된 랭킹이 없습니다!!");
			} //else
	    // 랭킹 관련 내용입니다.
		add(rankArea);

		// 로그아웃 버튼
		logoutButton = new JButton(new ImageIcon("img/logoutbtn.png"));
		logoutButton.setBounds(720, 80, 100, 40);
		logoutButton.setContentAreaFilled(false);
		logoutButton.setFocusPainted(false);
		logoutButton.setVisible(true);
		logoutButton.addActionListener(listener);
		this.add(logoutButton);

		// 나가기 버튼
		exitButton = new JButton(new ImageIcon("img/exitbtn2.png"));
		exitButton.setBounds(830, 80, 100, 40);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.setVisible(true);
		exitButton.addActionListener(listener);
		this.add(exitButton);

		waitButton = new JButton(waiticon);
		waitButton.setBounds(830, 690, 100, 40);
		waitButton.setContentAreaFilled(false);
		waitButton.setFocusPainted(false);
		waitButton.setVisible(false);
		waitButton.addActionListener(listener);
		this.add(waitButton);

		// 방 목록
		String[][]	roomList			= {
				{ "방 제목1", "0 / 2" },
				{ "방 제목2", "0 / 2" },
				{ "방 제목3", "0 / 2" }
		};

		// 테이블의 각 컬럼이름 (실제로 노출은 안됨)
		String[]	tableColumnNames	= { "방 제목", "인원 수" };
		// 방 목록을 보여주는 테이블
		roomTabel = new JTable(roomList, tableColumnNames);
		roomTabel.setDefaultEditor(Object.class, null);
		roomTabel.setBounds(400, 190, 530, 480);
		roomTabel.setRowHeight(160);
		roomTabel.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		// 테두리 설정
		roomTabel.setBorder(BorderFactory.createLineBorder(Color.white, 2));
		roomTabel.setForeground(Color.white);
		roomTabel.setBackground(Color.black);
		// 각 컬럼의 넓이 조절
		roomTabel.getColumnModel().getColumn(0).setPreferredWidth(400);
		roomTabel.getColumnModel().getColumn(1).setPreferredWidth(130);

		// '인원 수' 컬럼의 텍스트 중앙정렬
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		roomTabel.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		roomTabel.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		roomTabel.addMouseListener(listener);

		this.add(roomTabel);

		this.setLayout(null);
		this.setSize(1000, 800);
		this.setVisible(true);

	}

	public void paintComponent(Graphics g) {
		g.drawImage(bgImage.getImage(), 0, 0, null);
		setOpaque(false);
		super.paintComponent(g);
	}

	public void changeButton() {
		waitButton.setIcon(starticon);
		waitButton.setEnabled(true);
	}

	public void initRank(String i, String name, String winAndLose) {
		rankArea.append(i + "\t" + name + "\t" + winAndLose + "\n");
	}

}//WaitingRoomFrame class
