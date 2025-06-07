public class PetMachine {
    private boolean clean = true;
    private int water = 30;
    private int soap = 10;
    private Pet pet;

    //Dar banho no pet.
    public void takeAShower(){
        if(this.pet == null){
            System.out.println("Coloque o pet na máquina!\n");
            return;
        }

        this.water -= 10;
        this.soap -= 2;
        pet.setClean(true);
        System.out.println("O pet " + pet.getName() + " foi lavado e está limpo!\n");
    }

    //Abastecer a máquina com água 
    public void addWater(){
        if(water == 30){
            System.out.println("Capacidade máxima de água atingida!\n");
            return;
        }
        water += 2;
    }

    //Abastecer a máquina com shampoo
    public void addSoap(){
        if(soap == 10){
            System.out.println("Capacidade máxima de shampoo atingida!\n");
            return;
        }
        soap += 2;
    }

    //Verificar quanto de água e shampoo tem na máquina.
    public int getWater() {
        return water;
    }
    public int getSoap() {
        return soap;
    }

    //Verifica se tem pet na máquina.
    public boolean hasPet() {
        return pet != null;
    }

    //Permite verificar se a máquina está limpa.
    public void setPet(Pet pet) {
        if(!this.clean){
            System.out.println("A máquina está suja! Limpe-a antes de colocar o pet!\n");
            return;
        }
        if(hasPet()) {
            System.out.printf("O pet ", this.pet.getName() ," está na máquina!\n");
            return;
        }
        this.pet = pet;
        System.out.println("O Pet " + pet.getName() + " foi colocado na máquina!\n");

    }

    //Remove o pet da máquina, se ele estiver limpo.
    public void removePet() {
        this.clean = this.pet.isClean();
        System.out.println("O pet " + this.pet.getName() + " foi removido da máquina.\n");
        this.pet = null;
        
    }

    //Limpa a máquina, reduzindo água e shampoo.
    public void washMachine() {
        if(hasPet()) {
            System.out.printf("Tem um pet na máquina!\n");
            return;
        }
        this.water -= 10;
        this.soap -= 2;
        this.clean = true;
        System.out.println("A máquina foi lavada e está limpa!\n");        
    }


}
