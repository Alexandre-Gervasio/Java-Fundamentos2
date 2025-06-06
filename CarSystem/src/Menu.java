import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car();
        SystemCar systemCar = new SystemCar();

        int option;
        do {
            System.out.println("==== Menu:====");
            System.out.println("1. Ligar carro");
            System.out.println("2. Desligar carro");
            System.out.println("3. Acelerar carro");
            System.out.println("4. Desacelerar carro");
            System.out.println("5. Trocar marcha");
            System.out.println("6. Virar à direita");
            System.out.println("7. Virar à esquerda");
            System.out.println("8. Mostrar estado do carro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: \n");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    systemCar.turnOn(car);
                    break;
                case 2:
                    systemCar.turnOff(car);
                    break;
                case 3:
                    systemCar.accelerate(car);
                    break;
                case 4:
                    systemCar.decelerate(car);
                    break;
                case 5:
                    System.out.print("Digite a nova marcha (0-6): ");
                    int newGear = scanner.nextInt();
                    systemCar.turnGear(car, newGear);
                    break;
                case 6:
                    systemCar.turnRight(car);
                    break;
                case 7:
                    systemCar.turnLeft(car);
                    break;
                case 8:
                    systemCar.showState(car);
                    break;
                case 0:
                    System.out.println("Saindo do menu.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (option != 0);
        scanner.close();
        System.out.println("Programa encerrado.");
    }
}
