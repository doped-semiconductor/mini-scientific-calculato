package spe.dev.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	
	public String squareRoot(String ax) {
		double a = Double.parseDouble(ax);
		double b = Math.sqrt(a);
		return String.valueOf(b);
	}
	
	public String factorial(String ax) {
		int a = Integer.parseInt(ax);
		int b = 1;
		for(int i=1; i<=a; i++) {
			b*=i;
		}
		return String.valueOf(b);
	}
	
	public String natLog(String ax) {
		double a = Double.parseDouble(ax);
		double b = Math.log(a);
		return String.valueOf(b);
	}
	
	public String power(String ax, String bx) {
		double a = Double.parseDouble(ax);
		int b = Integer.parseInt(bx);
		double c = Math.pow(a, b);
		return String.valueOf(c);
	}



}
