package portfolio.gardengnomes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@SpringBootApplication
@RestController
public class GardengnomesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GardengnomesApplication.class, args);
	}

	@GetMapping("path")
	public String getMethodName(@RequestParam String param) {
		return "";
	}
	
	@GetMapping("")
	public String helloWorld(){
		return "Hello";
	}

}
