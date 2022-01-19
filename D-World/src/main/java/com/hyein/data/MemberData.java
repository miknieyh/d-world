package com.hyein.data;

import java.sql.Date;
import java.sql.Timestamp;

public class MemberData {
	private int idx;
	private String userid;
	private String name;
	private String passwd;
	private String phone;
	private String nickname;
	private Timestamp wdate;
	private Date birth;
	private int stat;
	private String groupname;
	private int g_idx;
	
	
	public MemberData(int g_idx, String groupname) {
		this.g_idx=g_idx;
		this.groupname=groupname;
	}
	
	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public int getG_idx() {
		return g_idx;
	}

	public void setG_idx(int g_idx) {
		this.g_idx = g_idx;
	}

	public MemberData (String userid, String name, String nickname) {
		this.userid=userid;
		this.name = name;
		this.nickname=nickname;
	}
	
	public MemberData(int idx, int stat) {
		this.idx=idx;
		this.stat=stat;
	}
	
	public MemberData(int idx, String userid, String name, String passwd, String phone, String nickname,
			Timestamp wdate, Date birth, int stat) {
		this.idx = idx;
		this.userid = userid;
		this.name = name;
		this.passwd = passwd;
		this.phone = phone;
		this.nickname = nickname;
		this.wdate = wdate;
		this.birth = birth;
		this.stat = stat;
	}
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Timestamp getWdate() {
		return wdate;
	}
	public void setWdate(Timestamp wdate) {
		this.wdate = wdate;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	
	
	
	
}
