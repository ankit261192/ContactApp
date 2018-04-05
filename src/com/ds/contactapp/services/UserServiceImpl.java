package com.ds.contactapp.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ds.contactapp.dao.BaseDao;
import com.ds.contactapp.dao.UserDao;
import com.ds.contactapp.domain.User;
import com.ds.contactapp.exception.UserBlockedException;
import com.ds.contactapp.rm.UserRowMapper;

@Service
public class UserServiceImpl extends BaseDao implements UserService {
	@Autowired
	private UserDao userdao;
	@Override
	public void register(User u) {
		userdao.save(u);
	}

	@Override
	public User Login(String loginName, String password) throws UserBlockedException {
		String sql="select userid,name,phone,email,address,role,loginstatus,loginName from user where loginName=:ln AND password=:pw";
					
		Map m=new HashMap();
		m.put("ln", loginName);
		m.put("pw", password);
		try {
		User u=getNamedParameterJdbcTemplate().queryForObject(sql, m, new UserRowMapper());
		if(u.getLoginstatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
			throw new UserBlockedException("Your account has been blocked.Please contact admin");
		}
		else {
		return u;
		}
		}
		catch (EmptyResultDataAccessException erda) {
			return null;
		}
		
		
	}

	@Override
	public List<User> getUserList() {
		
		List<User> list=userdao.findByProperty("role", UserService.USER_ROLE);
		return list;
	}

	@Override
	public void changeLoginStatus(Integer userid, Integer loginStatus) {
		String sql="update user set loginStatus=:lst where userid=:uid";
		Map m=new HashMap();
		m.put("lst", loginStatus);
		m.put("uid", userid);
		getNamedParameterJdbcTemplate().update(sql, m);
	}

	@Override
	public boolean isUsernameExist(String username) {
		String sql="select count (loginName) from user where loginName=?";
		Integer count=getJdbcTemplate().queryForObject(sql,new String[] {username} ,Integer.class);
		if(count==1) {
			return true;
		}else {
			return false;
		}
	}

}
