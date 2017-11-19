package de.hftl.studentproducer;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {
	
	private List<Student> studentList = Arrays.asList(
			new Student(1, "Annika Test", "Wirtschaftsinformatik"),
			new Student(2, "Peter Prüfer","Kommunikations- und Medieninformatik"),
			new Student(3, "Alex Muster", "Anwendungsinformatik")
	);
	
	@Value("${server.port}")
		String serverPort;
	
	@GetMapping("/students")
	public List<Student> findAllStudents() {
		return studentList;
	}
	
	@GetMapping("/students/{studentId}")
	public Student findStudent(@PathVariable int studentId) {
		return studentList.stream().filter(b -> b.getStudentId() == studentId).findFirst().orElse(null);
	}
	
	@GetMapping("/greeting")
	public String greet() {
		
		List<String> greetings = Arrays.asList("Hi There", "Greetings", "Salutations");
		Random rand = new Random();
		
		int randomNum = rand.nextInt(greetings.size());
		return serverPort + " : " + greetings.get(randomNum);
	}

}
