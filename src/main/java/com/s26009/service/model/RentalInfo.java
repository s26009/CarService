package com.s26009.service.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

public class RentalInfo {
    private double price;
    private LocalDate startDate;
    private LocalDate endDate;
    private String errorMessage;

    public RentalInfo(double priceForOneDay, LocalDate startDate, LocalDate endDate) {
        this.price = priceForOneDay * Period.between(startDate, endDate).getDays();
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public RentalInfo(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "RentalInfo{" +
                "price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
