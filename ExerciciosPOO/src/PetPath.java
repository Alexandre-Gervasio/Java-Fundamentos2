public class PetPath {
    private boolean clean = true;
    private int water = 30;
    private int shampoo = 10;
    private Pet pet;

    public void takeAShower(){
        if(this.pet == null){
            System.out.println("Coloque o pet na máquina para iniciar o banho\n");
            return;
        }

        this.water -= 10;
        this.shampoo -= 2;

        pet.setClean(true);
        System.out.println("O pet " + pet.getName() + " tomou banho\n");
    }

    public void addWater(){
        if(water == 30){
            System.out.println("A máquina já está cheia de água\n");
            return;
        }
        water += 2;
    }

        public void addShampoo(){
        if(shampoo == 10){
            System.out.println("A capacidade máxima de shampoo da máquina já está cheia\n");
            return;
        }
        shampoo += 2;
    }

    public int getWater() {
        return water;
    }
    public int getShampoo() {
        return shampoo;
    }
    public boolean hasPet(){
        return pet != null;
    }

    public void setPet(Pet pet) {
        if (!this.clean){
            System.out.println("A máquina está suja, limpe-a antes de colocar o pet\n");
            return;
        }
        if (hasPet()){
            System.out.println("O pet" + this.pet.getName() + "está na máquina nesse momento\n");
            return;
        }
        
        this.pet = pet;
        System.out.println("O Pet " + pet.getName() + " foi adicionado à máquina\n");
    }

    public void removePet(){
        this.clean = this.pet.isClean();
        System.out.println("O pet " + this.pet.getName() + " foi retirado da máquina, e está limpo!\n");
        this.pet = null;
    }

    public void wash(){
        this.water -= 10;
        this.shampoo -= 2;
        this.clean = true;
        System.out.println("A máquina foi lavada\n");
    }
}