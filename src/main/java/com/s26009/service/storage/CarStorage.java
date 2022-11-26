package com.s26009.service.storage;


import com.s26009.service.model.Car;
import com.s26009.service.model.Rental;

import java.util.ArrayList;
import java.util.List;

public class CarStorage {
    private List<Car> cars;

    public CarStorage() {
        cars = new ArrayList<>();
        cars.add(new Car("Audi", "A1", "1",100.0));
        cars.add(new Car("Suzuki", "A2", "2",50.0));
        cars.add(new Car("Volvo", "A3", "3", 60.0));
        cars.add(new Car("Mercedes", "A4", "4", 80.0));
        cars.add(new Car("Bentley", "A5", "5", 150.0));
    }

    public CarStorage(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCarByVin(String vin) {
        for (Car c : cars) {
            if(c.getVin().equals(vin)) {
                return c;
            }
        }
        return null;
    }

    public void printAllCars() {
        System.out.println("----------CARS---------");
        for (Car c : cars) {
            System.out.println("[ VIN: " + c.getVin() +
                    ", MAKE: " + c.getMake() +
                    ", MODEL: " + c.getModel() +
                    ", END: " + c.getPriceForOneDay() + " ]");
        }
        System.out.println("-----------------------");
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
