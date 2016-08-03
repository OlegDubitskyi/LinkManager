package com.bionic.edu.proc;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Article {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String linkName;
	private String url;
	private int categoryId;
	private java.sql.Date date;
	private int priority;
	private int status;
	private String keywords;
	
	public Article (){}
	
	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	@ManyToMany
	@JoinTable(name="Catalog", joinColumns=@JoinColumn(name="articleId"),
	   inverseJoinColumns=@JoinColumn(name="categoryId"))
	private Collection<Categories> categories;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(java.sql.Date date) {
		this.date = date;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String toString() {
		return "Article [id=" + getId() + ", linkName=" + getLinkName() + ", url=" + getUrl() + ", categoryId=" + categoryId
				+ ", date=" + date + ", priority=" + priority + ", status=" + status + ", categories=" + categories
				+ "]";
	}	

}
