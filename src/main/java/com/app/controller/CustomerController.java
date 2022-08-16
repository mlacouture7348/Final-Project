package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.customerServices.CustomerService;
import com.app.model.Customer;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//overload constructor
	public CustomerController(CustomerService theCustomerService) {
		customerService = theCustomerService;
	}
	
	//mapping for search
	@GetMapping("/search")
	public String searchCustomers(Model model) {
		//get customers from db
		List<Customer> theCustomers = customerService.findAll();
		//add them to spring model
		model.addAttribute("customer", theCustomers);
		return "/customer-search";
	}
	
	//mapping to add
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		//create new Customer object name theCustomer
		Customer theCustomers = new Customer();
		//saves data as an attribute that will be added to theCustomer
		model.addAttribute("customer", theCustomers);
		return "/customer-form";
	}
	
	//mapping for update
	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model model) {
		Customer theCustomers = customerService.findById(theId);
		model.addAttribute("customer", theCustomers);
		return "/customer-form";
	}
	
	//mapping for save
	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.save(theCustomer);
		return "redirect:/customers/search";
	}
	
	//mapping for delete
	@PostMapping("/delete")
	public String delete(@RequestParam("customerId") int theId) {
		customerService.deleteById(theId);
		return "redirect:/customers/search";
	}

}
