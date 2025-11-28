package SemesterProject;

import SemesterProject.Body.FrontGlass;

public class Main {
    public static void main(String[] args) {
        FrontGlass frontGlass=new FrontGlass("CB71",25,15,3500);
        frontGlass.addQuantity(55);
        frontGlass.displayDetails();

    }
}
