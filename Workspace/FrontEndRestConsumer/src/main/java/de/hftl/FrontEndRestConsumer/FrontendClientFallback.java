package de.hftl.FrontEndRestConsumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
class FrontendClientFallback implements StudentClient{
	
	private List<Student> dummyStudent = Arrays.asList(
			new Student(1, "Johnny Proband", "Wirtschaftsinformatik")
	);
	
	@Override
	public List<Student> findAllStudents() {
		
		return dummyStudent;
	}

	@Override
	public String getGreeting() {
		// TODO Auto-generated method stub
		return "Service is unavailable!";
	}

	@Override
	public Student findStudent(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
