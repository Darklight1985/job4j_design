package ru.job4j.solid.lsp.parking;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingCarTest {

    @Ignore
    @Test
    public void addWhenOneTruck() {
        ParkingCar parkingCar = new ParkingCar(2, 1);
        PassCar passCar = new PassCar("A815НЕ");
        PassCar passCarTwo = new PassCar("X815PЕ");
        Truck truck = new Truck("T524OO", 2);
        parkingCar.add(passCar);
        parkingCar.add(passCarTwo);
        assertTrue(parkingCar.add(truck));
    }

    @Ignore
    @Test
    public void addWhenTwoTruck() {
        ParkingCar parkingCar = new ParkingCar(2, 1);
        Truck truck = new Truck("T524OO", 3);
        Truck truckTwo = new Truck("T524OO", 2);
        parkingCar.add(truck);
        assertTrue(parkingCar.add(truckTwo));
    }

    @Ignore
    @Test
    public void addWhenFilled() {
        ParkingCar parkingCar = new ParkingCar(2, 1);
        PassCar passCar = new PassCar("A815НЕ");
        PassCar passCarTwo = new PassCar("X815PЕ");
        Truck truck = new Truck("T524OO", 3);
        Truck truckTwo = new Truck("T524OO", 2);
        parkingCar.add(passCar);
        parkingCar.add(passCarTwo);
        parkingCar.add(truck);
        assertFalse(parkingCar.add(truckTwo));
    }
}