package in.awsexplorer.teamchat.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.awsexplorer.teamchat.model.AppUser;


public interface AppUserRepository extends JpaRepository<AppUser, Integer>{
	
	
}
