package in.awsexplorer.teamchat.dbsetup.content;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppDBConnection {

	private static final Logger logger = LoggerFactory.getLogger(AppDBConnection.class);
	
	@Value("${spring.datasource.url}")
	private String dbUrl;
	
	public Connection getDbConnection() {
		try {
			String username = System.getenv("chatusername"); // this has to be admin user on the database you are connecting to
			String password = System.getenv("chatuserpassword"); // this has to be admin user on the database you are connecting to
			if ( username == null || password == null ) {
				logger.error("database app user detials need to be set up in environment.");
				System.exit(-1);
			}
			return DriverManager.getConnection(dbUrl, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return null;
	}
}
