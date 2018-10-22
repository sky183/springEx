package com.david.op.jdbc;

import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;



public class DBCPInit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		// 1. 데이터베이스 드라이버 로드
		loadJDBCDRiver();

		// 2. POOL 드라이버 로드
		initConnectionPool();

	}

	private void loadJDBCDRiver() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("데이터베이스 드라이버 로드 성공!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private void initConnectionPool() {

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "OPENPROJECT";
		String pw = "1234";

		try {
			ConnectionFactory connFactory = new DriverManagerConnectionFactory(url, user, pw);

			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);
			// 커넥션이 유효한지 여부를 검사할 때 사용하는 쿼리를 지정한다.
			poolableConnFactory.setValidationQuery("select 1");
			// 커넥션 풀의 설정 정보를 생성한다.
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			// 유휴 커넥션 검사 주기
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L);
			// 풀에 보관중인 커넥션이 유효한지 검사할지 유무 설정
			poolConfig.setTestWhileIdle(true);
			poolConfig.setMinIdle(4);
			// 커넥션 최대 개수
			poolConfig.setMaxTotal(50);
			// 커넥션 풀을 생성. 생성자는 PoolabeConnectionFactory와 GenericObjectPoolConfig를 사용
			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnFactory,
					poolConfig);
			// PoolabeConnectionFactory에도 커넥션 풀을 연결
			poolableConnFactory.setPool(connectionPool);
			// 커넥션 풀을 제공하는 jdbc 드라이버를 등록.
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			// 위에서 커넥션 풀 드라이버에 생성한 커넥션 풀을 등록한다. 이름은 chap14 이다.
			driver.registerPool("open2", connectionPool);
			System.out.println("Pooling등록 성공!");
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
