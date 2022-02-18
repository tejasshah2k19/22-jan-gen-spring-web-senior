package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.CustomerBean;
import com.dao.CustomerDao;

@Controller
public class CustomerController {
	@Autowired
	CustomerDao customerDao;

	@GetMapping("/newcustomer")
	public String newCustomer() {
		return "NewCustomer";// NewCustomer
	}

	@PostMapping("/savecustomer")
	public String saveCustomer(CustomerBean customerBean) {

		customerDao.insertCustomer(customerBean);
		 
		return "redirect:/getallcustomers";
	}

	@GetMapping("/getallcustomers")
	public String getAllCustomers(Model model) {

		// db customers --> jsp --> display
		List<CustomerBean> customers = customerDao.getAllCustomers();
		model.addAttribute("customers", customers);
		return "ListCustomers";
	}

}
