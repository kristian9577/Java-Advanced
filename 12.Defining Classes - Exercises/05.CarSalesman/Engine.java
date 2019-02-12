package CarSalesman;

public class Engine {
    private static final String DEFAULT_VALUE = "n/a";

    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, String power, String value) {
        this(model, power);
        if (value.matches("-?\\d+(\\.\\d+)?")) {
            this.displacement = value;
        } else {
            this.efficiency = value;
        }
    }

    public Engine(String model, String power) {
        this(model, power, DEFAULT_VALUE, DEFAULT_VALUE);
    }

    @Override
    public String toString() {
        return this.model + ":\n" +
                "Power: " + this.power + "\n" +
                "Displacement: " + this.displacement + "\n" +
                "Efficiency: " + this.efficiency + "\n";
    }
}