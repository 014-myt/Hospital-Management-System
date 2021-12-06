package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Admin;
import com.example.demo.model.Availability;
import com.example.demo.model.Doctor;
import com.example.demo.serviceImp.AvailabilityService;
import com.example.demo.serviceImp.DoctorService;
@Controller
public class AvailabilityController {
	@Autowired
		AvailabilityService Docser;

		public AvailabilityController(AvailabilityService docser) {
			super();
			this.Docser = docser;
		}
		@GetMapping("/dateget")
		public String listUserss(Model model)
			{
				model.addAttribute("Admin",Docser.listAll());
				return "Av_List";
	      	}
		@GetMapping("c/date")
		public String createUser(Model model)
		{
			Admin obj3 =new Admin();
			model.addAttribute("obj3",obj3);
			return "createdate";
		}
		@PostMapping("/dates")
		public String saveUser(@ModelAttribute("obj3") Availability doctor)
		{
			Docser.save(doctor);
			return "redirect:/Av_list";
		}
		
		
		@GetMapping("/Mydoct/delete/{id}")
		public String DeleteStudent(@PathVariable	long id)
		{
	     	Docser.delete(id);
			return  "redirect:/Av_list";
		}
		
}
