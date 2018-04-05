package com.ds.contactapp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ds.contactapp.domain.Contact;
import com.ds.contactapp.rm.ContactRowMapper;
@Repository
public class ContactDaoImpl extends BaseDao implements ContactDao {

	@Override
	public void save(Contact c) {
		String sql="insert into contact (userid,name,email,phone,address,remark) values(:userid,:name,:email,:phone,:address,:remark)";
		Map m=new HashMap();
		m.put("userid", c.getUserid());
		m.put("name", c.getName());
		m.put("email", c.getEmail());
		m.put("phone", c.getPhone());
		m.put("address", c.getAddress());
		m.put("remark", c.getRemark());
		
		KeyHolder kh=new GeneratedKeyHolder();
		SqlParameterSource ps=new MapSqlParameterSource(m);
		getNamedParameterJdbcTemplate().update(sql, ps, kh);
		Integer contactid=kh.getKey().intValue();
		c.setContactId(contactid);
	}

	@Override
	public void update(Contact c) {
	String sql="update contact set name=:name,email=:email,phone=:phone,address=:address,remark=:remark where contactId=:contactId";
	Map m=new HashMap();
	m.put("contactId", c.getContactId());
	m.put("name", c.getName());
	m.put("email", c.getEmail());
	m.put("phone", c.getPhone());
	m.put("address", c.getAddress());
	m.put("remark", c.getRemark());

	getNamedParameterJdbcTemplate().update(sql, m);
	}

	@Override
	public void delete(Contact c) {
	this.delete(c.getContactId());

	}

	@Override
	public void delete(Integer contactId) {
		String sql="delete from contact where contactId=?";
		getJdbcTemplate().update(sql, contactId);

	}

	@Override
	public Contact findById(Integer contactId) {
		String sql="select contactId,userid,name,email,phone,address,remark from contact where contactId=?";
		return getJdbcTemplate().queryForObject(sql, new ContactRowMapper(),contactId);
	}

	@Override
	public List<Contact> findAll() {
		String sql="select contactId,userid,name,email,phone,address,remark from contact";
		List<Contact> contact= getJdbcTemplate().query(sql, new ContactRowMapper());
		return contact;
	}

	@Override
	public List<Contact> findByProperty(String propName, Object propValue) {
		String sql="select contactId,userid,name,email,phone,address,remark from contact where "+propName+"=?";
		return getJdbcTemplate().query(sql, new ContactRowMapper(),propValue);
	}

}
