package ru.job4j.solid.lsp.parking;

public class ParkingCar implements Parking {
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
        boolean rsl = false;
        if (car.getSize() > 1) {
            if (sizeForTruck != 0) {
                storeTruck[sizeForTruck - 1] = car;
                sizeForTruck--;
                rsl = true;
            } else {
                if (sizeForPassCar >= car.getSize()) {
                    int i = 0;
                    while (i < car.getSize()) {
                        storePassCar[sizeForPassCar - 1] = car;
                        i++;
                        sizeForPassCar--;
                    }
                    rsl = true;
                }
            }
        } else {
            if (sizeForPassCar != 0) {
                storePassCar[sizeForPassCar - 1] = car;
                sizeForPassCar--;
                rsl = true;
            }
        }
        return rsl;
    }
}
