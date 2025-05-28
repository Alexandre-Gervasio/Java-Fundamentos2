public class App {
    public static void main(String[] args){
        
        var male = new Person("João");
        var female = new Person("Maria");

        System.out.println("Male.name: " + male.getName() + "age: " + male.getAge());

        System.out.println("Female.name: " + female.getName() + " age: " + female.getAge());
    }
}
