package CatLady;

public class Cymric extends Cat {
    private double furLength;

    public Cymric(String name, double furLength) {
        super(name);
        this.furLength = furLength;
    }
    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.getClass().getSimpleName(), super.getName(), this.furLength);
    }
}
