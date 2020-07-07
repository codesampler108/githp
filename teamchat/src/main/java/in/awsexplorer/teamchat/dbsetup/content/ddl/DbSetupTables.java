package in.awsexplorer.teamchat.dbsetup.content.ddl;

import java.io.File;
import java.net.URL;
import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.awsexplorer.teamchat.dbsetup.DbSetupUtil;
import in.awsexplorer.teamchat.dbsetup.content.AppDBConnection;

@Component
class DbSetupTables {
	
    private Connection dbConnection;

    public DbSetupTables(@Autowired AppDBConnection appDbConnection) {
        this.dbConnection = appDbConnection.getDbConnection();
    }
    
    public void setupTables() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("ddl/tables");
		String path = url.getPath();
		File[] ddlFiles = new File(path).listFiles();
		DbSetupUtil.executeSqlFiles(ddlFiles, dbConnection);
    }

	
}
