package com.fortuneforall.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	private static final int INIT_COUNT = 5;
	private static List<Connection> free = new ArrayList<>();
	private static List<Connection> used = new ArrayList<>();
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			for (int i = 0; i < INIT_COUNT; i++) {
				Connection con = DriverManager.getConnection(
						"jdbc:oracle:thin:@192.168.0.63:1521:XE","hr","hr");
				free.add(con);
			}
		} catch (Exception e) {
			System.out.println("초기 ?? ?��?��?�� ?���? 발생");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception {
		if (free.isEmpty()) {
			throw new Exception("모든 커넥?��?�� ?��?��중입?��?��.");
		}
		 Connection con = free.remove(0);
		 used.add(con);
		 return con;
	}
	
	public static void releaseConnection(Connection con) {
		used.remove(con);
		free.add(con);
	}
}
