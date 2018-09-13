package hello;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		int i;
		
		return args -> {
			final Todos  aux;
		final Todos todos2;
							RestTemplate restTemplate = new RestTemplate();
							ResponseEntity<List<Todos>> response = restTemplate.exchange(
								"https://jsonplaceholder.typicode.com/todos",HttpMethod.GET,null, new ParameterizedTypeReference<List<Todos>>(){});
							List<Todos> todos = response.getBody();							
							for(Todos t: todos)
								log.info(t.toString());		

							aux = todos.get(5);
							aux.setid(1224);
							aux.setuserId(1542);
						    todos2 = restTemplate.postForObject("https://jsonplaceholder.typicode.com/todos",aux , Todos.class);
							log.info("\n\npost: \n"+ todos2.toString());			
							
							
		};		
	}	
}

