package in.awsexplorer.teamchat.dbsetup.content.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import in.awsexplorer.teamchat.dbsetup.content.AppDBConfig;

@Component
public class CreateDataMain {

	@Autowired
	private CreateData createData;
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppDBConfig.class);
		CreateDataMain main = context.getBean(CreateDataMain.class);
		main.createDb();
	}
	
	public void createDb() {
		createData.addData();
	}


}
