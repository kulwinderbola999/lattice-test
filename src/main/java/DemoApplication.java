



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages= {"com.lattice.api","com.lattice.service","com.lattice.dao","com.lattice.repository"})
//@EntityScan(basePackages={"com.lattice.entity"})
public class DemoApplication  {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
