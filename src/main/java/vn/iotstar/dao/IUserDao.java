package vn.iotstar.dao;

import java.util.List;

import vn.iotstar.entities.UserEntity;


public interface IUserDao {
List<UserEntity> findAll();
	
	UserEntity findById(int id);
	
	UserEntity findByEmail(String email);
	
	void insert(UserEntity user);
	
	void update(UserEntity user);
	
	UserEntity findByUserName(String username);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
	
	boolean checkExistPhone(String phone);
}
