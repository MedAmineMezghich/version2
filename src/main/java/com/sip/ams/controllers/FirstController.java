package com.sip.ams.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.entities.Animal;

@Controller
public class FirstController {

	@GetMapping("/home")
	//@ResponseBody
	public String home()
	{
		//return "<h1 align=center>Hello Spring Boot</h1>";
		return "/first/home";
	}
	
	@GetMapping("/acceuil")
	public String acceuil(@RequestParam (required=false,defaultValue = "Spring Boot") String framework,
			@RequestParam (required=false,defaultValue = "1") int version
			,ModelMap monObj)
	{
		String ecole = "POLYTECH";
		String formation = "Spring boot & Angular";
		String ch = "Vous avez choisi : "+ framework;
		String v = "version : "+ version;
		
		ArrayList<String> names = new ArrayList<>();
		monObj.put("msg",ch);
		monObj.put("version",v);
		
		names.add("Amine");
		names.add("Haytem");
		names.add("Latifa");
		
		
		monObj.put("ec",ecole); 
		monObj.put("forma",formation); 
		monObj.put("names",names); 
		
		ArrayList<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Lyon",3));
		animals.add(new Animal("Elephant",2));
		animals.add(new Animal("Oiseau",1));
		monObj.put("animals",animals); 
		
		return "/first/acceuil";
	}
}
