public record records(String name, int age) {
    public records{

    }

    public records(String name) {
        this(name, 1);
    }

    public String getInfo(){
        return "Name: " + name + ", Age: " + age;
    }
}
