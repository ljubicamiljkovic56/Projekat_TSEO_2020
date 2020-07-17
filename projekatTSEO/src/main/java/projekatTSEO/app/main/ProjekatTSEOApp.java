package projekatTSEO.app.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"projekatTSEO.app.controller","projekatTSEO.app.repository"})
public class ProjekatTSEOApp{


	public static void main(String[] args) throws Exception {
		SpringApplication.run(ProjekatTSEOApp.class, args);
	}  

}
