package de.hftl.FrontEndRestConsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.SpanAccessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@Service
public class FrontendController {
	
	private List<Student> dummyStudent = Arrays.asList(
			new Student(1, "Johnny Proband", "Wirtschaftsinformatik")
	);
	
	@Autowired
	private StudentClient studentClient;
	
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "defaultStudents")
	public List<Student> findAllStudents(Model model) {	
		List<Student> allStudents = studentClient.findAllStudents();
		model.addAttribute("response", allStudents);
		//LOG.info("Service ist hier");
	return allStudents;
	}
	
	
	
	@RequestMapping(value = "/students/{studentId}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "defaultStudent")
	public Student findStudent(@PathVariable int studentId) {
		Student student = studentClient.findStudent(studentId);
	    return student;
	}
	
	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "defaultGreeting")
	public String getStatus(){
		String studentStatus = studentClient.getGreeting();
		List<String> statusListe = new ArrayList<String>();
		statusListe.add(studentStatus);
		return "student-producer: (" + statusListe.get(0) + ")";
	}
	
	
	
	public String defaultGreeting() {
		return "Service is currently not Available!";
	}
	
	public Student defaultStudent(int studentId) {
		return dummyStudent.get(0);
	}
	
	public List<Student> defaultStudents(Model model) {
		return dummyStudent;
	}
}

