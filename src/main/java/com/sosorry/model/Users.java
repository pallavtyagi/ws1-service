package com.sosorry.model;




public class Users {
	

	//private static final Logger logger = Logger.getLogger(Users.class);
	private String id;
	private String title;
	private String userid;
	private String firstName;
	private String lastName;
	private String phone;
	private String phoneVerify;
	private String email;
	private String emialVerify;
	private String countryCode;
	private String password;
	private String createDate;
	private String lastUpdateDate;
	private String deletedDate;
	private String isDeleted;
	
	@Override
	public String toString()
	{
		return "["+this.getId()+","+this.getTitle()+","+this.getUserid()+","+this.getFirstName()+","+this.getLastName()
				+","+this.getPhone()+","+this.getPhoneVerify()
				+","+this.getEmail()+","+this.getEmialVerify()+","+this.getCountryCode()+","+this.getCreateDate()
				+","+this.getLastUpdateDate()+","+this.getDeletedDate()+","+this.getIsDeleted()+"]";
	}
	
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getCreateDate() {
		return createDate;
	}
	public String getDeletedDate() {
		return deletedDate;
	}
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public void setDeletedDate(String deletedDate) {
		this.deletedDate = deletedDate;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getPhoneVerify() {
		return phoneVerify;
	}
	public String getEmail() {
		return email;
	}
	public String getEmialVerify() {
		return emialVerify;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public String getUserid() {
		return userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setPhoneVerify(String phoneVerify) {
		this.phoneVerify = phoneVerify;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setEmialVerify(String emialVerify) {
		this.emialVerify = emialVerify;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	
	
	
}
