package xyz.octopedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Description
 * @Author Charles Xu
 * @Date 23/11/2019 7:07 PM
 */

@SpringBootApplication
@ServletComponentScan
public class OctopediaApplication {

    public static void main(String[] args) {
        SpringApplication.run(OctopediaApplication.class, args);
    }

}

