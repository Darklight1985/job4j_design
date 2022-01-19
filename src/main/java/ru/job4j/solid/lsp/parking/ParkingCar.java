package ru.job4j.solid.lsp.parking;

public class ParkingCar implements Parking {
    private final int oneSize = 1;
    private int sizeForPassCar;
    private int sizeForTruck;
    private Car[] storePassCar;
    private Car[] storeTruck;

    public ParkingCar(int sizeForPassCar, int sizeForTruck) {
        this.sizeForPassCar = sizeForPassCar;
        this.sizeForTruck = sizeForTruck;
        this.storePassCar = new Car[sizeForPassCar];
        this.storeTruck = new Car[sizeForTruck];
    }

    @Override
    public boolean add(Car car) {
        boolean rsl;
        if (car.getSize() == oneSize) {
           rsl = checkPasscar(car);
        } else {
            if (sizeForTruck != 0) {
                storeTruck[sizeForTruck - oneSize] = car;
                sizeForTruck--;
                rsl = true;
            } else {
            rsl = checkPasscar(car);
            }
        }
        return rsl;
    }

    public boolean checkPasscar(Car car) {
        boolean rsl = false;
        if (sizeForPassCar >= car.getSize()) {
            for (int i = 0; i < car.getSize(); i++) {
                storePassCar[sizeForPassCar - oneSize] = car;
                sizeForPassCar--;
            }
            rsl = true;
        }
        return rsl;
    }
}
