package kr.ac.shinhan;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class UserLoginToken {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long key;  //프라이머리
	
	@Persistent
	private String token;
	
	@Persistent
	private String userAccount;  //아이디
	
	@Persistent
	private String expireDate;

	public UserLoginToken(String token, String userAccount,
			String expireDate) {
		this.token = token;
		this.userAccount = userAccount;
		this.expireDate = expireDate;
	}

	public Long getKey() {
		return key;
	}

	/*public void setKey(Long key) {
		this.key = key;
	}*/
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserAccount() {
		return userAccount;
	}

	/*public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}*/

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

}
