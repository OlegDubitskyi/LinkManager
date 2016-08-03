package com.bionic.edu.proc;


import java.time.LocalDate;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		ArticleService articleService = null;

		//articleService.remove(201);
		
		Article article = new Article();
		article.setLinkName("Link333");
		article.setUrl("url3/sdfsf/sdfser.java");
		article.setCategoryId(1);
		LocalDate dt = LocalDate.now();
		article.setDate(java.sql.Date.valueOf(dt));
		article.setPriority(1);
		article.setStatus(0);
		
		articleService.save(article);
		System.out.println(articleService.toString());
		
//		List<Article> list = articleService.getLinks(1);
//		for(Article l: list){
//			System.out.println("linkName = " + l.getLinkName() + "url = " +l.getUrl());
//
//		}
		
//		Article article = articleService.findById(101);
//		System.out.println("linkName: " + article.getLinkName());
		
		
//		Article article = articleService.findById(101);
//		
//		article.setLinkName("Link33");
//		articleService.update(article);
		
		//CategoriesService categoriesService = context.getBean(CategoriesService.class);
		//add new category
		//Categories categories = new Categories();
		//categories.setName("Java4");
		//categoriesService.save(categories);
		//System.out.println("name = " + categories.getName());
		
		//remove category
		//categoriesService.remove(101);
		//categoriesService.updateName(501, "New Category");
	    //System.out.println("Update finished");
	    
	    //Categories c = categoriesService.findById(501);
		//System.out.println("name = " + c.getName());

//		List<Categories> list = categoriesService.getAll();
//	     for(Categories cl: list)
//		System.out.println("id = " + cl.getId() + "; name = " + cl.getName());


	}

}
