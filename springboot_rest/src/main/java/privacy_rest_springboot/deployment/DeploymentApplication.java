package privacy_rest_springboot.deployment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.security.Policy;

@SpringBootApplication
public class DeploymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeploymentApplication.class, args);
	}


}
