package com.sametsafkan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sametsafkan.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		model.addAttribute("customerList", customerService.getCustomers());
		return "list-customers";
	}
}
