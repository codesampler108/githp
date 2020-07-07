package in.awsexplorer.teamchat.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.awsexplorer.teamchat.model.Chat;


public interface ChatRepository extends JpaRepository<Chat, Integer>{

}
