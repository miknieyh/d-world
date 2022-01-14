package com.hyein.data;

import java.sql.Timestamp;
import java.util.ArrayList;

public class BoardData {
	private int idx;
	private String contents;
	private Timestamp wdate;
	private int stat; 
	private String writer; 
	private boolean mine;
	private ArrayList<String> photo;
	
	public BoardData(int idx, String contents, Timestamp wdate,String writer,int stat) {
		this.idx = idx;
		this.contents= contents;
		this.wdate=wdate;
		this.writer = writer;
		this.stat = stat;

	}
	
	public BoardData(int idx, String contents, Timestamp wdate, int stat, String writer, boolean mine,
			ArrayList<String> photo) {
		this.idx = idx;
		this.contents = contents;
		this.wdate = wdate;
		this.stat = stat;
		this.writer = writer;
		this.mine = mine;
		this.photo = photo;
	}
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Timestamp getWdate() {
		return wdate;
	}
	public void setWdate(Timestamp wdate) {
		this.wdate = wdate;
	}
	public int getStat() {
		return stat;
	}
	public void setStat(int stat) {
		this.stat = stat;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public boolean isMine() {
		return mine;
	}
	public void setMine(boolean mine) {
		this.mine = mine;
	}
	public ArrayList<String> getPhoto() {
		return photo;
	}
	public void setPhoto(ArrayList<String> photo) {
		this.photo = photo;
	}
	
	
	
}