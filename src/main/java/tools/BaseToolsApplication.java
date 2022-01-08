package tools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.unicon.cas.client.configuration.EnableCasClient;

@EnableCasClient
@SpringBootApplication
public class BaseToolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseToolsApplication.class, args);
	}

}
