package softUniParking;

import java.util.ArrayList;
import java.util.List;

public class Main {public static void main(String[] args) {

    //Initialize the Parking
    Parking parking = new Parking(5);

    //Initialize Car
    Car car = new Car("Skoda", "Fabia", 65, "CC1856BG");

    //Initialize second Car object
    Car car2 = new Car("Audi", "A3", 110, "EB8787MN");

    System.out.println(car.toString());
    //Make: Skoda
    //Model: Fabia
    //HorsePower: 65
    //RegistrationNumber: CC1856BG

    System.out.println(parking.addCar(car));
    //Successfully added new car Skoda CC1856BG

    System.out.println(parking.addCar(car));
    //Car with that registration number, already exists!

    System.out.println(parking.addCar(car2));
    //Successfully added new car Audi EB8787MN

    System.out.println(parking.getCar("EB8787MN").toString());
    //Make: Audi
    //Model: A3
    //HorsePower: 110
    //RegistrationNumber: EB8787MN

    System.out.println(parking.removeCar("EB8787MN"));
    //Successfully removed EB8787MN
//
    System.out.println(parking.getCount()); //1

    //Initialize listOfRegistrationNumbers
    List<String> regNums = new ArrayList<>();

    //add two registrationNumbers
    regNums.add("EB8787MN");
    regNums.add("invalid");

    // call method removeSetOfRegistrationNumber with our list
    parking.removeSetOfRegistrationNumber(regNums);

    System.out.println(parking.getCount()); //1
}

}
