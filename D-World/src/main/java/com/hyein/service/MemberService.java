package com.hyein.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hyein.data.BoardData;
import com.hyein.data.MemberData;

public class MemberService {
	private String dbID = "HYEIN";
	private String dbPassWd = "1234";
	private String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
	private String driver = "oracle.jdbc.driver.OracleDriver";

	public ArrayList<MemberData> readGroups(int idx) {
		ArrayList<MemberData> groups = new ArrayList<MemberData>();
		String sql = "select g.name,g.idx  from groups g left join groups_member gm on g.idx = gm.g_idx where m_idx ="
				+ idx;
		int gidx = -1;
		String groupname = "";

		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbID, dbPassWd);

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				gidx = rs.getInt("idx");
				groupname = rs.getString("name");

				groups.add(new MemberData(gidx, groupname));

			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return groups;
	}

	public void groupInvite(int m_idx, int g_idx) {
		String sql = "INSERT INTO GROUPS_MEMBER (m_idx,g_idx) VALUES(" + m_idx + "," + g_idx + ")";
		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbID, dbPassWd);

			Statement st = con.createStatement();
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

	public void groupMake(int idx, String groupname) {
		String sql = "INSERT INTO GROUPS(name)" + " VALUES ('" + groupname + "')";

		String url = "jdbc:oracle:thin:@localhost:1521/xepdb1";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbID, dbPassWd);

			Statement st = con.createStatement();
			st.executeUpdate(sql);

			sql = " SELECT IDX FROM(SELECT * FROM GROUPS ORDER BY IDX DESC )WHERE ROWNUM =1  ";

			Statement st2 = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			int groupIdx = -1;
			while (rs.next()) {
				groupIdx = rs.getInt("idx");
			}

			sql = "INSERT INTO GROUPS_MEMBER (m_idx,g_idx) VALUES(" + idx + "," + groupIdx + ")";

			Statement st3 = con.createStatement();
			st.executeUpdate(sql);

			st.close();
			st2.close();
			rs.close();

			st3.close();
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public MemberData profile(int idx) {
		String sql = "SELECT ID,NAME,NICKNAME FROM MEMBER WHERE IDX=" + idx;
		String id = "";
		String name = "";
		String nickname = "";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, dbID, dbPassWd);

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				id = rs.getString("id");
				name = rs.getString("name");
				nickname = rs.getString("nickname");

			}

			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		MemberData memberdata = new MemberData(id, name, nickname);
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

					System.out.println("????????? ??????");

				} else {
					idx = -1;
					System.out.println("??????????????? ???????????????.");
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

	public void insertMember(String userid, String passwd, String name, String nickname, Date birth, String phone) {
		String sql = "INSERT INTO MEMBER(id,passwd,name,nickname,birth,phone,wdate,stat)"
				+ " VALUES (?,?,?,?,?,?,sysdate,1)";

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
			psmt.setString(6, phone);

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
