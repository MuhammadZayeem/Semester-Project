package SemesterProject.Body;

import SemesterProject.Part;

public class BodyPart extends Part {

    public BodyPart(String name, String chasisModel,
                    int quantity, int threshold, double unitPrice) {

        super(name,"Body", chasisModel, quantity, threshold, unitPrice);
    }

    @Override
    public void displayDetails() {
        System.out.println("-------- BODY PART DETAILS --------");
        System.out.println("Name: " + getName());
        System.out.println("Car Model: " + getCarModel());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Unit Price: " + getUnitPrice());
        System.out.println("-----------------------------------");
    }
}
