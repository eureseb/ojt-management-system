package edu.project.intern.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ready")
public class ReadyController {
	@GetMapping
	public String ready() {
		return "I'm ready!";
	}
}
