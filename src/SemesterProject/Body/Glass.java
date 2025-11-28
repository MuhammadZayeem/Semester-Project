package SemesterProject.Body;

import SemesterProject.Part;

public class Glass extends Part {

    public Glass(String name, String chasisModel,
                 int quantity, int threshold, double unitPrice) {

        super(name, "Glass", chasisModel,quantity, threshold, unitPrice);
    }

    @Override
    public void displayDetails() {
        System.out.println("-------- GLASS DETAILS --------");
        System.out.println("Type: " + getName());
        System.out.println("Car Model: " + getCarModel());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Unit Price: " + getUnitPrice());
        System.out.println("-------------------------------");
    }
}
