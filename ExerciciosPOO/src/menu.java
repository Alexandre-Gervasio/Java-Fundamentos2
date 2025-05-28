import java.util.Scanner;

public class menu {

    private final static Scanner scanner = new Scanner(System.in);
    private final static PetPath petPath = new PetPath();
    public static void main(String[] args) {
        var option = -1;

        do {
            System.out.println("===Escolha uma opção===:");
            System.out.println("1 - Verificar nível de água");
            System.out.println("2 - Verificar nível de shampoo");
            System.out.println("3 - Adicionar água");
            System.out.println("4 - Adicionar shampoo");
            System.out.println("5 - Colocar pet na máquina");
            System.out.println("6 - Dar banho no pet");
            System.out.println("7 - Retirar pet da máquina");
            System.out.println("8 - Verificar se tem pet na máquina");
            System.out.println("9 - Limpar máquina");
            System.out.println("10 - Sair\n");
            option = scanner.nextInt();

            switch (option){
                case 1 -> verifyWater();
                case 2 -> verifyShampoo();
                case 3 -> addWater();
                case 4 -> addShampoo();
                case 5 -> setPetInPetPath();
                case 6 -> petPath.takeAShower();
                case 7 -> petPath.removePet();
                case 8 -> checkIfHasPetInMachine();
                case 9 -> petPath.wash();
                case 10 -> System.exit(0);
                default -> System.out.println("Opção inválida, tente novamente.\n");
            }

        } while (true);
    }

    private static void addWater() {
        petPath.addWater();
        System.out.println("Água sendo adicionada!\n");
    }

    private static void addShampoo() {
        petPath.addShampoo();
        System.out.println("Shampoo sendo adicionado!\n");
    }

    private static void verifyWater() {
        var amount = petPath.getWater();
        System.out.println("A máquina tem " + amount + " de água\n");
    }

    private static void verifyShampoo() {
        var amount = petPath.getShampoo();
        System.out.println("A máquina tem " + amount + " de shampoo\n");
    }

    private static void checkIfHasPetInMachine() {
        var hasPet = petPath.hasPet();
        System.out.println("Tem pet na máquina? " + (hasPet ? "Sim\n" : "Não\n"));
    }

    public static void setPetInPetPath(){
        var name = "";
        while (name == null || name.isEmpty()){
            System.out.println("Informe o nome do pet: ");
            name = scanner.next();
        }
        
        var pet = new Pet(name);
        petPath.setPet(pet);
    }


}


