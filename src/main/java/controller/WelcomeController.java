package controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
@Controller
public class WelcomeController {
	
	Logger logger = LogManager.getLogger(this.getClass());
	
	@GetMapping("/")
	public ModelAndView homePage() {
		try {
		logger.info("homePage");
		ModelAndView mw = new ModelAndView("homePage");
		return mw;
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
			return new ModelAndView("error");
		}
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		try {
		logger.info("login");
		ModelAndView mw = new ModelAndView("login");
		return mw;
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
			return new ModelAndView("error");
		}
	}
}
