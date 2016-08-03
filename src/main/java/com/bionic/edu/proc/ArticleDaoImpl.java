package com.bionic.edu.proc;

import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class ArticleDaoImpl implements ArticleDao{
    @PersistenceContext
    private EntityManager em;

    public Article findById(int id){
    	Article a = null;
    	a = em.find(Article.class, id);
    	return a;
    }
    public void add(){
    	
    }
    
    public void remove(int id){
        Article article = em.find(Article.class, id);
        if (article != null){
        	em.remove(article);
        }
   }

    public List<Article> getLinks(int categoryId){
        String txt = "SELECT a FROM Article a WHERE a.categoryId=" + categoryId;   
        TypedQuery<Article> query = em.createQuery(txt, Article.class);
        return query.getResultList();
  }
	public void update(Article article) {
        	em.merge(article);
		
	}
	public void save(Article article) {
		if (article.getId() == 0)
			em.persist(article);
		else
			em.merge(article);
	}
	@Override
	public long getLinksNumber(int categoryId) {
		String txt = "SELECT COUNT(a) FROM Article a WHERE a.categoryId=" + categoryId;
		TypedQuery<Long> query = em.createQuery (txt, Long.class);
	    return query.getSingleResult();
	}
	


}
