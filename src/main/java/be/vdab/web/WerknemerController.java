package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/werknemers")
public class WerknemerController {
	private static final String WERKNEMERS_VIEW = "werknemers/werknemers";

	@GetMapping
	String findAll() {
		return WERKNEMERS_VIEW;
	}
}
