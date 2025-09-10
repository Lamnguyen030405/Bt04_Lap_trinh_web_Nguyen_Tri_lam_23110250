package vn.iotstar.services;

import vn.iotstar.entities.UserEntity;

public interface IUserService {
	UserEntity login(String username, String password);
	
	UserEntity findByUserName(String username);
	
	void update(UserEntity user);
	
	boolean register(String email, String password, String repeatPassword, String username, String fullname, String phone);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
	
	boolean checkExistPhone(String phone);
	
	boolean isPasswordMatch(String password, String repeatPassword);
	
	UserEntity findByEmail(String email);
}
