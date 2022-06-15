package MDC.projectGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = "MDC.projectGenerator")
public class ProjectGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectGeneratorApplication.class, args);
	}

}
