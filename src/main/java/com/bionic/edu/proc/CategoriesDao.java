package com.bionic.edu.proc;

import java.util.List;

public interface CategoriesDao {
	public Categories findById(int id);
	public void save(Categories categories);
	public void remove(int id);
	public void updateName(int id, String name);
	public List<Categories> getAll();

}
