package in.awsexplorer.teamchat.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.awsexplorer.teamchat.model.Chat;
import in.awsexplorer.teamchat.model.Message;


public interface MessageRepository extends JpaRepository<Message, Integer>{

}
