package edu.frcc.csc1061j.StudentDirectory;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class StudentController {

	@RequestMapping("/");
	public String Index() {
		return "greetings from FRCC";
	}
}
