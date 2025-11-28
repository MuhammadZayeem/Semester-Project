package SemesterProject.Supplier;
import SemesterProject.Body.FrontLaminatedGlass;
import SemesterProject.Body.RearGlass;
import SemesterProject.InventoryManagment.InventoryManager;
import SemesterProject.Part;

public class Main {

    public static void main(String[] args) {

        // Managers
        SupplierManager supplierManager = new SupplierManager();
        InventoryManager inventoryManager = new InventoryManager();


        // --------------------------
        // 1. CREATE A SUPPLIER
        // --------------------------
        Supplier supplier = new LocalSupplier(
                "Al-Madina Auto Parts",
                "0312-4567890",
                "almadina@gmail.com",
                "Montgomery Road, Lahore",
                "Glass"
        );

        supplierManager.addSupplier(supplier);


        // --------------------------
        // 2. CREATE PARTS
        // --------------------------
        Part frontGlass = new FrontLaminatedGlass("Mehran-2009", 5, 2, 3500);
        Part rearGlass  = new RearGlass("Civic-2018", 8, 3, 6500);

        // Add to inventory
        inventoryManager.addPart(frontGlass);
        inventoryManager.addPart(rearGlass);


        // --------------------------
        // 3. ASSIGN PART TO SUPPLIER
        // --------------------------
        supplierManager.assignPartToSupplier(supplier, frontGlass);


        // --------------------------
        // 4. PURCHASE STOCK
        // --------------------------
        supplierManager.recordPurchase(supplier, frontGlass, 10, 3100);


        // --------------------------
        // 5. SEARCH & FILTER
        // --------------------------
        System.out.println("\n--- SEARCH BY CAR MODEL: Mehran-2009 ---");
        for (Part p : inventoryManager.searchByCarModel("Mehran-2009")) {
            p.displayDetails();
        }

        System.out.println("\n--- LOW STOCK FILTER ---");
        for (Part p : inventoryManager.filterLowStock()) {
            p.displayDetails();
        }


        // --------------------------
        // 6. SHOW SUPPLIER DETAILS
        // --------------------------
        supplier.displaySupplierDetails();
    }
}
