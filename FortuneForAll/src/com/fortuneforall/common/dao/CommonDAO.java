package com.fortuneforall.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import com.fortuneforall.drink.domain.Drink;
import com.fortuneforall.member.domain.Member;
import com.fortuneforall.util.ConnectionPool;
import com.fortuneforall.util.JdbcUtil;

public class CommonDAO {
	public Member checkDate(String id) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = ConnectionPool.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select birth, gender, calender from tb97_member where id=?");
			
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Member m = new Member();
				m.setUserBirth(rs.getString("birth"));
				m.setUserGender(rs.getInt("gender"));
				m.setUserCalender(rs.getInt("calender"));
				System.out.println("commondao birth : " + rs.getString("birth"));
				return m;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(stmt);
			ConnectionPool.releaseConnection(con);
		}
		return null;
	}
}
