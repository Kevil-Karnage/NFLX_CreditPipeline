package nflx.bench.creditpipeline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration .class})
@EnableMongoRepositories
public class CreditPipelineApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditPipelineApplication.class, args);
	}

}
