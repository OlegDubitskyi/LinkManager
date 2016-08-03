package com.bionic.edu.proc;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

@Named
public class ArticleServiceImpl implements ArticleService{
	@Inject
    private ArticleDao articleDao;
	
	public Article findById(int id) {
		return articleDao.findById(id);
	}
	@Transactional
	public void remove(int id) {
		articleDao.remove(id);
	}

	@Transactional
	public void save(Article article) {
		articleDao.save(article);
	}

	@Transactional
	public void update(Article article) {
		articleDao.update(article);
	}

	@Override
	public List<Article> getLinks(int categoryId) {
		return articleDao.getLinks(categoryId);
	}
	@Override
	public long getLinksNumber(int categoryId) {
		return articleDao.getLinksNumber(categoryId);
	}

}
