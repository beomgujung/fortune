package com.fortuneforall.pub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fortuneforall.pub.domain.Pub;
import com.fortuneforall.util.ConnectionPool;
import com.fortuneforall.util.JdbcUtil;

public class PubDAO {
	
	//전체 글조회
	public List<Pub> selectBoard(int page) {
		List<Pub> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select board_no, m.id, title, reg_date from TB97_BOARD b inner join tb97_member m on b.member_no = m.member_no where table_type = 2 order by board_no desc");
			
			stmt = con.prepareStatement(sql.toString());
//			for(int i=0;i<100;i++) {
//				if(i==page) {
//					stmt.setInt(1, i*10-9);
//					stmt.setInt(2, i*10);
//					break;
//				}
//			}
			ResultSet rs = stmt.executeQuery();
			int i=0;
			while(rs.next()) {
				Pub pub = new Pub();
				pub.setBno(rs.getInt("board_no"));
				pub.setTitle(rs.getString("title"));
				pub.setWriter(rs.getString("id"));
				pub.setReg_date(rs.getDate("reg_date"));
				list.add(pub);
				i++;
			}
			System.out.println(i);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	
	//선택 글조회
	public Pub selectByPub(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select board_no, title, m.id,content,reg_date from TB97_BOARD b inner join tb97_member m on b.member_no = m.member_no where table_type = 2 and b.board_no = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Pub pub = new Pub();
				pub.setBno(rs.getInt("board_no"));
				pub.setTitle(rs.getString("title"));
				pub.setWriter(rs.getString("id"));
				pub.setContent(rs.getString("content"));
				pub.setReg_date(rs.getDate("reg_date"));
				return pub;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	
	// 글 등록
	public void insertPub(Pub p) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			
			sql.append("insert into tb97_board(board_no,member_no,title,content,table_type) values(s_board_no.nextval,(select member_no from tb97_member where id=?),?,?,2)");
			
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, p.getWriter());
			pstmt.setString(2, p.getTitle());
			pstmt.setString(3, p.getContent());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	// 글 수정
	public void updatePub(Pub p) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			
			sql.append(" UPDATE TB97_BOARD ");
			sql.append(" SET TITLE = ? ,CONTENT = ? ");
			sql.append(" WHERE BOARD_NO = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			pstmt.setString(1, p.getTitle());
			pstmt.setString(2, p.getContent());
			pstmt.setInt(3, p.getBno());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	
	// 글 삭제
	public boolean deletePub(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" DELETE ");
			sql.append(" FROM TB97_BOARD ");
			sql.append(" WHERE BOARD_NO = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			
			int cnt = pstmt.executeUpdate();
			if (cnt == 0) {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		
		return true;
	}
	
	public int checkId(String id, int board_no) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select m.member_no from tb97_member m inner join tb97_board b on b.member_no = m.member_no where m.id = ? and b.board_no = ?");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, id);
			stmt.setInt(2, board_no);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				if(rs.getInt("member_no")!=0) {
					System.out.println("same person");
					return 0;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return 1;
	}
	
	
	
}
