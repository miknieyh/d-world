package com.hyein.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hyein.data.MemberData;

public class MemberService {
	private String dbID = "HYEIN";
	private String dbPassWd = "1234";
	private String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private String driver = "oracle.jdbc.driver.OracleDriver";

	
	
	public MemberData profile(int idx) {
		String sql = "SELECT ID,NAME,NICKNAME FROM MEMBER WHERE IDX="+idx;
		String id = "";
		String name ="";
		String nickname="";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbID, dbPassWd);

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				id=rs.getString("id");
				name= rs.getString("name");
				nickname=rs.getString("nickname");

			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		MemberData memberdata = new MemberData(id,name,nickname);
		return memberdata;
		
	}
	
	
	public MemberData login(String userid, String passwd) {
		int stat = -1;
		int idx = -1;
		String sql = "SELECT * FROM MEMBER WHERE ID ='" + userid + "'";

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbID, dbPassWd);

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				String passwd_ok = rs.getString("passwd");

				if (passwd.equals(passwd_ok)) {
					stat = rs.getInt("stat");
					idx = rs.getInt("idx");

					System.out.println("로그인 성공");

				} else {
					idx = rs.getInt("idx");
					System.out.println("비밀번호가 틀렸습니다.");
				}

			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		MemberData memberdata = new MemberData(idx, stat);
		return memberdata;
	}
	
	public void insertMember(String userid,String passwd, String name, String nickname, Date birth, String phone) {
		String sql = "INSERT INTO MEMBER(id,passwd,name,nickname,birth,phone,wdate,stat)" + " VALUES (?,?,?,?,?,?,sysdate,1)";

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbID, dbPassWd);

			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, userid);
			psmt.setString(2, passwd);
			psmt.setString(3, name);
			psmt.setString(4, nickname);
			psmt.setDate(5, birth);
			psmt.setString(6,phone);

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
	
}
