import java.util.Scanner;

public class Menu {

    private final static Scanner scanner = new Scanner(System.in);
    private final static PetMachine petMachine = new PetMachine();
    public static void main(String[] args) {
        scanner.useDelimiter("\\n");
        var option = -1;

        do {
            System.out.println("==== Menu ====");
            System.out.println("1 - Dar banho no Pet");
            System.out.println("2 - Abastecer água");
            System.out.println("3 - Abastecer shampoo");
            System.out.println("4 - Verificar a água da máquina");
            System.out.println("5 - Verificar o shampoo da máquina");
            System.out.println("6 - Verificar se tem Pet na máquina");
            System.out.println("7 - Colocar Pet na máquina");
            System.out.println("8 - Retirar Pet da máquina");
            System.out.println("9 - Limpar a máquina");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: \n");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> petMachine.takeAShower();
                case 2 -> setWater();
                case 3 -> setSoap();
                case 4 -> checkWater();
                case 5 -> checkSoap();
                case 6 -> checkIfHasPetInMachine();
                case 7 -> setPetInPetMachine();
                case 8 -> petMachine.removePet();
                case 9 -> petMachine.washMachine();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida! Tente novamente.\n");
            }
            
        }while (true);
    }

    //Adicionar água na máquina.
    private static void setWater(){
        System.out.println("Adicionando água na máquina...\n");
        petMachine.addWater();
    }

    //Adicionar shampoo na máquina.
    private static void setSoap(){
        System.out.println("Adicionando shampoo na máquina...\n");
        petMachine.addSoap();
    }

    //Checar a água da máquina.
    private static void checkWater() {
        var amount = petMachine.getWater();
        System.out.println("A máquina tem " + amount + " litro(s) de água.\n");
    }

    //Checar o shampoo da máquina.
    private static void checkSoap() {
        var amount = petMachine.getSoap();
        System.out.println("A máquina tem " + amount + " litro(s) de shampoo.\n");
    }



    //Checar se tem Pet na máquina.
    private static void checkIfHasPetInMachine() {
        var hasPet = petMachine.hasPet();
        System.out.println("Tem Pet na máquina? " + (hasPet ? "Sim\n" : "Não\n"));
    }

    //Inserir o Pet na máquina.
    public static void setPetInPetMachine(){
        if (petMachine.hasPet()) {
            System.out.println("Já tem um Pet na máquina!\n");
            return;
        }
        var name = "";
        while (name.isEmpty()){
            System.out.println("Digite o nome do Pet: ");
            name = scanner.next();
        }
        var pet = new Pet(name);
        petMachine.setPet(pet);
    }

}
