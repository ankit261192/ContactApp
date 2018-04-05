package com.ds.contactapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.contactapp.dao.BaseDao;
import com.ds.contactapp.dao.ContactDao;
import com.ds.contactapp.domain.Contact;
import com.ds.contactapp.rm.ContactRowMapper;
import com.ds.contactapp.util.StringUtility;

@Service
public class ContactServiceImpl extends BaseDao implements ContactService {
	@Autowired(required=true)
	private ContactDao contactdao;
	@Override
	public void save(Contact c) {
		contactdao.save(c);

	}

	@Override
	public void update(Contact c) {
		contactdao.update(c);

	}

	@Override
	public void delete(Integer contactId) {
		contactdao.delete(contactId);

	}

	@Override
	public void delete(Integer[] contactId) {
		/**
		 * we are converting contactId array to comma seperated valyes and
		 * pass it to query using util class StringUtility
		 */
		String ids=StringUtility.toCommaSeperatedString(contactId);
		String sql="delete from contact where contactId IN("+ids+")";
		getJdbcTemplate().update(sql);
	}

	@Override
	public List<Contact> findUserContact(Integer userid) {
		return contactdao.findByProperty("userid", userid);
		 
	}

	public Contact findById(Integer contactId){
		
		return contactdao.findById(contactId);
	}
	@Override
	public List<Contact> findUserContact(Integer userid, String txt) {
		String sql="select contactId,userid,name,email,phone,address,remark from contact where userid=? AND (name LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%')";
		return getJdbcTemplate().query(sql, new ContactRowMapper(),userid);
	}

}
