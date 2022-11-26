package com.s26009.service.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class Rental {
    private LocalDate startDate;
    private LocalDate endDate;
    private double price;
    private User user;
    private Car car;

    public Rental() {
    }

    public Rental(LocalDate startDate, LocalDate endDate, double priceForOneDay, User user, Car car) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = priceForOneDay * Period.between(startDate, endDate).getDays();
        this.user = user;
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", user=" + user +
                ", car=" + car +
                '}';
    }

    public RentalInfo getRentalInfo() {
        return new RentalInfo(price, startDate, endDate);
    }
}
