package com.mybnb.app.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index(Model model, @RequestParam String name) {
		
		SQLController sqlMngr = new SQLController();
		ResultSet res;
		try {
			sqlMngr.connect();
			res = sqlMngr.executeQuery("SELECT * FROM User");
			
			while(res.next()) {
				System.out.println(res);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("name", name);
		return "index";
	}
}
