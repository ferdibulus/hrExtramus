package com.hr.hrproject.Controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hr.hrproject.Service.MainService;

@RestController
@CrossOrigin("*")
public class MainController {
	@Autowired
	MainService mainService;
	
	@RequestMapping("/")
	public ModelAndView index () {
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("home");
	    return modelAndView;
	}
	
	@PostMapping("/kaydet")
	public ModelAndView kaydet (HttpServletRequest request) {
	    ModelAndView modelAndView = new ModelAndView();
	    String username = request.getParameter("username"); 
	    String email = request.getParameter("email");
	    mainService.sendInfos(username,email);
	    modelAndView.setViewName("home");
	    return modelAndView;
	}
	
	@GetMapping("/getAll")
	public ArrayList<String[]> getAllUsers (HttpServletRequest request,ModelMap model) {
	    ModelAndView modelAndView = new ModelAndView();
	    String username = request.getParameter("username"); 
	    String email = request.getParameter("email");
	    ArrayList<String[]> a1 = new ArrayList<String[]>();
	    a1 = mainService.getAllUsers();
	    model.addAttribute("users", a1);
	    modelAndView.setViewName("index");
	    return  a1;
	}
}
