package test;

import java.awt.*;

public class Car {
    String model;
    Car(String model) {
        this.model = model;
    }
    public String toString() {
        return model;
    }

    public static void main(String[] args) {
        Car car = new Car("BMW");
        ElectroCar electroCar = new ElectroCar();
        ElectroCar electroCar1 = new ElectroCar(200, "Citroen");
        System.out.println(car.toString() + "\n" +
                electroCar.toString() + "\n" +
                electroCar1.toString());
    }
}
class ElectroCar extends Car {
    int power;
    ElectroCar() {
        super("tesla");
        power = 100;
    }
    ElectroCar(int power, String model) {
        super(model);
        this.power = power;
    }
    public String toString() {
        return model + power;
    }
}
