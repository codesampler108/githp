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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;

@Entity
@Table(name="space")
@JsonIdentityInfo(generator=PropertyGenerator.class, property="spaceId") // this will stop cyclic json evaluation between user-chat-room
public class Space {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int spaceId;

	@Column
	private String title;
	@Column
	private String color;
	@Column
	private int createdBy;
	@Column
	private Timestamp createTime;
	
	@OneToMany(mappedBy = "space",  cascade = CascadeType.MERGE) // space is the property used in Chat class to refer to Space class. So this string is coming from what you write in chat class
	private List<Chat> chats;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "spaceappusers", joinColumns = @JoinColumn(name = "space_id"), inverseJoinColumns = @JoinColumn(name = "appuser_id"))
	private List<AppUser> appUsers;
	
	public Space() {
		
	}
	
	public Space(int spaceId, String title, String color, int createdBy, Timestamp createTime) {
		super();
		this.spaceId = spaceId;
		this.title = title;
		this.color = color;
		this.createdBy = createdBy;
		this.createTime = createTime;
	}
	
	public Space( String title, String color, int createdBy, Timestamp createTime) {
		super();
		this.title = title;
		this.color = color;
		this.createdBy = createdBy;
		this.createTime = createTime;
	}
	
	public List<AppUser> getAppUsers() {
		return appUsers;
	}

	public void setAppUsers(List<AppUser> appUsers) {
		this.appUsers = appUsers;
	}

	public List<Chat> getChats() {
		return chats;
	}
	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}
	
	public int getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
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

	@Override
	public String toString() {
		return "Space [spaceId=" + spaceId + ", title=" + title + ", color=" + color + ", createdBy=" + createdBy
				+ ", createTime=" + createTime + "]";
	}
	
	
	
}
