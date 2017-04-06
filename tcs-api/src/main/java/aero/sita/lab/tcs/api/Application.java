package aero.sita.lab.tcs.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aero.sita.lab.tcs.messaging.Car;
import aero.sita.lab.tcs.messaging.Sender;

@SpringBootApplication
@RestController
public class Application {

//    @Autowired
	private Sender sender;

    @RequestMapping("/")
    public String home() {
		Car car = new Car("Passat", "Volkswagen", "ABC-123");
		sender.send(car);
        return car.toString();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
