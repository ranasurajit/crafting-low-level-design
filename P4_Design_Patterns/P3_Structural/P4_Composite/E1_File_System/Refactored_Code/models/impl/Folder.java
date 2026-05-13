package P4_Design_Patterns.P3_Structural.P4_Composite.E1_File_System.Refactored_Code.models.impl;

import java.util.ArrayList;
import java.util.List;

import P4_Design_Patterns.P3_Structural.P4_Composite.E1_File_System.Refactored_Code.models.FileSystemComponent;

public class Folder implements FileSystemComponent {
    private List<FileSystemComponent> fileList;
    private String name;

    public Folder(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Folder name cannot be empty!");
        }
        this.name = name;
        fileList = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addFileSystem(FileSystemComponent component) {
        if (component == null) {
            throw new IllegalArgumentException("Component cannot be null!");
        }
        fileList.add(component);
    }

    @Override
    public void showDetails() {
        System.out.println("FOLDER : " + name);
        for (FileSystemComponent component : fileList) {
            component.showDetails();
        }
    }

    @Override
    public int getSize() {
        if (fileList == null) {
            throw new IllegalStateException("Folder cannot be null!");
        }
        int totalSize = 0;
        for (FileSystemComponent component : fileList) {
            totalSize += component.getSize();
        }
        return totalSize;
    }
}
