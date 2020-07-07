package in.awsexplorer.teamchat.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity
@Table(name="chat")
@JsonIdentityInfo(generator=PropertyGenerator.class, property="chatId") // this will stop cyclic json evaluation between user-chat-room
public class Chat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int chatId;
	
	@Column
	private String title;
	@Column
	private String color;
	@Column
	private int createdBy;
	@Column
	private Timestamp createTime;
	@Column
	private Timestamp updateTime;
	
	@OneToMany(mappedBy = "chat",  cascade = CascadeType.MERGE) // chat is the property used in Chat class to refer to Space class. So this string is coming from what you write in chat class
	private List<Message> messages;
	
//	@ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name="space_id")
	private Space space;

	public Chat() {
	
	}
	
	public Chat(int chatId, String title, String color, int createdBy, Timestamp createTime, Timestamp updateTime) {
		super();
		this.chatId = chatId;
		this.title = title;
		this.color = color;
		this.createdBy = createdBy;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	
	public Chat(String title, String color, int createdBy, Timestamp createTime, Timestamp updateTime) {
		super();
		this.title = title;
		this.color = color;
		this.createdBy = createdBy;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}
	
	
	
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Space getSpace() {
		return space;
	}

	public void setSpace(Space space) {
		this.space = space;
	}

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	@Override
	public String toString() {
		return "Chat [chatId=" + chatId + ", title=" + title + ", color=" + color + ", createdBy=" + createdBy
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

	
}
