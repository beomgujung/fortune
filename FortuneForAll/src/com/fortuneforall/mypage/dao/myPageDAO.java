package com.fortuneforall.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fortuneforall.member.domain.Member;
import com.fortuneforall.util.ConnectionPool;
import com.fortuneforall.util.JdbcUtil;

public class myPageDAO {

	public Member selectMyInfo(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select * from tb97_member where id=?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Member member = new Member();
				member.setUserID(rs.getString("id"));
				member.setUserEmail(rs.getString("email"));
				member.setUserGender(rs.getInt("gender"));
				member.setUserBirth(rs.getString("birth"));
				return member;
			}
			
		} catch (Exception e) {
		}finally {
			JdbcUtil.close(pstmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
}
