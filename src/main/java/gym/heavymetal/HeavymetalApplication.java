package gym.heavymetal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
public class HeavymetalApplication {

    public static void main(String[] args) {
        log.info("================================================");
        log.info("++++++++++++++++++++++++++++++++++++++++++++++++");
        log.info("================================================");
        SpringApplication.run(HeavymetalApplication.class, args);
    }

}
