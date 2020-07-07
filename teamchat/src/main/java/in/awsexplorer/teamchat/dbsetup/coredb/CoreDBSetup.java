package in.awsexplorer.teamchat.dbsetup.coredb;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.awsexplorer.teamchat.dbsetup.DbSetupUtil;

@Component
class CoreDBSetup {

	private Connection dbConnection;

	public CoreDBSetup(@Autowired AdminDBConnection adminDbConnection) {
		this.dbConnection = adminDbConnection.getDbConnection();
	}

	public void setupDatabase() {
		createDatabase(dbConnection);
		createRoles(dbConnection);
		addUserToMySqlServer(dbConnection);
		addUserToDatabase(dbConnection);
	}

	private void createDatabase(Connection conn) {
		List<String> ddlFiles = new ArrayList<>();
		ddlFiles.add("ddl/db_teamchatdb.ddl");
		DbSetupUtil.executeSqlFiles(ddlFiles, conn);
	}

	private void createRoles(Connection conn) {
		List<String> ddlFiles = new ArrayList<>();
		ddlFiles.add("ddl/db_roles.ddl");
		DbSetupUtil.executeSqlFiles(ddlFiles, conn);
	}

	private void addUserToMySqlServer(Connection conn) {
		String[] ddlStatement = new String[2];

		String username = System.getenv("chatusername");
		String userpassword = System.getenv("chatuserpassword");

		ddlStatement[0] = "DROP USER " + username + ";";
		ddlStatement[1] = "CREATE USER '" + username + "'@'%' IDENTIFIED BY '" + userpassword + "';";

		DbSetupUtil.executeSqlFiles(ddlStatement, conn);
	}

	private void addUserToDatabase(Connection conn) {
		List<String> ddlFiles = new ArrayList<>();
		ddlFiles.add("ddl/db_adduserstorole.ddl");
		DbSetupUtil.executeSqlFiles(ddlFiles, conn);
	}

}
