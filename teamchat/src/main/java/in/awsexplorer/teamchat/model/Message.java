package in.awsexplorer.teamchat.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity
@Table(name="message")
@JsonIdentityInfo(generator=PropertyGenerator.class, property="messageId") // this will stop cyclic json evaluation between user-chat-room
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int messageId;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="chat_id") // id of the Chat not message
	private Chat chat; 
		
	@Column
	private String data;

	@Column
	private int createdBy;
	@Column
	private Timestamp createTime;
	
	public Message() {
		
	}
	
	public Message(int messageId, String data, int createdBy, Timestamp createTime) {
		super();
		this.messageId = messageId;
		this.data = data;
		this.createdBy = createdBy;
		this.createTime = createTime;
	}
	public Message( String data, int createdBy, Timestamp createTime) {
		super();
		this.data = data;
		this.createdBy = createdBy;
		this.createTime = createTime;
	}

	
	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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
	
	
	
	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", data=" + data + ", createdBy=" + createdBy + ", createTime="
				+ createTime + "]";
	}
		
}
