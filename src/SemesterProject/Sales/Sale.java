package SemesterProject.Sales;

import SemesterProject.Part;

import java.time.LocalDate;

public class Sale {
    private Part part;
    private int quantityUsed;
    private LocalDate date;

    public Sale(Part part, int quantityUsed, LocalDate date) {
        this.part = part;
        this.quantityUsed = quantityUsed;
        this.date = date;
    }

    public Part getPart() {
        return part;
    }

    public int getQuantityUsed() {
        return quantityUsed;
    }

    public LocalDate getDate() {
        return date;
    }
}

