package com.fortuneforall.fortunereview.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fortuneforall.drink.domain.Drink;
import com.fortuneforall.fortunereview.domain.FortuneReview;
import com.fortuneforall.util.ConnectionPool;
import com.fortuneforall.util.JdbcUtil;

public class FortuneReviewDAO {
	
	public List<FortuneReview> selectBoard(int page) {
		List<FortuneReview> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
//			sql.append("select rownum, board_no, m.id, title, reg_date from TB97_BOARD b inner join tb97_member m on b.member_no = m.member_no where table_type = 1 and rownum between ? and ? order by board_no desc");
			sql.append("select board_no, m.id, title, reg_date from TB97_BOARD b inner join tb97_member m on b.member_no = m.member_no where table_type = 4 order by board_no desc");
			
			stmt = con.prepareStatement(sql.toString());
			
//			for(int i=0;i<100;i++) {
//				if(i==page) {
//					stmt.setInt(1, i*10-9);
//					stmt.setInt(2, i*10);
//					break;
//				}
//			}
		
			System.out.println("dao");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				FortuneReview fr = new FortuneReview();
				fr.setBoard_no(rs.getInt("board_no"));
				fr.setTitle(rs.getString("title"));
				fr.setWriter(rs.getString("id"));
				fr.setRegDate(rs.getDate("reg_date"));
				list.add(fr);
				System.out.println(rs.getInt("board_no"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return list;
	}
	
	public FortuneReview selectByNo(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select board_no, title, m.id,content,reg_date from TB97_BOARD b inner join tb97_member m on b.member_no = m.member_no where table_type = 4 and b.board_no = ?");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, no);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				FortuneReview fr = new FortuneReview();
				fr.setBoard_no(rs.getInt("board_no"));
				fr.setTitle(rs.getString("title"));
				fr.setWriter(rs.getString("id"));
				fr.setContent(rs.getString("content"));
				fr.setRegDate(rs.getTimestamp("reg_date"));
				return fr;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	
	public void insertFortuneReview(FortuneReview fr) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
//			sql.append("insert into tb97_board(board_no,member_no,title,content,table_type) values(s_board_no.nextval,?,?,?,1)");
			sql.append("insert into tb97_board(board_no,member_no,title,content,table_type) values(s_board_no.nextval,(select member_no from tb97_member where id=?),?,?,4)");
			
			stmt = con.prepareStatement(sql.toString());
			
			stmt.setString(1, fr.getWriter());
			stmt.setString(2, fr.getTitle());
			stmt.setString(3, fr.getContent());

			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	public void updateFortuneReview(FortuneReview fr) {
		Connection con = null;
		PreparedStatement stmt = null;
		System.out.println("update dao");
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update tb97_board set title = ?, content = ?  where board_no = ?");
			
			stmt = con.prepareStatement(sql.toString());
			
			stmt.setString(1, fr.getTitle());
			stmt.setString(2, fr.getContent());
			stmt.setInt(3, fr.getBoard_no());
		
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	public boolean deleteFortuneReview(int no) {
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
















