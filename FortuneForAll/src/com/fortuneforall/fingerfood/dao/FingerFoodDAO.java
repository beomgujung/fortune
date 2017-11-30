package com.fortuneforall.fingerfood.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.fortuneforall.drink.domain.Drink;
import com.fortuneforall.fingerfood.domain.FingerFood;
import com.fortuneforall.member.domain.Member;
import com.fortuneforall.util.ConnectionPool;
import com.fortuneforall.util.JdbcUtil;

public class FingerFoodDAO {
	
	public List<FingerFood> selectBoard(int page) {
		List<FingerFood> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select board_no, m.id, title, reg_date from TB97_BOARD b inner join tb97_member m on b.member_no = m.member_no where table_type = 3 order by board_no desc");
			
			stmt = con.prepareStatement(sql.toString());
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				FingerFood fingerFood = new FingerFood();
				fingerFood.setBoard_no(rs.getInt("board_no"));
				fingerFood.setTitle(rs.getString("title"));
				fingerFood.setWriter(rs.getString("id"));
				fingerFood.setRegDate(rs.getDate("reg_date"));
				list.add(fingerFood);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	
	public FingerFood selectByNo(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select board_no, title, m.id,content,reg_date from TB97_BOARD b inner join tb97_member m on b.member_no = m.member_no where table_type = 3 and b.board_no = ?");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, no);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				FingerFood fingerFood = new FingerFood();
				fingerFood.setBoard_no(rs.getInt("board_no"));
				fingerFood.setTitle(rs.getString("title"));
				fingerFood.setWriter(rs.getString("id"));
				fingerFood.setContent(rs.getString("content"));
				fingerFood.setRegDate(rs.getTimestamp("reg_date"));
				return fingerFood;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	public void insertFingerFood(FingerFood fingerFood) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into tb97_board(board_no,member_no,title,content,table_type) values(s_board_no.nextval,(select member_no from tb97_member where id=?),?,?,3)");
			
			stmt = con.prepareStatement(sql.toString());
			
			stmt.setString(1, fingerFood.getWriter());
			stmt.setString(2, fingerFood.getTitle());
			stmt.setString(3, fingerFood.getContent());

			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	public void updateFingerFood(FingerFood fingerFood) {
		Connection con = null;
		PreparedStatement stmt = null;
		System.out.println("update");
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update tb97_board set title = ?, content = ?  where board_no = ?");
			
			stmt = con.prepareStatement(sql.toString());
			
			stmt.setString(1, fingerFood.getTitle());
			stmt.setString(2, fingerFood.getContent());
			stmt.setInt(3, fingerFood.getBoard_no());
		
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	public boolean deleteFingerFood(int no) {
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
