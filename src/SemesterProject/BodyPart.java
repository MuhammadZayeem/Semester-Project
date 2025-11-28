package SemesterProject;

public class BodyPart extends Part {

    // Extra Attributes (Specific to Body Parts)
    private String material;   // metal / plastic / fiber
    private boolean painted;

    // Constructor
    public BodyPart(String partID, String name, String carModel,
                    int quantity, int threshold, double unitPrice,
                    Supplier supplier, String material, boolean painted) {

        super(partID, name, "Body", carModel, quantity, threshold, unitPrice, supplier);

        this.material = material;
        this.painted = painted;
    }

    // Required Polymorphism Override
    @Override
    public void displayDetails() {
        System.out.println("-------- BODY PART DETAILS --------");
        System.out.println("ID: " + getPartID());
        System.out.println("Name: " + getName());
        System.out.println("Car Model: " + getCarModel());
        System.out.println("Material: " + material);
        System.out.println("Painted: " + (painted ? "Yes" : "No"));
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Unit Price: " + getUnitPrice());
        System.out.println("------------------------------------");
    }

    // Optional Override (Can keep default)
    @Override
    public boolean isLowStock() {
        return getQuantity() < getThreshold();  // Standard logic
    }

    // Example of BodyPart-specific behavior
    public boolean isPremiumMaterial() {
        return material.equalsIgnoreCase("fiber") || material.equalsIgnoreCase("carbon fiber");
    }

    // Getters
    public String getMaterial() { return material; }
    public boolean isPainted() { return painted; }
}
