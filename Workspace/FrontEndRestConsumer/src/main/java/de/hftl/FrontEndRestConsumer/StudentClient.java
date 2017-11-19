package de.hftl.FrontEndRestConsumer;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.hftl.Ribbon.RibbonConfiguration;

// fallback = FrontendClientFallback.class
@FeignClient(name = "student-producer")
@RibbonClient(name = "student-producer", configuration = RibbonConfiguration.class)
public interface StudentClient {
	
	 @RequestMapping(produces = {"application/json;charset=utf-8"}, value = "/students", method = RequestMethod.GET)
	 public List<Student> findAllStudents();
	 
	 @RequestMapping(value="greeting", method = RequestMethod.GET)
	 String getGreeting();
	 
	 @RequestMapping(value = "/students/{studentId}", method = RequestMethod.GET)
	 Student findStudent(@PathVariable("studentId") int studentId);
}
