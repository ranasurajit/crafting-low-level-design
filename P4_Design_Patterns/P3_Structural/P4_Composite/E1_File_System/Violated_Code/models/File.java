package P4_Design_Patterns.P3_Structural.P4_Composite.E1_File_System.Violated_Code.models;

public class File {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void showDetails() {
        System.out.println("File: " + name + " (" + size + " KB)");
    }

    public int getSize() {
        return size;
    }
}
