package com.hyein.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.hyein.data.BoardData;

public class BoardService {
	private String dbID = "HYEIN";
	private String dbPassWd = "1234";
	private String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private String driver = "oracle.jdbc.driver.OracleDriver";

	// write
	public void insertBoard(String contents, int stat, int m_idx, int g_idx) {
		String sql = "INSERT INTO Diary(contents,wdate,stat,m_idx,g_idx) VALUES (?,sysdate,?,?,?)";

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbID, dbPassWd);
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, contents);
			psmt.setInt(2, stat);
			psmt.setInt(3, m_idx);
			psmt.setInt(4, g_idx);
			psmt.executeUpdate();

			psmt.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getDiaryIdx() {
		String sql = " SELECT IDX FROM(SELECT * FROM DIARY ORDER BY WDATE DESC )WHERE ROWNUM =1  ";
		int d_idx = -1;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbID, dbPassWd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				d_idx = rs.getInt("idx");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d_idx;
	}

	public void insertPhoto(ArrayList<String> photo, int d_idx) {

		for (int i = 0; i < photo.size(); i++) {

			String sql = "INSERT INTO PHOTO(photo,d_idx) VALUES ('" + photo.get(i) + "'," + d_idx + ")";

			try {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, dbID, dbPassWd);
				Statement st = con.createStatement();
				System.out.println(photo.get(i) + " : " + d_idx);

				st.executeUpdate(sql);

				st.close();
				con.close();

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ArrayList<BoardData> mainList(int m_idx) {

		ArrayList<BoardData> bArr = new ArrayList<BoardData>();
		String sql = "select * from diary d left join (select idx, nickname from member) m "
				+ "on m.idx = d.m_idx  where g_idx in(select g_idx from groups_member where m_idx= "
				+ m_idx + ") or m_idx = " + m_idx + " order by wdate desc";

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbID, dbPassWd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idx = rs.getInt("idx");
				String contents = rs.getString("contents");
				Timestamp wdate = rs.getTimestamp("wdate");
				String writer = rs.getString("nickname");
				int stat = rs.getInt("stat");
				ArrayList<String> photo = photoList(idx);
				BoardData b = new BoardData(idx, contents, wdate, writer, stat, photo);
				bArr.add(b);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bArr;
	}

	public ArrayList<String> photoList(int d_idx) {
		ArrayList<String> photos = new ArrayList<String>();
		String sql = "select * from photo where d_idx =" + d_idx;
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbID, dbPassWd);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {

				String photo = rs.getString("photo");
				photos.add(photo);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return photos;
	}
}
