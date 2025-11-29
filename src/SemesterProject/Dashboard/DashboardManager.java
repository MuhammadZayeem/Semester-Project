package SemesterProject.Dashboard;

import SemesterProject.Demand.DemandManager;
import SemesterProject.Part;
import SemesterProject.Sales.Sale;
import SemesterProject.Supplier.Supplier;

import java.time.LocalDate;
import java.util.*;

public class DashboardManager {

    private List<Part> parts;
    private List<Sale> sales;
    private DemandManager demandManager;

    public DashboardManager(List<Part> parts, List<Sale> sales, DemandManager demandManager) {
        this.parts = parts;
        this.sales = sales;
        this.demandManager = demandManager;
    }

    // ------------------------------------------
    // ✔ Calculate dashboard values
    // ------------------------------------------
    public DashboardData generateDashboard() {

        int totalParts = parts.size();

        // Count categories by class name
        Set<String> categories = new HashSet<>();
        for (Part p : parts) {
            categories.add(p.getClass().getSimpleName());
        }

        // Today's usage (sale count)
        int todayUsage = 0;
        LocalDate today = LocalDate.now();
        for (Sale s : sales) {
            if (s.getDate().equals(today)) {
                todayUsage += s.getQuantityUsed();
            }
        }

        // Low stock count
        int lowStock = 0;
        for (Part p : parts) {
            if (p.getQuantity() <= p.getThreshold()) {
                lowStock++;
            }
        }

        // Supplier alerts (supplier who has low stock items)
        HashSet<Supplier> supplierSet = new HashSet<>();
        for (Part p : parts) {
            if (p.getQuantity() <= p.getThreshold()) {
                supplierSet.add(p.getSupplier());
            }
        }

        int supplierAlerts = supplierSet.size();

        // Demand count
        int demandCount = demandManager.getDemandCount();

        return new DashboardData(
                categories.size(),
                totalParts,
                todayUsage,
                lowStock,
                supplierAlerts,
                demandCount
        );
    }

    // ------------------------------------------
    // ✔ Display dashboard in console
    // ------------------------------------------
    public void showDashboard() {
        DashboardData data = generateDashboard();

        System.out.println("\n================ DASHBOARD ================");
        System.out.println("Total Categories       : " + data.getTotalCategories());
        System.out.println("Total Parts            : " + data.getTotalParts());
        System.out.println("Today's Usage          : " + data.getTodaysUsage());
        System.out.println("Low-Stock Alerts       : " + data.getLowStockCount());
        System.out.println("Supplier Alerts        : " + data.getSupplierAlerts());
        System.out.println("Demand List Items      : " + data.getDemandListCount());
        System.out.println("===========================================\n");
    }
}
