package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private double distancedTravelled;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distancedTravelled = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public double getDistancedTravelled() {
        return distancedTravelled;
    }

    public void setDistancedTravelled(double distancedTravelled) {
        this.distancedTravelled = distancedTravelled;
    }

    public void drive(double distanced) {
        double totalDistanced = distanced * this.fuelCost;
        if (totalDistanced <= this.fuelAmount) {
            this.fuelAmount -= totalDistanced;
            this.distancedTravelled += distanced;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public String toString() {
        return String.format("%s %.2f %.0f", this.getModel(), getFuelAmount(), getDistancedTravelled());
    }
}
