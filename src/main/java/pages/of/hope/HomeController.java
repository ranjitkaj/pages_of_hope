
package pages.of.hope;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
	@Autowired
	private studentRepository std;

	@GetMapping("/")
	public String home(Model m1) {
		m1.addAttribute("s", new Student());
		return "index";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute Student s, Model m1) {
		System.out.println(s);
		System.out.println("Welcome " + s.getName());
		m1.addAttribute("key", s.getName());
		std.save(s);
		return "register";
	}
	
	@GetMapping("/show")
	public String show(Model m1) {
		List<Student> s = std.findAll();
		m1.addAttribute("s", s);
		return "show";
	}
	
	
}

