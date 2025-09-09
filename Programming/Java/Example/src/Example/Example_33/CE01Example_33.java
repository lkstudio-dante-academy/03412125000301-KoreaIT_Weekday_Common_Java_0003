package Example.Example_33;

/*
 * 데이터베이스 (Database) 란?
 * - 효율적으로 관리 할 수 있도록 구성 된 데이터의 집합을 의미한다. (+ 즉,
 * 데이터베이스는 데이터를 저장 할 수 있는 물리적인 저장소라는 것을 알 수 있다.)
 *
 * DBMS (Database Management System) 이란?
 * - 데이터베이스를 제어하기 위한 소프트웨어를 의미한다. (+ 즉,
 * DBMS 는 데이터베이스에 데이터를 저장하거나 읽어들일 수 있는 다양한 기능을 제공한다.)
 *
 * 주요 DBMS 종류
 * - 관계형 DBMS (RDBMS)				<- MySQL, SQLite 등등...
 * - 비관계형 DBMS (NoSQL)			<- MongoDB, Redis 등등...
 *
 * 관계형 DBMS (RDBMS) 란?
 * - 데이터를 행 (Row) 과 열 (Column) 로 구성 된 테이블 (Table) 형태로 저장하고 테이블 간의 관계를 기반으로
 * 데이터를 관리하는 데이터베이스 시스템을 의미한다. (+ 즉, 데이터를 정형화 된 형식으로 관리 한다는 것을
 * 알 수 있다.)
 *
 * 관계형 DBMS 는 현재 가장 많이 활용되는 데이터베이스 시스템이다.
 *
 * 비관계형 DBMS (NoSQL) 란?
 * - 테이블 형태가 아닌 유연한 형태 (+ Ex. Json 등등...) 로 데이터를 저장하고 관리하는
 * 데이터베이스 시스템을 의미한다. (+ 즉, 관계형 DBMS 에 비해 관리하는 데이터의 형태가 자유롭다는 것을 알 수 있다.)
 *
 * SQL (Structured Query Language) 이란?
 * - 관계형 DBMS 를 대상으로 데이터를 조회, 검색, 제거 등을 지시 할 수 있는 언어를 의미한다. (+ 즉,
 * SQL 을 활용하면 관계형 DBMS 와 서로 상호 작용하는 것이 가능하다.)
 *
 * SQL 은 비교적 간단한 문법으로 이루어져 있으며 SQL 을 활용하면 관계형 DBMS 를 대상으로 여러 작업을 처리하는 것이
 * 가능하다.
 *
 * SQLite 란?
 * - 관계형 DBMS 중 하나로서 서버 없이 단일 파일을 기반으로 동작하는 데이터베이스 시스템을 의미한다. (+ 즉,
 * SQLite 를 활용하면 네트워크가 연결 되어있지 않는 환경에서도 데이터베이스를 기반으로 데이터를 관리하는 것이
 * 가능하다.)
 *
 * SQLite 는 서버가 필요 없기 때문에 클라이언트 단에서 주로 사용 되는 데이터베이스 시스템이며
 * 모바일과 같이 비교적 적은 데이터를 단독으로 다루는 환경에서 적합하다. (+ 즉, SQLite 는
 * 여러 사용자가 공유하는 환경에서는 적합하지 않다는 것을 의미한다.)
 *
 * Java 에서 SQLite 와 같은 데이터베이스를 연동하기 위해서는 JDBC (Java Database Connectivity) 를
 * 활용해야한다.
 *
 * JDBC (Java Database Connectivity) 란?
 * - Java 에서 데이터베이스와 연결하고 SQL 을 실행하기 위한 표준 API 입니다. (+ 즉, JDBC 를 활용하면
 * 다양한 데이터베이스를 손쉽게 제어하는 것이 가능하다.)
 *
 * JDBC 는 인터페이스의 집합이며 각 데이터베이스 벤더 (Oracle, MySQL, SQLite 등등...) 는 이 인터페이스를
 * 구현한 드라이버를 제공합니다.
 *
 * Java 프로그램은 JDBC API 를 사용해 DB 연결, SQL 실행, 결과 조회 등의 작업을 처리하는 것이 가능하다.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Example 33 (데이터베이스)
 */
public class CE01Example_33 {
	/** 초기화 */
	public static void start(String[] args) {
		/*
		 * DriverManager 클래스란?
		 * - DB 드라이버를 관리하고 연결을 제어하는 역할을 수행하는 클래스를 의미한다. (+ 즉,
		 * DriverManager 클래스를 활용하면 SQLite 와 같은 DB 를 손쉽게 제어하는 것이 가능하다.)
		 *
		 * Connection 클래스란?
		 * - DB 를 제어하는 역할을 수행하는 클래스를 의미한다. (+ 즉, Connection 클래스를 활용하면
		 * DB 에 SQL 구문을 실행하는 등의 작업을 처리하는 것이 가능하다.)
		 */
		try(Connection oConnection = DriverManager.getConnection("jdbc:sqlite:P_E01Example_33_01.db")) {
			/*
			 * Primary Key 란?
			 * - 레코드 (Record) 를 식별 할 수 있는 필드를 의미한다. (+ 즉, Primary Key 는
			 * 데이터를 식별하기 위한 식별자이기 때문에 중복이 허용 되지 않는다.)
			 *
			 * Primary Key 가 명시 된 필드의 데이터는 해당 레코드를 대표하는 데이터이기 때문에
			 * Primary Key 를 활용하면 특정 데이터를 빠르게 탐색하는 것이 가능하다.
			 */
			String oSQL_CreateTable = "CREATE TABLE IF NOT EXISTS MemberTable(Name TEXT PRIMARY KEY, PNumber TEXT)";
			
			/*
			 * Statement 클래스란?
			 * - SQL 구문을 실행하고 실행에 대한 결과를 제어하는 역할을 수행하는 클래스를 의미한다. (+ 즉,
			 * Statement 클래스를 활용하면 DB 에 테이블을 생성하는 등의 명령을 실행하는 것이 가능하다.)
			 */
			try(Statement oStatement = oConnection.createStatement()) {
				/*
				 * execute 메서드란?
				 * - SQL 구문을 실행하는 역할을 수행하는 메서드를 의미한다. (+ 즉,
				 * execute 메서드를 활용하면 DB 에 SQL 구문을 전달해서 실행 시키는 것이 가능하다.)
				 *
				 * 일반적으로 DB 는 Primary Key 설정을 강제 하지 않지만 가능하면 Primary Key 를
				 * 설정 해주는 것이 좋다. (+ 즉, Primary Key 를 설정하면 데이터를 명확하게 식별하는 것이
				 * 가능하다.)
				 */
				oStatement.execute(oSQL_CreateTable);
			}
			
			String oSQL_InsertMember = "INSERT OR IGNORE INTO MemberTable(Name, PNumber) VALUES(?, ?)";
			
			/*
			 * PreparedStatement 클래스란?
			 * - 미리 컴파일 된 SQL 구문을 실행하고 실행에 대한 결과를 제어하는 역할을 수행하는 클래스를
			 * 의미한다. (+ 즉, PreparedStatement 클래스를 활용하면 Statement 클래스보다 좀 더 빠르게
			 * SQL 구문을 처리하는 것이 가능하다.)
			 *
			 * 또한 PreparedStatement 클래스는 ? 구문으로 데이터를 바인딩하는 SQL 구문을 처리하는 것이
			 * 가능하다. (+ 즉, PreparedStatement 클래스는 데이터와 SQL 구문을 동적으로 바인딩하는 기능을
			 * 제공한다는 것을 알 수 있다.)
			 */
			try(PreparedStatement oStatement = oConnection.prepareStatement(oSQL_InsertMember)) {
				oStatement.setString(1, "회원 A");
				oStatement.setString(2, "1234");
				
				oStatement.execute();
				
				oStatement.setString(1, "회원 B");
				oStatement.setString(2, "1234");
				
				oStatement.execute();
			}
			
			String oSQL_Query = "SELECT * FROM MemberTable";
			
			try(Statement oStatement = oConnection.createStatement()) {
				/*
				 * ResultSet 클래스란?
				 * - SQL 구문 중 SELECT 명령문을 실행 한 결과를 제어하는 역할을 수행하는 클래스를 의미한다.
				 * (+ 즉, ResultSet 클래스를 활용하면 DB 로부터 가져온 데이터의 필드를 가져오는 것이
				 * 가능하다.)
				 *
				 * ResetSet 은 열거 가능한 객체이기 때문에 반복문을 활용하면 쿼리 결과로 가져 온
				 * 모든 데이터에 접근하는 것이 가능하다.
				 *
				 * executeQuery 메서드란?
				 * - SQL 구문 중 SELECT 명령문을 실행하고 실행에 대한 결과를 반환하는 메서드를 의미한다.
				 * (+ 즉, executeQuery 메서드를 활용하면 DB 로부터 데이터를 가져오는 것이 가능하다.)
				 */
				ResultSet oResult = oStatement.executeQuery(oSQL_Query);
				
				System.out.println("=====> 모든 회원 정보 <=====");
				
				while(oResult.next()) {
					System.out.printf("이름 : %s\n", oResult.getString(1));
					System.out.printf("전화 번호 : %s\n\n", oResult.getString(2));
				}
			}
		} catch(Exception oException) {
			oException.printStackTrace();
		}
	}
}
