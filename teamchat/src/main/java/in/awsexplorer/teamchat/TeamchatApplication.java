package in.awsexplorer.teamchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.awsexplorer.teamchat.dbsetup.content.ddl.AppDBSetupMain;

@SpringBootApplication
public class TeamchatApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamchatApplication.class, args);
	}

}
