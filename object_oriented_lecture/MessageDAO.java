package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import Data.Message;

//WaitingPanel에 사용되는 랭킹판과 전적을 나타내기 위해 DB에서 데이터를 받는 MessageDAO클래스입니다.
public class MessageDAO {

	//data
	private String				jdbcDriver;
	private String				jdbcUrl;
	private Connection			conn;

	private PreparedStatement	pstmt;
	private ResultSet			rs;

	private Vector<String>		items;		
	private String				sql;

	//method
	public MessageDAO() {
		//DB에 접속하기 위한 Driver와 url입니다.
		jdbcDriver	= "com.mysql.cj.jdbc.Driver";
		jdbcUrl		= "jdbc:mysql://localhost/poker_db?characterEncoding=UTF-8&serverTimezone=UTC";

	}//constructor 

	//DB를 connect합니다.
	public void connectDB() {

		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcUrl, "root", "0000");
			//DB이름과 비밀번호를 해당 DB에 맞게 입력해야 합니다.
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//connectDB()

	//DB를 close합니다.
	public void closeDB() {
		try {
			pstmt.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}//closeDB()

	//Ranking에 사용할 데이터를 ArrayList에 저장합니다..
	public ArrayList<Message> getAll() {
		
		connectDB();

		sql = "select * from poker_user order by id_win-id_lose DESC";

		//ArrayList를 생성합니다.
		ArrayList<Message> datas = new ArrayList<Message>();

		try {
			pstmt	= conn.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			while (rs.next()) {
				Message p = new Message();
				p.setId(rs.getString("id"));
				p.setPasswd(rs.getString("passwd"));
				p.setId_win(rs.getInt("id_win"));
				p.setId_lose(rs.getInt("id_lose"));
				p.setId_status(rs.getInt("id_status"));
				datas.add(p);
			} //while
		} catch (Exception e) {
			e.printStackTrace();
		}

		closeDB();

		return datas;
	}//getAll()

	//해당 id에 맞게 데이터를 가지고 옵니다.
	public Message getMessage(String id) {

		connectDB();

		sql = "select * from poker_user where id = ?";

		Message p = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			rs.next();
			p = new Message();
			p.setId(rs.getString("id"));
			p.setPasswd(rs.getString("passwd"));
			p.setId_win(rs.getInt("id_win"));
			p.setId_lose(rs.getInt("id_lose"));
			p.setId_status(rs.getInt("id_status"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		closeDB();

		return p;

	}//getProduct()

	//Data.Message에 맞게 DB에 있는 데이터를 insert해줍니다.
	public boolean newMessage(Message product) {

		connectDB();

		sql = "insert into poker_user values (?, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getPasswd());
			pstmt.setInt(3, product.getId_win());
			pstmt.setInt(4, product.getId_lose());
			pstmt.setInt(5, 0);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		closeDB();

		return true;
	}

	//Data.Message에 맞게 DB에 있는 데이터를 delete해줍니다.
	public boolean delMessage(Message product) {

		connectDB();
		
		sql = "delete from poker_user where id like '?' and passwd like '?' and id_win like '?' and id_lose = '?' and id_status= '?'";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getPasswd());
			pstmt.setInt(3, product.getId_win());
			pstmt.setInt(4, product.getId_lose());
			pstmt.setInt(5, 0);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		closeDB();

		return true;
	}

	//Data.Message에 맞게 DB에 있는 데이터를 update해줍니다.
	public boolean updateMessage(Message product) {

		connectDB();

		sql = "update poker_user set id = ?, passwd = ?, id_win = ?, id_lose = ?  where id = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getPasswd());
			pstmt.setInt(3, product.getId_win());
			pstmt.setInt(4, product.getId_lose());
			pstmt.setString(1, product.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		closeDB();

		return true;

	}//updateProduct()

	public Vector<String> getItems() {
		return items;
	}
}//ProductDAO class
