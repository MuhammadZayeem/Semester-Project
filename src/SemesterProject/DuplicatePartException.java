package SemesterProject;
public class DuplicatePartException extends Exception {

    public DuplicatePartException() {
        super("Part already exists in the inventory!");
    }

    public DuplicatePartException(String message) {
        super(message);
    }
}
