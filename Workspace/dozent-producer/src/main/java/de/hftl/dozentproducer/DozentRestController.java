package de.hftl.dozentproducer;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DozentRestController {
	private List<Dozent> dozentList = Arrays.asList(
			new Dozent(1, "Sebastian Prüfer", "Betriebswirtschaftslehre"),
			new Dozent(2,"Emma Gremium","Datenbanken"),
			new Dozent(3,"John Tester","Anwendungsentwicklung")
	);
	
	@Value("${server.port}")
	String serverPort;
	
	@GetMapping("/greeting")
	public String greet() {
		
		List<String> greetings = Arrays.asList("Hi There", "Greetings", "Salutations");
		Random rand = new Random();
		
		int randomNum = rand.nextInt(greetings.size());
		return serverPort + " : " + greetings.get(randomNum);
	}
	
	@GetMapping("/dozents")
	public List<Dozent> findAllDozents() {
		return dozentList;
	}
	
	@GetMapping("/dozents/{dozentId}")
	public Dozent findDozent(@PathVariable int employeeId) {
		return dozentList.stream().filter(b -> b.getEmployeeId() == employeeId).findFirst().orElse(null);
	}
}
