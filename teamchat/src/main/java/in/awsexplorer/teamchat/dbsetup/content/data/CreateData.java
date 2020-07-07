package in.awsexplorer.teamchat.dbsetup.content.data;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.awsexplorer.teamchat.dbsetup.content.AppDBConnection;
import in.awsexplorer.teamchat.model.AppUser;
import in.awsexplorer.teamchat.model.Chat;
import in.awsexplorer.teamchat.model.Message;
import in.awsexplorer.teamchat.model.Space;
import in.awsexplorer.teamchat.repo.AppUserRepository;
import in.awsexplorer.teamchat.repo.ChatRepository;
import in.awsexplorer.teamchat.repo.MessageRepository;
import in.awsexplorer.teamchat.repo.SpaceRepository;

@Component
public class CreateData {

	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private ChatRepository chatRepository;
	@Autowired
	private SpaceRepository  spaceRepository;
	@Autowired
	private AppUserRepository  appUserRepository;
	
	public CreateData() {
	}

	public void addData() {
		Timestamp tnow=new Timestamp(new Date().getTime());
		
		// Space
		Space space = new Space("New Space", "ffffff", 1, tnow);
		Space spaceReturn = spaceRepository.save(space);
		System.out.println("added space:"+spaceReturn.toString());
		List<Space> spaces = spaceRepository.findAll();
		spaces.forEach(x->System.out.println(x.toString()));
		Space space1=spaces.get(0);
		
		// Chat
		Chat chat = new Chat("New chat", "ffffff", 1, tnow, tnow);
		chat.setSpace(space1);
		Chat chatRet = chatRepository.save(chat);
		System.out.println("added chat:"+chatRet.toString());
		List<Chat> chats = chatRepository.findAll();
		chats.forEach(x->System.out.println(x.toString()));
		Chat chat1=chats.get(0);

		// Message
		Message message=new Message(1, "msg 1 from dao", 1, tnow);
		message.setChat(chat1);
		Message messageRet = messageRepository.save(message);
		System.out.println("added message:"+messageRet.toString());
		List<Message> messages = messageRepository.findAll();
		messages.forEach(x->System.out.println(x.toString()));
		
		//App Users
		AppUser appUser=new AppUser("harry", "tom","dick", "ffffff", tnow);
		appUser.setChats(chats);
		appUser.setSpaces(spaces);
		AppUser appUserRet = appUserRepository.save(appUser);
		System.out.println("added appUser:"+appUserRet.toString());
		List<AppUser> appUsers = appUserRepository.findAll();
		appUsers.forEach(x->System.out.println(x.toString()));
		
	}

	
	
}
