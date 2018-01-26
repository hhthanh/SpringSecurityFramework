package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import service.DatabaseService;

@Controller
public class DatabaseController {
	
	@Autowired
	private DatabaseService databaseService;
	
	@GetMapping("/database/init")
	private ModelAndView initDatabase() {
		ModelAndView mw = new ModelAndView("systemMessage");
		if(databaseService.initialDatabase()) {
			mw.addObject("systemMessage", "Initialized database successfully!");
		}else {
			mw.addObject("systemMessage", "Error ocurred when initial the database, please see details in log file!");
		}
		return mw;
	}
	
	@GetMapping("/encrypt")
	private ModelAndView enctyptPassword() {
		ModelAndView mw = new ModelAndView("systemMessage");
		if(databaseService.enctyptAllPassword()) {
			mw.addObject("systemMessage", "Encrypted all password!");
		}
		else {
			mw.addObject("systemMessage", "Error ocurred when encrypt the passwords, please see details in log file!");
		}
		
		return mw;
	}
}
