package P4_Design_Patterns.P3_Structural.P4_Composite.E1_File_System.Refactored_Code.models.impl;

import P4_Design_Patterns.P3_Structural.P4_Composite.E1_File_System.Refactored_Code.models.FileSystemComponent;

public class File implements FileSystemComponent {
    private String name;
    private int size;

    public File(String name, int size) {
        if (name == null) {
            throw new IllegalArgumentException("File name cannot be empty!");
        }
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println("FILE: " + name + " : " + size + "Kb");
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
