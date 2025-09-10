package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.entities.CategoryEntity;


public interface ICategoryDao {

	void insert(CategoryEntity category);
	void update(CategoryEntity category);
	void delete(int id);
	CategoryEntity findById(int id);
	CategoryEntity findByName(String name);
	List<CategoryEntity> findAll();
	List<CategoryEntity> findByUserId(int userid);
	List<CategoryEntity> search(String keyword);
}
