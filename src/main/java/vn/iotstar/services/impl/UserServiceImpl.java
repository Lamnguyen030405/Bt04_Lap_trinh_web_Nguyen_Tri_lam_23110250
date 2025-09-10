package vn.iotstar.services.impl;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.dao.impl.UserDaoImpl;
import vn.iotstar.entities.UserEntity;
import vn.iotstar.services.IUserService;

public class UserServiceImpl implements IUserService{

	//lấy toàn bộ hàm trong tầng Dao của user
	IUserDao userDao = new UserDaoImpl();
	
	@Override
	public UserEntity login(String username, String password) {
		UserEntity user = this.findByUserName(username);
		
		if(user != null && password.equals(user.getPassword())) {
			user.setStatus(1);
			return user;
		}
		return null;
	}

	@Override
	public UserEntity findByUserName(String username) {
		return userDao.findByUserName(username);
	}

	@Override
	public boolean register(String email, String password, String repeatPassword,String username, String fullname, String phone) {
		if (!this.isPasswordMatch(password, repeatPassword)) {
			return false;
		}
		if (this.checkExistUsername(username)) {
			return false;
		}
		long millis=System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		UserEntity user = new UserEntity(); 
		user.setUsername(username); 
		user.setPassword(password);
		user.setEmail(email);
		user.setFullname(fullname);
		user.setPhone(phone);
		user.setCreatedate(date);
		user.setRoleid(5);
		userDao.insert(user);
		return true;
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public boolean isPasswordMatch(String password, String repeatPassword) {
		return password != null && password.equals(repeatPassword);
	}

	@Override
	public UserEntity findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public void update(UserEntity user) {
		userDao.update(user);
	}

	
}
