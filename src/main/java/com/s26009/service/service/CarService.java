package com.s26009.service.service;

import com.s26009.service.model.Car;
import com.s26009.service.model.Rental;
import com.s26009.service.model.RentalInfo;
import com.s26009.service.model.User;
import com.s26009.service.storage.CarStorage;
import com.s26009.service.storage.RentalStorage;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class CarService {
    private final CarStorage carStorage;
    private final RentalStorage rentalStorage;

    public CarService() {
        carStorage = new CarStorage();
        rentalStorage = new RentalStorage();
    }

    public List<Car> getAllCars() {
        return carStorage.getCars();
    }

    public List<Rental> getAllRentals() {
        return rentalStorage.getRentals();
    }

    public void printAllCars() {
        carStorage.printAllCars();
    }

    public void printAllRentals() {
        rentalStorage.printAllRentals();
    }

    public RentalInfo rentCar(User user, String vin, LocalDate startDate, LocalDate endDate) {
        Car requestedCar = carStorage.getCarByVin(vin);
        if (requestedCar != null) {
            if (rentalStorage.getRentalByVin(vin) == null) {
                Rental newRental = new Rental(startDate, endDate, requestedCar.getPriceForOneDay(), user, requestedCar);
                rentalStorage.getRentals().add(newRental);
                System.out.println("Car " + requestedCar.getMake() + " " + requestedCar.getModel()
                        + " is rented successfully for " + user.getAccId()
                        + " ($" + newRental.getPrice() + ", for $" + requestedCar.getPriceForOneDay() + " a day)!");
                return newRental.getRentalInfo();
            } else {
                System.out.println("Car already rented.");
                return null;
            }
        } else {
            System.out.println("We don't have such car.");
            return null;
        }
    }

    public double calculateRentalPrice(double priceForOneDay, LocalDate start, LocalDate end) {
        return priceForOneDay * Period.between(start, end).getDays();
    }
}
