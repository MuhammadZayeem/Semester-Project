package SemesterProject;


import SemesterProject.Exception.LowStockException;
import SemesterProject.Exception.NegativeStockException;

public abstract class Part {

    // -------------------------
    // Attributes
    // -------------------------

    private String name;
    private String category;
    private String carModel;
    private int quantity;
    private int threshold;
    private double unitPrice;
    //private Supplier supplier;

    // -------------------------
    // Constructor
    // -------------------------
    public Part( String name, String category, String carModel,
                int quantity, int threshold, double unitPrice/*Supplier supplier*/) {


        this.name = name;
        this.category = category;
        this.carModel = carModel;
        this.quantity = quantity;
        this.threshold = threshold;
        this.unitPrice = unitPrice;
       // this.supplier = supplier;
    }

    // -------------------------
    // Abstract Method (Must Override in Child)
    // -------------------------
    public abstract void displayDetails();  // Polymorphism

    // -------------------------
    // Concrete Methods
    // -------------------------

    public void addQuantity(int amount) {
        if (amount <= 0) return;
        this.quantity += amount;
    }

    public void reduceQuantity(int amount) throws LowStockException, NegativeStockException
     {

        if (amount <= 0) return;

        if (quantity - amount < 0)
            throw new NegativeStockException("Stock for " + name + " cannot go negative!");

        this.quantity -= amount;

        if (isLowStock())
            throw new LowStockException("Low stock alert for: " + name);
    }

    public boolean isLowStock() {
        return this.quantity <= this.threshold;
    }

    public double calculateStockValue() {
        return quantity * unitPrice;
    }

    // -------------------------
    // Getters & Setters
    // -------------------------


    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getCarModel() { return carModel; }
    public int getQuantity() { return quantity; }
    public int getThreshold() { return threshold; }
    public double getUnitPrice() { return unitPrice; }
    //public Supplier getSupplier() { return supplier; }

    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setThreshold(int threshold) { this.threshold = threshold; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
  //  public void setSupplier(Supplier supplier) { this.supplier = supplier; }
}
