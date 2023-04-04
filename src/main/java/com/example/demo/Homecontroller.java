package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Homecontroller {
	@Autowired
	CaronaVirusDataService caronadataservice;
	@GetMapping("/")
		public String home(Model model) {
		List<LocationStats>alltats= caronadataservice.getAllstats();
		int totalReportedCases=alltats.stream().mapToInt(stat ->Integer.parseInt(stat.getTotalcases())).sum();
		int NewCases=alltats.stream().mapToInt(stat ->Integer.parseInt(stat.getCasesReported())).sum();
		model.addAttribute("locationstats",alltats);
		model.addAttribute("totalReportedCases",totalReportedCases );
		model.addAttribute("NewCases", NewCases);
		return "Home";
			
		}
	

}
