package pkgfinal.project;


import java.util.Scanner;

public class Menu extends Car {

    boolean exit;// based on this the menu will stop asking for input
    Scanner input = new Scanner(System.in);    //scanner will be used to read input from console
    final double dieselPricePerLiter = 2.4; //2.4$, this is a constant value
    int choice;

    public Menu() {
        saveAllCarsDataInFile(); //at the start of this class we will start file writing and save all cars data in a text file
    }

    public void runMenu() {
//        int choice;
        System.out.println("WELCOME TO THE TOYOTA VEHICLE DECISION TOOL");

        while (!exit) { //until user press 0 to exit, we will show the menu.
            System.out.println("\nWhat metric do you want to see?");
            System.out.println("1. Cost of travel");
            System.out.println("2. Travel time");
            System.out.println("3. Show all cars with their details");
            System.out.println("0. Exit");
            System.out.print("Enter menu choice: ");
            choice = getInput(); //get the choice entered by user
            performAction(choice); // perform action based on the entered choice
        }
    }

    /*
    this method gets the value entered by user and handles exception(like if user enters a character(a,#,$ etc) instead of a number etc)
     */
    public int getInput() {
        int enteredInput;
        try {
            enteredInput = input.nextInt();
        } catch (Exception e) {
            input.next();//clear the scanner, so that the old faulty value will not trouble during the next input reading
            System.out.print("Sorry you have entered a wrong input, please re-enter an appropriate numeric value: ");
            return getInput();
        }
        return enteredInput;
    }

    /*
    This method performs an action based on the choice selected by user
     */
    private void performAction(int choice) { //allows menu choice to be used

        switch (choice) {
            case 0:
                exit = true;
                System.out.println("Thank you, please visit again");
                break;
            case 1:
                travelCost();
                break;
            case 2:
                travelTime();
                break;
            case 3:
                readAllCarsDataFromFile();
                break;
            default:
                System.out.println("Please select a numeric option only from the above menu");
        }

    }

    /*
    This method will calculate the travel cost of each car based on the travelling distance and mileage of the car
     */
    private void travelCost() {
        double travelCost;
        System.out.print("Enter total kilometers travelling: ");
        float kmToTravel = getInput();
        for (Car car : allCars) {//this foreach loop will loop until all cars in the list are covered.
            travelCost = calTravelCostOfACar(kmToTravel, car.kmPerLiter);
            System.out.println("For " + car.carName + ": Travel cost = " + String.format("%.2f", travelCost) + "$");
        }
    }

    /*
    This method will calculate travel time based on the travelling distance and optimal/average speed of the car
     */
    private void travelTime() {
        float kmToTravel;
        float hoursToTravel;
        System.out.print("Enter total kilometers travelling: ");
        kmToTravel = getInput();
        for (Car car : allCars) {
            hoursToTravel = calTravelTimeOfACar(kmToTravel, car.optimalSpeed);
            System.out.print("For " + car.carName + ": Travel time = " + String.format("%.2f", hoursToTravel) + " hours");
            System.out.println(" or " + String.format("%.2f", hoursToTravel * 60) + " minutes");
        }
    }

    /*
    This methods exhibits file writing and saves all cars data in to a text file
     */
    private void saveAllCarsDataInFile() {
        int carNumber = 1;
        String dataToBeWrittenInFile = "";
        String latestDataToWrite = null;
        String fileName = "FileWritingSample.txt";

        //ready the data to write in a string
        for (Car car : allCars) {
            latestDataToWrite = carNumber + ". car name: " + car.carName + ", fuel capacity: " + car.fuelCapacity + ", optimal speed: " + car.optimalSpeed + ", mileage: " + car.kmPerLiter + ", top speed: " + car.topSpeed + "\n";
            dataToBeWrittenInFile = dataToBeWrittenInFile + latestDataToWrite;
            carNumber++;
        }
        //now that data in string will be sent to save in a file
        writeDataInFile(dataToBeWrittenInFile, fileName);
    }

    /**
     * This method exhibits file reading and displays all cars data that we
     * saved in a text file previously
     */
    private void readAllCarsDataFromFile() {
      //  String dataReadFromFile;
        String fileName = "FileWritingSample.txt";
        System.out.println(readDataFromFile(fileName));
    }

}
