package com.bionic.edu.web;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bionic.edu.proc.Article;
import com.bionic.edu.proc.ArticleService;
import com.bionic.edu.proc.Categories;
import com.bionic.edu.proc.CategoriesService;
import com.bionic.edu.proc.Merchant;

@Controller
@RequestMapping("/main")
public class MainPageController {
	@Inject
	CategoriesService service;
	@Inject
	ArticleService articleService;

	//List<Categories> list = null;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String showList(ModelMap model) {
		List<Categories> list = service.getAll();
		model.addAttribute("categoriesList", list);
		return "mainPage";
	}

	@RequestMapping(value = "/newCategory", method = RequestMethod.GET)
	public String newCategory(ModelMap model) {
		model.addAttribute("category", new Categories());
		return "addCategory";
	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String addCategory(@Valid @ModelAttribute("category") Categories category, BindingResult bindingResult,
			ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "addCategory";
		}
		service.save(category);
		List<Categories> list = service.getAll();

		model.addAttribute("categoriesList", list);
		return "mainPage";
	}

	@RequestMapping(value = "/edit&{categoryId}", method = RequestMethod.GET)
	public String editCategory(@PathVariable String categoryId, ModelMap model) {
		int id = Integer.valueOf(categoryId);
		Categories category = service.findById(id);
		model.addAttribute("category", category);
		return "addCategory";
	}
	@RequestMapping(value = "/delete&{categoryId}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable String categoryId, ModelMap model) {
		int id = Integer.valueOf(categoryId);
		service.remove(id);
		List<Categories> list = service.getAll();
		model.addAttribute("categoriesList", list);
		return "mainPage";
	}
	@RequestMapping(value = "/newLink&{categoryId}", method = RequestMethod.GET)
	public String NewLink(@PathVariable String categoryId, ModelMap model) {
		int id = Integer.valueOf(categoryId);

		//initialize categoryId to save our link
		Article article = new Article();
		article.setCategoryId(id);
		
		model.addAttribute("article", article);
		return "newLink";
	}
	@RequestMapping(value = "/addLink", method = RequestMethod.POST)
	public String addLink(@Valid @ModelAttribute("article") Article article, String categoryId, BindingResult bindingResult,
			ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "newLink";
		}
		
		LocalDate dt = LocalDate.now();
		article.setDate(java.sql.Date.valueOf(dt));
		article.setPriority(1);
		article.setStatus(0);
		//article.setId(56);
		
		System.out.println("id: " + article.getId());
		System.out.println("categoryid: " + article.getCategoryId());
		System.out.println("linkName: " + article.getLinkName());
		System.out.println("date: " + article.getDate());
		System.out.println("priority: " + article.getPriority());
		System.out.println("status: " + article.getStatus());
		
		articleService.save(article);

		int id = Integer.valueOf(categoryId);
		if(id != 0){
			List<Article> list = articleService.getLinks(id);
			model.addAttribute("articlesList", list);
			model.addAttribute("categoryId", categoryId);
			return "showCategoryLinks";
		}
		List<Categories> list = service.getAll();
		model.addAttribute("categoriesList", list);
		return "mainPage";
	}
	@RequestMapping(value = "/showLinks&{categoryId}", method = RequestMethod.GET)
	public String ShowCategoryLinks(@PathVariable String categoryId, ModelMap model) {
		int id = Integer.valueOf(categoryId);

		//initialize categoryId to save our link
		Article article = new Article();
		article.setCategoryId(id);
		
		//model.addAttribute("article", article);
		List<Article> list = articleService.getLinks(id);
		model.addAttribute("articlesList", list);
		return "showCategoryLinks";
	}
	@RequestMapping(value = "/deleteLink&{articleId}&{categoryId}", method = RequestMethod.GET)
	public String DeleteLink(@PathVariable String articleId, @PathVariable String categoryId, ModelMap model) {
		int articleIntId = Integer.valueOf(articleId);
		int categoryIntId = Integer.valueOf(categoryId);
		
		//initialize categoryId to save our link
		articleService.remove(articleIntId);
		
		
		//model.addAttribute("article", article);
		List<Article> list = articleService.getLinks(categoryIntId);
		model.addAttribute("articlesList", list);
		return "showCategoryLinks";
	}
	@RequestMapping(value = "/editLink&{articleId}&{categoryId}", method = RequestMethod.GET)
	public String EditLink(@PathVariable String articleId, @PathVariable String categoryId, ModelMap model) {
		int articleIntId = Integer.valueOf(articleId);
		int categoryIntId = Integer.valueOf(categoryId);
		
		Article article = articleService.findById(articleIntId);
		model.addAttribute("article", article);
		//model.addAttribute("catego", article);
		return "newLink";
	}
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

}
