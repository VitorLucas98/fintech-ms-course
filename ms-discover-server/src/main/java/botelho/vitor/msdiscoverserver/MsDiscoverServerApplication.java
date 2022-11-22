package botelho.vitor.msdiscoverserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsDiscoverServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsDiscoverServerApplication.class, args);
	}

}
