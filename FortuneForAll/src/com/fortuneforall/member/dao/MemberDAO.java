package com.fortuneforall.member.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.fortuneforall.member.domain.Member;
import com.fortuneforall.util.ConnectionPool;
import com.fortuneforall.util.JdbcUtil;;

public class MemberDAO {
	
	public int login(String userID, String userPassword) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append(" SELECT member_no FROM TB97_MEMBER WHERE ID = ? and Password = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, userID);
			pstmt.setString(2, userPassword);

			ResultSet rs = pstmt.executeQuery();
			
			System.out.println(rs.toString());
			while(rs.next()) {
				if(rs.getInt("member_no") != 0) {
					return 1;
				}
			}
			return -1; // 아이디가 없음
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.releaseConnection(con);
			JdbcUtil.close(pstmt);
		}
		return 2;
	}
	
	
	public void insertMember(Member member) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into tb97_member(member_no,id,password,email,name,birth,calender,birth_time,gender,question,answer) values(s_member_no.nextVal,?,?,?,?,?,?,?,?,?,?)");
			
			pstmt = con.prepareStatement(sql.toString());
			System.out.println("join");
			pstmt.setString(1, member.getUserID());
			pstmt.setString(2, member.getUserPassword());
			pstmt.setString(3, member.getUserEmail());
			pstmt.setString(4, member.getUserName());
			pstmt.setString(5, member.getUserBirth());
			pstmt.setInt(6, member.getUserCalender());
			pstmt.setString(7, member.getUserBirth_time());
			pstmt.setInt(8, member.getUserGender());
			pstmt.setString(9, member.getUserQuestion());
			pstmt.setString(10, member.getUserAnswer());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.releaseConnection(con);
			JdbcUtil.close(pstmt);
		}
		
	}
	public String idFind(String email) {
		Connection con1 = null;
		PreparedStatement stmt = null;
		String id=null;
		try {
			con1 = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select id from tb97_member where email = ?  ");
			stmt = con1.prepareStatement(sql.toString());
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				id=rs.getString("id");
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con1);
		}
		return id;
		
	
}
	public String passwordfind(String id, String question, String answer) {
		Connection con = null;
		PreparedStatement stmt = null;
			String password=null;		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select password from tb97_member where id = ?  and question= ? and answer= ?");
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, id);
			stmt.setString(2, question);
			stmt.setString(3, answer);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				password =rs.getString("password");
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return password;
		
	
}
	public int idoverlap(String overlapid) {
		Connection con = null;
		PreparedStatement stmt = null;
			String id=null;		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select id from tb97_member where id = ? ");
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, overlapid);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()){
				id =rs.getString("id");
			}
			if(id==null) {
				return 0;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return 1;
	}
	
	
	public boolean memberIDCheck(String id)
    {	
	 
	 	System.out.println(id);
        Connection con = null;
        PreparedStatement stmt = null;
        boolean b = false;
        
        try {
          
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT ID FROM tb97_member WHERE ID=?");
                        
            con = ConnectionPool.getConnection();
            stmt = con.prepareStatement(sql.toString());
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) b = true; //해당 아이디 존재
            
            
        	} catch (Exception e) {
        		e.printStackTrace();
        	} finally {
        		JdbcUtil.close(stmt);
        		ConnectionPool.releaseConnection(con);
            }
        return b;
    }
	
}


