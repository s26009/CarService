package com.s26009.service;

import com.s26009.service.model.RentalInfo;
import com.s26009.service.model.User;
import com.s26009.service.service.CarService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class RentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentalApplication.class, args);

        LocalDate start = LocalDate.of(2022,5,10);
        LocalDate end = LocalDate.of(2022,5,24);
        CarService carService = new CarService();

        carService.printAllRentals();
        carService.rentCar(new User("user2"), "6", start, end);
        carService.rentCar(new User("user2"), "1", start, end);
        RentalInfo rentalInfo = carService.rentCar(new User("user1"), "2", start, end);
        System.out.println(rentalInfo);
        carService.printAllRentals();
    }

}
