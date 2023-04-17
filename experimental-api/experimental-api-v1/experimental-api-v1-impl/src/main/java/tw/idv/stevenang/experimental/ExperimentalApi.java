package tw.idv.stevenang.experimental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ExperimentalApi {

    public static void main(String[] args) {
        SpringApplication.run(ExperimentalApi.class, args);
    }
}
