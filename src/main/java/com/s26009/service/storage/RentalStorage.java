package com.s26009.service.storage;


import com.s26009.service.model.Car;
import com.s26009.service.model.Rental;
import com.s26009.service.model.RentalInfo;
import com.s26009.service.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentalStorage {
    private List<Rental> rentals;

    public RentalStorage() {
        rentals = new ArrayList<>();
        rentals.add(new Rental(
                LocalDate.now(), LocalDate.now().plusDays(12L), 100.0,
                new User("hleb"),
                new Car("Audi", "A1", "1", 100.0)));
    }

    public RentalStorage(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public Rental getRentalByVin(String vin) {
        for (Rental r : rentals) {
            if (r.getCar().getVin().equals(vin)) {
                return r;
            }
        }
        return null;
    }

    public void printAllRentals() {
        System.out.println("--------RENTALS--------");
        for (Rental r : rentals) {
            System.out.println("[ VIN: " + r.getCar().getVin() +
                    ", USER: " + r.getUser().getAccId() +
                    ", PRICE: $" + r.getRentalInfo().getPrice() +
                    ", START: " + r.getRentalInfo().getStartDate() +
                    ", END: " + r.getRentalInfo().getEndDate() + " ]");
        }
        System.out.println("-----------------------");
    }
}
