package CatLady;

public abstract class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }
     public String getName(){
        return this.name;
     }
}
