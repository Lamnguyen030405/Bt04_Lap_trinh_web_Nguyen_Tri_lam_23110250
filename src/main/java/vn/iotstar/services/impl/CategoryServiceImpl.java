package vn.iotstar.services.impl;

import java.util.List;

import vn.iotstar.dao.ICategoryDao;
import vn.iotstar.dao.impl.CategoryDaoImpl;
import vn.iotstar.entities.CategoryEntity;
import vn.iotstar.services.ICategoryService;

public class CategoryServiceImpl implements ICategoryService {

	ICategoryDao categoryDao = new CategoryDaoImpl();
	
	@Override
	public void insert(CategoryEntity category) {
		categoryDao.insert(category);
	}

	@Override
	public void update(CategoryEntity category) {
		categoryDao.update(category);	
	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);
	}

	@Override
	public CategoryEntity findById(int id) {
		return categoryDao.findById(id);
	}

	@Override
	public CategoryEntity findByName(String name) {
		return categoryDao.findByName(name);
	}

	@Override
	public List<CategoryEntity> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public List<CategoryEntity> search(String keyword) {
		return categoryDao.search(keyword);
	}

	@Override
	public List<CategoryEntity> findByUserId(int userid) {
		return categoryDao.findByUserId(userid);
	}
}
