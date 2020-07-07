package in.awsexplorer.teamchat.api;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.awsexplorer.teamchat.model.Message;
import in.awsexplorer.teamchat.model.Space;
import in.awsexplorer.teamchat.repo.MessageRepository;
import in.awsexplorer.teamchat.repo.SpaceRepository;


@RestController
@RequestMapping("/api/message")
public class MessageApi {
	
	@Autowired
	private MessageRepository messageRepository;
	
	@GetMapping("/all")
	public List<Message> findAll() {
		List<Message> messages = messageRepository.findAll();
		return messages;
	}
	
	@PostMapping("/add")
	public String addMessage(@RequestBody Message message) {
		System.out.println("message:"+message.toString());
		Timestamp tnow=new Timestamp(new Date().getTime());
		message.setCreateTime(tnow);
		
		messageRepository.save(message);
		return "SUCCESS";
	}


}
