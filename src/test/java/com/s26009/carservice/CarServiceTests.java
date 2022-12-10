package com.s26009.carservice;

import com.s26009.service.model.RentalInfo;
import com.s26009.service.model.User;
import com.s26009.service.service.CarService;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

public class CarServiceTests {

//    Do napisania w domu testy dla przypadków:
//      1. Brak samochodu w CarStorage
//      2. Samochód już wynajęty przez kogoś innego
//      3. Data startDate jest późniejsza niż endDate
//      4. Jaka jest cena wynajmu samochodu PREMIUM
//      5. Jaka jest cena wynajmu samochodu STANDARD
//      6. Co się stanie jeżeli vin będzie nullem

    @Test
    void shouldReturnRentalInfoWithErrorMessage_whenRentCar_givenNonExistingAvailableCarVin() {
        //given
        LocalDate start = LocalDate.of(2022,5,10);
        LocalDate end = LocalDate.of(2022,5,24);
        CarService carService = new CarService();

        //when
        RentalInfo rentalInfo = carService.rentCar(new User("user2"), "6", start, end);

        //then
        assertThat(rentalInfo).isNotNull();
        assertThat(rentalInfo.getErrorMessage()).isEqualTo("We don't have such car.");
    }

    @Test
    void shouldReturnRentalInfoWithErrorMessage_whenRentCar_givenUnavailableExistingAvailableCarVin() {

        //given
        LocalDate start = LocalDate.of(2022,5,10);
        LocalDate end = LocalDate.of(2022,5,24);
        CarService carService = new CarService();

        //when
        RentalInfo rentalInfo = carService.rentCar(new User("user2"), "1", start, end);

        //then
        assertThat(rentalInfo).isNotNull();
        assertThat(rentalInfo.getErrorMessage()).isEqualTo("Car already rented by someone else.");
    }

    @Test
    void shouldReturnRentalInfoWithErrorMessage_whenRentCar_givenInvalidRentPeriod() {

        //given
        LocalDate start = LocalDate.of(2022,5,24);
        LocalDate end = LocalDate.of(2022,5,10);
        CarService carService = new CarService();

        //when
        RentalInfo rentalInfo = carService.rentCar(new User("user2"), "2", start, end);

        //then
        assertThat(rentalInfo).isNotNull();
        assertThat(rentalInfo.getErrorMessage()).isEqualTo("Invalid rental period (start date is after end date.");
    }

    @Test
    void shouldReturnRentalInfo_whenRentCar_givenExistingVin() {
        //given
        LocalDate start = LocalDate.of(2022,5,10);
        LocalDate end = LocalDate.of(2022,5,24);
        CarService carService = new CarService();

        //when
        RentalInfo rentalInfo = carService.rentCar(new User("user2"), "2", start, end);

        //then
        assertThat(rentalInfo).isNotNull();
        assertThat(rentalInfo.getPrice()).isEqualTo(9800.0);
    }

    @Test
    void shouldReturnRentalInfo_whenRentCar_givenNullVin() {
        //given
        LocalDate start = LocalDate.of(2022,5,10);
        LocalDate end = LocalDate.of(2022,5,24);
        CarService carService = new CarService();

        //when
        RentalInfo rentalInfo = carService.rentCar(new User("user2"), null, start, end);

        //then
        assertThat(rentalInfo).isNotNull();
        assertThat(rentalInfo.getErrorMessage()).isEqualTo("We don't have such car.");
    }
}
