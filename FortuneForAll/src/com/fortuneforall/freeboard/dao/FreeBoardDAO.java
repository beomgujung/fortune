package com.fortuneforall.freeboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fortuneforall.drink.domain.Drink;
import com.fortuneforall.freeboard.domain.FreeBoard;
import com.fortuneforall.util.ConnectionPool;
import com.fortuneforall.util.JdbcUtil;

public class FreeBoardDAO {
	
	public List<FreeBoard> selectBoard(int page) {
		List<FreeBoard> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;   
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
		    sql.append("select board_no, m.id, title, reg_date from TB97_BOARD b inner join tb97_member m on b.member_no = m.member_no where table_type = 5 order by board_no desc");
			
			stmt = con.prepareStatement(sql.toString());
			
			ResultSet rs = stmt.executeQuery();
			int i=0;
			while(rs.next()) {
				FreeBoard freeboard = new FreeBoard();
				freeboard.setBoard_no(rs.getInt("board_no"));
				freeboard.setTitle(rs.getString("title"));
				freeboard.setWriter(rs.getString("id"));
				freeboard.setRegDate(rs.getDate("reg_date"));
				list.add(freeboard);
				i++;	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	public FreeBoard selectByNo(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select board_no, title, m.id,content,reg_date from TB97_BOARD b inner join tb97_member m on b.member_no = m.member_no where table_type = 5 and b.board_no = ?");
				
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, no);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				FreeBoard freeboard = new FreeBoard();
				freeboard.setBoard_no(rs.getInt("board_no"));
				freeboard.setTitle(rs.getString("title"));
				freeboard.setWriter(rs.getString("id"));
				freeboard.setContent(rs.getString("content"));
				freeboard.setRegDate(rs.getTimestamp("reg_date"));
				return freeboard;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	public void insertFreeBoard(FreeBoard freeboard) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into tb97_board(board_no,member_no,title,content,table_type) values(s_board_no.nextval,(select member_no from tb97_member where id=?),?,?,5)");
			
			stmt = con.prepareStatement(sql.toString());
			
			stmt.setString(1, freeboard.getWriter());
			stmt.setString(2, freeboard.getTitle());
			stmt.setString(3, freeboard.getContent());

			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	public void updateFreeBoard(FreeBoard freeboard) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update tb97_board set title = ?, content = ? where board_no = ?");
			
			stmt = con.prepareStatement(sql.toString());
			
			stmt.setString(1, freeboard.getTitle());
			stmt.setString(2, freeboard.getContent());
			stmt.setInt(3, freeboard.getBoard_no());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	public boolean deleteFreeBoard(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete from tb97_board where board_no = ?");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, no);
			int cnt = stmt.executeUpdate();
			
			if(cnt == 0) {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
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
