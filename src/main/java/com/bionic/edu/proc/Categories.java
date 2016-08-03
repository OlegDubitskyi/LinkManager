package com.bionic.edu.proc;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message="Name can not be empty")
	private String name;

	private List<Article> articlesList;//collection of links related to category - not used jet
	@Transient
	private long numberOfLinks;
	
	
	public long getNumberOfLinks() {
		return numberOfLinks;
	}

	public void setNumberOfLinks(long numberOfLinks) {
		this.numberOfLinks = numberOfLinks;
	}

	public Categories() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Article> getArticles() {
		return articlesList;
	}

	public void setArticles(List<Article> articles) {
		this.articlesList = articles;
	}

}
