package com.ds.contactapp.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ds.contactapp.domain.User;


public class UserRowMapper implements RowMapper<User> {
/**
 * UserRowMapper will map record from resultset to user object
 */
	@Override
	public User mapRow(ResultSet rs, int i) throws SQLException {
		User user=new User();
		user.setUserid(rs.getInt("userid"));//binding to user after getting result from resultset
		user.setName(rs.getString("name"));
		user.setAddress(rs.getString("address"));
		user.setEmail(rs.getString("email"));
		user.setLoginname(rs.getString("loginName"));
		user.setRole(rs.getInt("role"));
		user.setLoginstatus(rs.getInt("loginStatus"));
		user.setPhone(rs.getString("phone"));
		return user;
	}

}
