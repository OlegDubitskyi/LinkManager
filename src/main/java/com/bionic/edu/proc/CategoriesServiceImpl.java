package com.bionic.edu.proc;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

@Named
public class CategoriesServiceImpl implements CategoriesService {
	@Inject
	private CategoriesDao categoriesDao;

	public Categories findById(int id) {
		return categoriesDao.findById(id);
	}

	@Transactional
	public void save(Categories categories) {
		categoriesDao.save(categories);
	}

	@Transactional
	public void remove(int id) {
		categoriesDao.remove(id);
	}

	@Transactional
	public void updateName(int id, String name) {
		categoriesDao.updateName(id, name);

	}

	public List<Categories> getAll() {
		return categoriesDao.getAll();
	}

}
