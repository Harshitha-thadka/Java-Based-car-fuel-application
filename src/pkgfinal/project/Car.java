package pkgfinal.project;

import java.util.ArrayList;
import java.util.List;

public class Car extends FileHandling {

    String carName;
    int fuelCapacity; //Gas tank size in liters
    int optimalSpeed; //best speed for fuel economy in kmph
    int kmPerLiter; // kilometers per liter
    int topSpeed; //top speed of vehicle in kmph
    List<Car> allCars = new ArrayList<Car>(); //All cars that we create will be saved in this list for further usage.
    final double dieselPricePerLiter= 2.4; //2.4$, this is a constant value

    public Car() { //on the start of the class the constructor will be hit and the all cars list will be filled.
        if (allCars.isEmpty()) {
            allCars = fillAllCarsData();
        }
    }

    /*
    A multi-parameter constructor which can be used to create car object easily
    */
    public Car(String carName, int fuelCapacity, int optimalSpeed, int kmPerLiter, int topSpeed) {
        this.carName=carName;
        this.fuelCapacity = fuelCapacity;
        this.optimalSpeed = optimalSpeed;
        this.kmPerLiter = kmPerLiter;
        this.topSpeed = topSpeed;
    }

    /*
    Here we will add each car (that we create) in to the all cars list, so that we can loop through and acess each car easily in the future
    */
    private List<Car> fillAllCarsData() {
        allCars.add(new Car("camry",20, 70, 17, 120));//using the above multi-parameter constructor we are creating car object and adding it to list
        allCars.add(new Car("tundra",19, 90, 15, 150));
        allCars.add(new Car("prius",15, 85, 12, 180));

        return allCars;
    }
    
    /*
    This method will calculate the travel cost of each car based on the travelling distance and mileage of the car
    */
    public double calTravelCostOfACar(float kmToTravel, int kmPerLiterOfCar) {
        double travelCost;
        float dieselRequiredInLiters;
            dieselRequiredInLiters=kmToTravel/kmPerLiterOfCar;
            travelCost=dieselRequiredInLiters*dieselPricePerLiter;
            return travelCost;
    }

/*
    This method will calculate travel time based on the travelling distance and optimal/average speed of the car
    */
    public float calTravelTimeOfACar( float kmToTravel, int optimalSpeedOfCar) {
          return  kmToTravel/optimalSpeedOfCar;
    }
}
