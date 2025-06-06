public class Car {
    private boolean on;
    private int speed;
    private int gear;

    public Car() {
        this.on = false;
        this.speed = 0;
        this.gear = 0;
    }

    public boolean isOn() {
        return on;
    }

    public int getSpeed() {
        return speed;
    }

    public int getGear() {
        return gear;
    }

    public void turnOn(){
        on = true;
        System.out.println("Carro ligado\n");
    }

    public void turnOff() {
        if (!on) {
            System.out.println("Carro desligado, não é possível realizar nenhuma ação.\n");
            return;
        }
        if (speed > 0 && gear > 0) {
            System.out.println("Reduza a velocidade e coloque o carro em ponto morto antes de desligar.\n");
            return;
        } else if (speed > 0) {
            System.out.println("Reduza a velocidade antes de desligar.\n");
            return;
        } else if (gear > 0) {
            System.out.println("Coloque o carro em ponto morto antes de desligar.\n");
            return;
        } else {
            on = false;
            speed = 0;
            gear = 0;
            System.out.println("Desligar carro\n");
        }
    }

    public void accelerate(int increment) {
        if (!on) {
            System.out.println("Carro desligado, não é possível acelerar.\n");
            return;
        }
        speed += increment;
        if (speed > 120) {
            speed = 120;
            System.out.println("Velocidade máxima atingida: 120 km/h\n");
        }
        System.out.println("Acelerando: " + speed + " km/h\n");
    }

    public void decelerate(int decrement) {
        if (!on) {
            System.out.println("Carro desligado, não é possível desacelerar.\n");
            return;
        }
        speed -= decrement;
        if (speed < 0) {
            speed = 0;
        }
        System.out.println("Desacelerando: " + speed + " km/h\n");
    }


    public void turnRight() {
        if (!on) {
            System.out.println("Carro desligado, não é possível virar.\n");
            return;
        }
        if (speed < 1 || speed > 40) {
            System.out.println("A velocidade para curvas fica entre 1 km/h e 40 km/h.\n");
            return;
        }
        System.out.println("Virando à direita\n");
    }

    public void turnLeft() {
        if (!on) {
            System.out.println("Carro desligado, não é possível virar.\n");
            return;
        }
        if (speed < 1 || speed > 40) {
            System.out.println("A velocidade para curvas fica entre 1 km/h e 40 km/h.\n");
            return;
        }
        System.out.println("Virando à esquerda\n");
    }

    public void turnGear(int newGear) {
        if (!on) {
            System.out.println("Carro desligado, não é possível mudar de marcha.\n");
            return;
        }
        if (Math.abs(newGear - gear) != 1) {
            System.out.println("Só pode trocar para marchas adjacentes. (Ex: de 1 para 2 ou de 2 para 3)\n");
            return;
        }
        if (!speedIsValidForGear(newGear)) {
            System.out.println("A velocidade não é adequada para a marcha " + newGear + ".\n");
            return;
        }

        gear = newGear;

        if (gear == 0) {
            System.out.println("O carro está em ponto morto.\n");
        } else {
            System.out.println("Mudando para a marcha: " + gear + "\n");
        }
    }


    private boolean speedIsValidForGear(int newGear) {
        if (newGear == 0) {
            return speed == 0;
        }
        if (speed < 0 || speed > 120) {
            return false;
        }
        switch (newGear) {
            case 1:
                return speed >= 1 && speed <= 20;
            case 2:
                return speed >= 21 && speed <= 40;
            case 3:
                return speed >= 41 && speed <= 60;
            case 4:
                return speed >= 61 && speed <= 80;
            case 5:
                return speed >= 81 && speed <= 100;
            case 6:
                return speed >= 101 && speed <= 120;
            default:
                return false;
        }
    }
    
    public void showStatus() {
        System.out.println("Status do carro:");
        System.out.println("Ligado: " + (on ? "Sim" : "Não"));
        System.out.println("Velocidade: " + speed + " km/h");
        System.out.println("Marcha: " + gear);
        System.out.println();
    }



}
