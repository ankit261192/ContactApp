package com.ds.contactapp.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

//donot use @repository or @service or @component annotation as it will not exist independently in IOC container
abstract public class BaseDao extends NamedParameterJdbcDaoSupport {

	/**
	 * the NamedParameterJdbcDaoSupport is dependent on datasource class
	 * NamedParameterJdbcDaoSupport supports both jdbctemplate and namedparameterjdbctemplate
	 */
	@Autowired
	public void setDataSource2(DataSource ds) {
		super.setDataSource(ds);
		
	}
}
