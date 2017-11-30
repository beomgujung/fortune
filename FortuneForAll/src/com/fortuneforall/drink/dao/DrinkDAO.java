package com.fortuneforall.drink.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.fortuneforall.boardfile.domain.BoardFile;
import com.fortuneforall.drink.domain.Drink;
import com.fortuneforall.member.domain.Member;
import com.fortuneforall.util.ConnectionPool;
import com.fortuneforall.util.JdbcUtil;

public class DrinkDAO {
	
	public List<Drink> selectBoard(int page) {
		List<Drink> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
		    sql.append("select board_no, m.id, title, reg_date from TB97_BOARD b inner join tb97_member m on b.member_no = m.member_no where table_type = 1 order by board_no desc");
			
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
				Drink drink = new Drink();
				drink.setBoard_no(rs.getInt("board_no"));
				drink.setTitle(rs.getString("title"));
				drink.setWriter(rs.getString("id"));
				drink.setRegDate(rs.getDate("reg_date"));
				list.add(drink);
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
	
	public Drink selectByNo(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select board_no, title, m.id,content,reg_date from TB97_BOARD b inner join tb97_member m on b.member_no = m.member_no where table_type = 1 and b.board_no = ?");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setInt(1, no);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Drink drink = new Drink();
				drink.setBoard_no(rs.getInt("board_no"));
				drink.setTitle(rs.getString("title"));
				drink.setWriter(rs.getString("id"));
				drink.setContent(rs.getString("content"));
				drink.setRegDate(rs.getTimestamp("reg_date"));
				return drink;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
	
	public void insertDrink(Drink drink) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into tb97_board(board_no,member_no,title,content,table_type) values(?,(select member_no from tb97_member where id=?),?,?,1)");
			
			stmt = con.prepareStatement(sql.toString());
			
			stmt.setInt(1, drink.getBoard_no());
			stmt.setString(2, drink.getWriter());
			stmt.setString(3, drink.getTitle());
			stmt.setString(4, drink.getContent());

			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	public void updateDrink(Drink drink) {
		Connection con = null;
		PreparedStatement stmt = null;
		System.out.println("update dao");
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update tb97_board set title = ?, content = ?  where board_no = ?");
			
			stmt = con.prepareStatement(sql.toString());
			
			stmt.setString(1, drink.getTitle());
			stmt.setString(2, drink.getContent());
			stmt.setInt(3, drink.getBoard_no());
		
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
	public boolean deleteDrink(int no) {
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
	
	public int selectBoardNo() {
		int no=0;
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select s_board_no.nextval from daul");
			
			stmt = con.prepareStatement(sql.toString());
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				no = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return no;
	}
	
	public void insertFile(BoardFile file) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into tb97_board_file(file_no, board_no ,file_size ,file_org_name,file_system_name, file_path) values(s_tb97_board_file_no.nextval,?,?,?,?,?)");
			
			stmt = con.prepareStatement(sql.toString());
			
			stmt.setInt(1, file.getBoard_no());
			stmt.setInt(2, file.getFile_size());
			stmt.setString(3, file.getFile_org_name());
			stmt.setString(4, file.getFile_system_name());
			stmt.setString(5, file.getFile_path());

			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
	}
}
















