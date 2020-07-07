package in.awsexplorer.teamchat.dbsetup.coredb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CoreDBSetupMain {
	
	@Autowired
	private CoreDBSetup dbSetupDatase;

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AdminDBConfig.class);
		CoreDBSetupMain main = context.getBean(CoreDBSetupMain.class);
		main.createDb();
	}
	
	public void createDb() {
		dbSetupDatase.setupDatabase();
	}
}
