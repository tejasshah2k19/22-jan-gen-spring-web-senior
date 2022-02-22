package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.CustomerBean;
import com.dao.CustomerDao;
import com.service.FileUploadService;

@Controller
public class CustomerController {
	@Autowired
	CustomerDao customerDao;

	@Autowired
	FileUploadService fileUploadService;

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

	@GetMapping("/deletecustomer")
	public String deleteCustomer(@RequestParam("customerId") int customerId) {
		customerDao.deleteCustomer(customerId);
		return "redirect:/getallcustomers";
	}

	@GetMapping("/editcustomer")
	public String editCustomer(@RequestParam("customerId") int customerId, Model model) {

		CustomerBean customer = customerDao.getCustomerById(customerId);
		model.addAttribute("customer", customer);

		return "EditCustomer";
	}

	@PostMapping("/updatecustomer")
	public String updateCustomer(CustomerBean customer) {
		customerDao.updateCustomer(customer);
		return "redirect:/getallcustomers";
	}

	@GetMapping("/uploadprofile")
	public String uploadProfile() {
		return "UploadProfile";
	}

	@PostMapping("/saveprofile")
	public String saveProfile(@RequestParam("profile") MultipartFile multiPartFile) {
		System.out.println(multiPartFile.getOriginalFilename());
		// save
		String path = "D:\\Tejas Shah\\Dropbox\\Tejas Shah's Workplace\\work\\22-jan-gen-spring-web-senior\\src\\main\\webapp\\images\\";

		fileUploadService.uploadFile(multiPartFile, path);

		return "";
	}

}
