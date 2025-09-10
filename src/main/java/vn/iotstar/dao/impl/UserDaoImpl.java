package vn.iotstar.dao.impl;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JPAConfig;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.entities.UserEntity;

public class UserDaoImpl implements IUserDao{

	@Override
	public List<UserEntity> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		
		List<UserEntity> lst = null;
		
		try {
			TypedQuery<UserEntity> query = enma.createNamedQuery("UserEntity.findAll", UserEntity.class);
			
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
	public UserEntity findById(int id) {
		EntityManager enma = JPAConfig.getEntityManager();
		
		EntityTransaction trans = enma.getTransaction();
		
		UserEntity user = null;
		try {
			trans.begin();
			user = enma.find(UserEntity.class, id);
			trans.commit();
		}catch (NoResultException ex) {
			user = null;
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}finally {
			enma.close();
		}
		
		return user;
	}

	@Override
	public UserEntity findByEmail(String email) {
		EntityManager enma = JPAConfig.getEntityManager();
		
		UserEntity user = null;
		
		try {
			String jql = "SELECT u FROM UserEntity u WHERE u.email = :email";
			TypedQuery<UserEntity> query = enma.createQuery(jql, UserEntity.class);
			query.setParameter("email", email);
			user = query.getSingleResult();
		}catch (NoResultException ex) {
			user = null;
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}finally {
			enma.close();
		}
		
		return user;
	}

	@Override
	public void insert(UserEntity user) {
		EntityManager enma = JPAConfig.getEntityManager();
		
		EntityTransaction trans = enma.getTransaction();
		
		try {
			trans.begin();
			enma.persist(user);
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
	public void update(UserEntity user) {
		EntityManager enma = JPAConfig.getEntityManager();
		
		EntityTransaction trans = enma.getTransaction();
		
		try {
			trans.begin();
			enma.merge(user);
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
	public UserEntity findByUserName(String username) {
		EntityManager enma = JPAConfig.getEntityManager();
		
		UserEntity user = null;
		
		try {
			String jql = "SELECT u FROM UserEntity u WHERE u.username = :username";
			TypedQuery<UserEntity> query = enma.createQuery(jql, UserEntity.class);
			query.setParameter("username", username);
			user = query.getSingleResult();
		}catch (NoResultException ex) {
			user = null;
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}finally {
			enma.close();
		}
		
		return user;
	}

	@Override
	public boolean checkExistEmail(String email) {
	    EntityManager enma = JPAConfig.getEntityManager();

	    try {
	        String jql = "SELECT u FROM UserEntity u WHERE u.email = :email";
	        TypedQuery<UserEntity> query = enma.createQuery(jql, UserEntity.class);
	        query.setParameter("email", email);
	        
	        return !query.getResultList().isEmpty();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        return false;
	    } finally {
	        enma.close();
	    }
	}


	@Override
	public boolean checkExistUsername(String username) {
	    EntityManager enma = JPAConfig.getEntityManager();

	    try {
	        String jql = "SELECT u FROM UserEntity u WHERE u.username = :username";
	        TypedQuery<UserEntity> query = enma.createQuery(jql, UserEntity.class);
	        query.setParameter("username", username);
	        
	        return !query.getResultList().isEmpty();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        return false;
	    } finally {
	        enma.close();
	    }
	}

	@Override
	public boolean checkExistPhone(String phone) {
	    EntityManager enma = JPAConfig.getEntityManager();

	    try {
	        String jql = "SELECT u FROM UserEntity u WHERE u.phone = :phone";
	        TypedQuery<UserEntity> query = enma.createQuery(jql, UserEntity.class);
	        query.setParameter("phone", phone);
	        
	        return !query.getResultList().isEmpty();
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        return false;
	    } finally {
	        enma.close();
	    }
	}

}
