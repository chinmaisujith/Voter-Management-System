package com.vms.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.vms.entity.Vms;
import com.vms.entity.VmsList;
import com.vms.service.VmsListService;
import com.vms.service.VmsService;

@Controller
public class VmsController {
	
	@Autowired
	private VmsService service;
	
	@Autowired
	private VmsListService vmsListService;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/voter_register")
	public String voterRegister() {
		return "voterRegister";
	}
	
	@GetMapping("/voter_details")
	public ModelAndView  getAllVoter() {
		List<Vms>list=service.getAllVoter();
//		ModelAndView m=new ModelAndView();
// 	    m.setViewName("voterList");
//		m.addObject("vms",list);
		return new ModelAndView("voterDetails","vms",list);
		
	}
	
	@PostMapping("/save")
	public String addVoter(@ModelAttribute Vms v) {
		service.save(v);
		return "redirect:/voter_details";
	}
	
	@GetMapping("/voter_list")
	public String getVoterlist(Model model) {
		
		List<Vms>list=vmsListService.getAllVms();
		model.addAttribute("vms",list);
		return "voterList";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Vms v=service.getVmsById(id);
		VmsList vv=new VmsList(v.getId(),v.getFirstname(),v.getLastname(),v.getAge());
		vmsListService.saveVmslist(vv);
		return "redirect:/voter_list";
	}
	
	@RequestMapping("/editvoter/{id}")
	public String editVoter(@PathVariable("id") int id,Model model) {
		Vms v=service.getVmsById(id);
		model.addAttribute("vms",v);
		return "voterEdit";
	}
	
	@RequestMapping("/deleteVoter/{id}")
	public String deleteVoter(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/voter_details";
	}

}
