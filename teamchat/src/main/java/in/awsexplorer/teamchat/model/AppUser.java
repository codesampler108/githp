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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity
@Table(name="app_user")
@JsonIdentityInfo(generator=PropertyGenerator.class, property="appUserId") // this will stop cyclic json evaluation between user-chat-room
public class AppUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appUserId;
	
	@Column
	private String nickName;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String color;
	
	@Column
	private Timestamp updateTime;
	
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(name = "spaceappusers", joinColumns = @JoinColumn(name = "appuser_id"), inverseJoinColumns = @JoinColumn(name = "space_id"))
	private List<Space> spaces;
	
	@ManyToMany(cascade=CascadeType.MERGE)
	@JoinTable(name = "chatappusers", joinColumns = @JoinColumn(name = "appuser_id"), inverseJoinColumns = @JoinColumn(name = "chat_id"))
	private List<Chat> chats;
	
	public AppUser() {
		
	}

	public AppUser(int appUserId, String nickName, String firstName, String lastName, String color, Timestamp updateTime) {
		super();
		this.appUserId = appUserId;
		this.nickName = nickName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.color = color;
		this.updateTime = updateTime;
	}

	public AppUser(String nickName, String firstName, String lastName, String color, Timestamp updateTime) {
		super();
		this.nickName = nickName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.color = color;
		this.updateTime = updateTime;
	}
	

	

	public int getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(int appUserId) {
		this.appUserId = appUserId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
	

	public List<Space> getSpaces() {
		return spaces;
	}

	public void setSpaces(List<Space> spaces) {
		this.spaces = spaces;
	}

	public List<Chat> getChats() {
		return chats;
	}

	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}

	@Override
	public String toString() {
		return "AppUser [appUserId=" + appUserId + ", nickName=" + nickName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", color=" + color + ", updateTime=" + updateTime + "]";
	}
	

	
}
