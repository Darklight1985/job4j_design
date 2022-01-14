package ru.job4j.solid.lsp.parking;

public class ParkingCar implements Parking {
    private int sizeForPassCar;
    private int sizeForTruck;
    private int[] storePassCar;
    private  int[] storeTruck;

    public ParkingCar(int sizeForPassCar, int sizeForTruck) {
        this.sizeForPassCar = sizeForPassCar;
        this.sizeForTruck = sizeForTruck;
        this.storePassCar = new int[sizeForPassCar];
        this.storeTruck = new int[sizeForTruck];
    }

    @Override
    public boolean add(Car car) {
        return false;
    }
}
