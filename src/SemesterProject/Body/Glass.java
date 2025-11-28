package SemesterProject.Body;



public abstract class Glass extends BodyPart {

    public Glass(String name, String carChasis,
                 int quantity, int threshold, double unitPrice) {
        super(name,carChasis,quantity,threshold,unitPrice);
        this.getClass().getSimpleName();

    }

}
