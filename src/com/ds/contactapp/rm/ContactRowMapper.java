package com.ds.contactapp.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ds.contactapp.domain.Contact;

public class ContactRowMapper implements RowMapper<Contact>{

	@Override
	public Contact mapRow(ResultSet rs, int i) throws SQLException {
		Contact c=new Contact();
		c.setUserid(rs.getInt("userid"));//binding to user after getting result from resultset
		c.setName(rs.getString("name"));
		c.setAddress(rs.getString("address"));
		c.setEmail(rs.getString("email"));
		c.setContactId(rs.getInt("contactId"));
		c.setPhone(rs.getString("phone"));
		c.setRemark(rs.getString("remark"));
		return c;
	}

}
