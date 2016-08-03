package com.bionic.edu.proc;

import java.util.List;

public interface ArticleDao {
	public Article findById(int id);
	public void save(Article article);
	public void remove(int id);
	public void update(Article article);
	public List<Article> getLinks(int categoryId);
	public long getLinksNumber(int categoryId);

}
