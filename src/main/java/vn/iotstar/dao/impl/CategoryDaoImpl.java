package vn.iotstar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JPAConfig;
import vn.iotstar.dao.ICategoryDao;
import vn.iotstar.entities.CategoryEntity;

public class CategoryDaoImpl implements ICategoryDao{

	@Override
	public void insert(CategoryEntity category) {
		EntityManager enma = JPAConfig.getEntityManager();
		
		EntityTransaction trans = enma.getTransaction();
	
		try {
			trans.begin();
			enma.persist(category);
			trans.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			trans.rollback();
			throw ex;
		}finally {
			enma.close();
		}
	}

	@Override
	public void update(CategoryEntity category) {
		EntityManager enma = JPAConfig.getEntityManager();
		
		EntityTransaction trans = enma.getTransaction();
		
		try {
			trans.begin();
			enma.merge(category);
			trans.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			trans.rollback();
			throw ex;
		}finally {
			enma.close();
		}
	}

	@Override
	public void delete(int id) {
		EntityManager enma = JPAConfig.getEntityManager();
		
		EntityTransaction trans = enma.getTransaction();
		
		try {
			trans.begin();
			CategoryEntity category = enma.find(CategoryEntity.class, id);
			if(category != null) {
				enma.remove(category);
			}
			trans.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			trans.rollback();
			throw ex;
		}finally {
			enma.close();
		}
		
	}

	@Override
	public CategoryEntity findById(int id) {
		EntityManager enma = JPAConfig.getEntityManager();
		
		EntityTransaction trans = enma.getTransaction();
		
		CategoryEntity category = null;
		
		try {
			trans.begin();	
			category = enma.find(CategoryEntity.class, id);
			trans.commit();
		}catch(Exception ex) {
			ex.printStackTrace();
			trans.rollback();
			throw ex;
		}finally {
			enma.close();
		}
		
		return category;
	}

	@Override
	public CategoryEntity findByName(String name) {
		EntityManager enma = JPAConfig.getEntityManager();

		CategoryEntity category = null;
		
		try {
			String jql = "SELECT c FROM CategoryEntity c WHERE c.catename = :name";
			TypedQuery<CategoryEntity> query = enma.createQuery(jql, CategoryEntity.class);
			query.setParameter("name", name);
			category = query.getSingleResult();
			
		}catch (NoResultException ex) {
	        category = null;
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}finally {
			enma.close();
		}
		
		return category;
	}

	@Override
	public List<CategoryEntity> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		
		List<CategoryEntity> lst = null;
		
		try {
			TypedQuery<CategoryEntity> query = enma.createNamedQuery("CategoryEntity.findAll", CategoryEntity.class);
			lst = query.getResultList();
		}catch (NoResultException ex) {
			lst = null;
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}finally {
			enma.close();
		}
		
		return lst;
	}

	@Override
	public List<CategoryEntity> findByUserId(int userid) {
		EntityManager enma = JPAConfig.getEntityManager();
		
		List<CategoryEntity> lst = null;
		
		try {
			String jql = "SELECT c FROM CategoryEntity c WHERE c.userid = :uid";
			TypedQuery<CategoryEntity> query = enma.createQuery(jql, CategoryEntity.class);
			query.setParameter("uid", userid);
			lst = query.getResultList();
		}catch (NoResultException ex) {
			lst = null;
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}finally {
			enma.close();
		}
		
		return lst;
	}
	
	@Override
	public List<CategoryEntity> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}


}
