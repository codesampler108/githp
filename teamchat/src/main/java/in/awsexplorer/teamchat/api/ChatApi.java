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

import in.awsexplorer.teamchat.model.Chat;
import in.awsexplorer.teamchat.repo.ChatRepository;


@RestController
@RequestMapping("/api/chat")
public class ChatApi {
	
	@Autowired
	private ChatRepository chatRepository;
	
	@GetMapping("/all")
	public List<Chat> findAll() {
		List<Chat> chats = chatRepository.findAll();
		return chats;
	}
	
	@PostMapping("/add")
	public String addChat(@RequestBody Chat chat) {
		System.out.println("chat:"+chat.toString());
		Timestamp tnow=new Timestamp(new Date().getTime());
		chat.setUpdateTime(tnow);
		if ( null==chat.getCreateTime() ) {
			chat.setCreateTime(tnow);
		}
		chatRepository.save(chat);
		return "SUCCESS";
	}


}
