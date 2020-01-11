/**
 * 
 */
package model.model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author ok
 *
 */
public class user {

	private int userId;
	private String userName;
	private String userDealName;
	private String userNumber;
	private String userEmail;
	private String userAddress;
	private String password;
	private String ownerNum;
	private Date date;
	
	/**
	 * @return the ownerNum
	 */
	public String getOwnerNum() {
		return ownerNum;
	}
	/**
	 * @param ownerNum the ownerNum to set
	 */
	public void setOwnerNum(String ownerNum) {
		this.ownerNum = ownerNum;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @return the userDealName
	 */
	public String getUserDealName() {
		return userDealName;
	}
	/**
	 * @return the userNumber
	 */
	public String getUserNumber() {
		return userNumber;
	}
	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 * @return the userAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}
	
	public user(int id, String num, String email, String address, String deal, String owner, String pass, String OwnNum, Date date)
	{
		this.userId = id;
		this.userNumber = num;
		this.userEmail = email;
		this.userAddress = address;
		this.userDealName = owner;
		this.userName = deal;
		this.password = pass;
		this.ownerNum = OwnNum;
		this.date = date;
	}
	public boolean validDate()
	{
		String dateString  = new SimpleDateFormat("yyyy-MM-dd").format(date);
		LocalDate from = LocalDate.parse(dateString);
		if(ChronoUnit.DAYS.between(from, LocalDateTime.now())<=21) {
			return true;
		}
		else
		return false;
	}
}
