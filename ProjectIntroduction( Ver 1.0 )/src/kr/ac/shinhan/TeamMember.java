package kr.ac.shinhan;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class TeamMember {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long key;
	
	@Persistent
	private String name;
	
	@Persistent
	private String hakbun;
	
	@Persistent
	private String phoneNumber;
	
	@Persistent
	private String email;
	
	@Persistent
	private String kakaoId;
	
	@Persistent
	private String teamLeader;
	
	@Persistent
	private String hubId;
	
	public TeamMember(String name, String hakbun, String phoneNumber, String email, String kakaoId, String teamLeader, String hubId)
	{
		this.name = name;
		this.hakbun = hakbun;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.kakaoId = kakaoId;
		this.teamLeader = teamLeader;
		this.hubId = hubId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHakbun() {
		return hakbun;
	}

	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKakaoId() {
		return kakaoId;
	}

	public void setKakaoId(String kakaoId) {
		this.kakaoId = kakaoId;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	public String getHubId() {
		return hubId;
	}

	public void setHubId(String hubId) {
		this.hubId = hubId;
	}

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}
	
	
}
