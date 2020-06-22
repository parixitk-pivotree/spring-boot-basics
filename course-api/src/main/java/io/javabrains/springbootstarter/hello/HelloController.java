package io.javabrains.springbootstarter.hello;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Autowired
	private DBSettings dbSettings;
	
	@Autowired
	private Environment env;
	
	@Value("${my.greeting}")
	private String greetingMessage;
	
	@Value("${my.list.values}")
	private List<String> listVal;
	
	@Value("#{${db.connection}}")
	private Map<String, String> dbValues;
	
	@GetMapping("/greeting")
	public String greeting(){
		return dbSettings.getConnection() + "-->" + dbSettings.getHost() + "-->"+ dbSettings.getPort();
	}
	
	@GetMapping("/envdetails")
	public String getEnvDetails(){
		return env.toString();
	}
	
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi";
	}
}
