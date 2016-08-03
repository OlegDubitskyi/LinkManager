package com.bionic.edu.proc;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class CategoriesDaoImpl implements CategoriesDao {
	@PersistenceContext
	private EntityManager em;
	@Inject
	ArticleService articleService;

	public Categories findById(int id) {
		Categories c = null;
		c = em.find(Categories.class, id);
		return c;
	}

	public void save(Categories categories) {

		if (categories.getId() == 0)
			em.persist(categories);
		else
			em.merge(categories);

	}

	public void remove(int id) {
		Categories categories = em.find(Categories.class, id);
		List<Article> list = articleService.getLinks(id);
		if (categories != null) {
			em.remove(categories);
			
			//remove links for specified category
			for(Article a: list){
				articleService.remove(a.getId());
			}
			
			
		}
	}

	public void updateName(int id, String name) {
		Categories categories = em.find(Categories.class, id);
		if (categories != null) {
			categories.setName(name);
		}
	}

	public List<Categories> getAll() {
		TypedQuery<Categories> query = em.createQuery("SELECT c FROM Categories c", Categories.class);
		List<Categories> listC = null;
		listC = query.getResultList();

		// get all links related to current category
		for (Categories c : listC) {
			//articleService = null;
			//List<Article> links = articleService.getLinks(c.getId());
			long number = articleService.getLinksNumber(c.getId());
			c.setNumberOfLinks(number);
		}
		return listC;
	}

}
