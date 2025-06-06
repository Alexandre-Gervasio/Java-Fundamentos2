public class SystemCar {
    public void turnOn(Car car) {
        car.turnOn();
    }

    public void turnOff(Car car) {
        car.turnOff();
    }

    public void accelerate(Car car) {
        car.accelerate(1);
    }

    public void decelerate(Car car) {
        car.decelerate(1);
    }

    public void turnGear(Car car, int newGear) {
        car.turnGear(newGear);
    }

    public void turnRight(Car car) {
        if (!car.isOn()) {
            System.out.println("Carro desligado, não é possível virar.\n");
            return;
        }
        System.out.println("Virando à direita\n");
    }

    public void turnLeft(Car car) {
        if (!car.isOn()) {
            System.out.println("Carro desligado, não é possível virar.\n");
            return;
        }
        System.out.println("Virando à esquerda\n");
    }

    public void showState(Car car) {
        System.out.println("Estado do carro:");
        System.out.println("Ligado: " + (car.isOn() ? "Sim" : "Não"));
        System.out.println("Velocidade: " + car.getSpeed() + " km/h");
        System.out.println("Marcha: " + car.getGear());
    }
}
