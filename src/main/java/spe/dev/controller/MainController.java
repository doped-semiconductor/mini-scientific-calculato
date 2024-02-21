package spe.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import spe.dev.service.CalculatorService;

@Controller
public class MainController {
	
	@Autowired
	CalculatorService calculatorService;
	
	String default_ans = "Answer";
	String ans = "";
	
	@GetMapping("/")
	public String getIndex(Model model) {
		model.addAttribute("ans",default_ans);
		return "index";
	}
	
	@GetMapping("/square-root")
	public String getSqRoot(Model model) {
		model.addAttribute("ans",default_ans);
		return "index";
	}
	
	@PostMapping("/square-root")
	public String getSqRootPost(String num1, Model model) {
		ans = calculatorService.squareRoot(num1);
		model.addAttribute("ans",ans);
		return "index";
	}
	
	@GetMapping("/factorial")
	public String getFac(Model model) {
		model.addAttribute("ans",default_ans);
		return "factorial";
	}
	
	@PostMapping("/factorial")
	public String getFacPost(String num1, Model model) {
		ans = calculatorService.factorial(num1);
		model.addAttribute("ans",ans);
		return "factorial";
	}
	
	@GetMapping("/logarithm")
	public String getLogarithm(Model model) {
		model.addAttribute("ans",default_ans);
		return "logarithm";
	}
	
	@PostMapping("/logarithm")
	public String getLogarithmPost(String num1, Model model) {
		ans = calculatorService.natLog(num1);
		model.addAttribute("ans",ans);
		return "logarithm";
	}
	
	@GetMapping("/exponentiation")
	public String getExponentiation(Model model) {
		model.addAttribute("ans",default_ans);
		return "exponentiation";
	}
	
	@PostMapping("/exponentiation")
	public String getExponentiationPost(String num1, String num2, Model model) {
		ans = calculatorService.power(num1, num2);
		model.addAttribute("ans",ans);
		return "exponentiation";
	}

}
