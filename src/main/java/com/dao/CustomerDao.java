package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.CustomerBean;

@Repository
public class CustomerDao {

	@Autowired
	JdbcTemplate stmt;

	// update --> insert update delete
	// query --> select

	public void insertCustomer(CustomerBean customer) {

		stmt.update("insert into customer (firstname,email,password,balance) values (?,?,?,?)", customer.getFirstName(),
				customer.getEmail(), customer.getPassword(), customer.getBalance());
	}

	public List<CustomerBean> getAllCustomers() {

		List<CustomerBean> customers = stmt.query("select * from customer",
				new BeanPropertyRowMapper<CustomerBean>(CustomerBean.class));
		return customers;
	}
}
