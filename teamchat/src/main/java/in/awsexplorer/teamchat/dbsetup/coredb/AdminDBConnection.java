package in.awsexplorer.teamchat.dbsetup.coredb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
class AdminDBConnection {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminDBConnection.class);

	/* NOTE - spring puts all properties in Environment. You can wire the bean and use getProperty to get the values
	@Autowired
	private Environment environment;
	// in your code put this..
	String url=environment.getProperty("spring.datasource.url");
	*/
	
	@Value("${spring.datasource.url}")
	private String dbUrl;
	
	public AdminDBConnection() {
	}

	public Connection getDbConnection() {
		try {
			dbUrl = removeDbFromDbUrl(dbUrl);
			System.out.println("url:"+dbUrl);
			String username = System.getenv("chatuseradminname"); // this has to be admin user on the database you are connecting to
			String password = System.getenv("chatuseradminpassword"); // this has to be admin user on the database you are connecting to
			if ( username == null || password == null ) {
				logger.error("database admin user detials need to be set up in environment.");
				System.exit(-1);
			}
			return DriverManager.getConnection(dbUrl, username, password);
		}catch ( SQLException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		return null;
		
	}

	private String removeDbFromDbUrl(String dbUrlParam) {
		// remove DB from url as this is Admin Connection for the server, not for a given DB.
		String[] split = dbUrlParam.split("/");
		String[] copyOf = Arrays.copyOf(split,split.length-1);
		String urlWithoutDB = String.join("/", copyOf);
		return urlWithoutDB;
	}
	
}
