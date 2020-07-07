package in.awsexplorer.teamchat.dbsetup.content.ddl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import in.awsexplorer.teamchat.dbsetup.content.AppDBConfig;

@Component
public class AppDBSetupMain {

	@Autowired
	private DbSetupTables dbSetupTables;

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppDBConfig.class);
		AppDBSetupMain main = context.getBean(AppDBSetupMain.class);
		main.createDb();
	}
	
	public void createDb() {
		dbSetupTables.setupTables();
	}
}
