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

	public void deleteCustomer(int customerId) {
		stmt.update("delete from customer where customerid = ?", customerId);
	}

	public CustomerBean getCustomerById(int customerId) {
		CustomerBean customerBean = stmt.queryForObject("select * from customer where customerid = ? ",
				new BeanPropertyRowMapper<CustomerBean>(CustomerBean.class), new Object[] { customerId });
		return customerBean;
	}

	public boolean updateCustomer(CustomerBean customer) {

		try {
			stmt.update(
					"update customer set firstname = ? , email = ? , password = ? , balance = ? where customerid = ?",
					customer.getFirstName(), customer.getEmail(), customer.getPassword(), customer.getBalance(),
					customer.getCustomerId());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public CustomerBean authenticate(String email, String password) {
		CustomerBean dbCust = null;

		try {

			dbCust = stmt.queryForObject("select * from customer where email = ? and password = ?",
					new BeanPropertyRowMapper<CustomerBean>(CustomerBean.class), new Object[] { email, password });

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

		return dbCust;
	}

}
