package com.sosorry.model;


public class Images {
	
	//private static final Logger logger = Logger.getLogger(Images.class);
	private String id;
	private String name;
	private String url;
	private String tip;
	private String description;
	private String createdDate;
	private String updatedDate;
	private String updateBy;
	private String updateChannel;
	
	@Override
	public String toString()
	{
		return "["+this.getId()+","+this.getName()+","+this.getUrl()+","+this.getTip()+","+this.getDescription()+","+this.getCreatedDate()+","+this.getUpdatedDate()
				+","+this.getUpdateBy()+","+this.getUpdateChannel()+"]";
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getUrl() {
		return url;
	}
	public String getTip() {
		return tip;
	}
	public String getDescription() {
		return description;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public String getUpdateChannel() {
		return updateChannel;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public void setUpdateChannel(String updateChannel) {
		this.updateChannel = updateChannel;
	}
	
	
	

}
