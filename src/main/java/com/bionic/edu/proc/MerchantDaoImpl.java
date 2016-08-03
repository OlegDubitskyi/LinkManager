package com.bionic.edu.proc;

import java.util.List;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class MerchantDaoImpl implements MerchantDao {
	@PersistenceContext
	private EntityManager em;

	public Merchant findById(int id) {
		Merchant m = null;
		m = em.find(Merchant.class, id);
		return m;
	}

	public List<Merchant> findAll() {
		TypedQuery<Merchant> query = em.createQuery("SELECT m 	FROM Merchant m", Merchant.class);
		List<Merchant> listM = null;
		listM = query.getResultList();
		return listM;
	}

	public void save(Merchant merchant) {
		if (merchant.getId() == 0)
			em.persist(merchant);
		else
			em.merge(merchant);

	}

}
