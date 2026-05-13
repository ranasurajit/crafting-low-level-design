package P4_Design_Patterns.P3_Structural.P4_Composite.E1_File_System.Violated_Code.models;

import java.util.ArrayList;
import java.util.List;

public class Folder {
    private String name;
    private List<File> files = new ArrayList<>();
    private List<Folder> subFolders = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addFile(File file) {
        files.add(file);
    }

    public void addFolder(Folder folder) {
        subFolders.add(folder);
    }

    public void showDetails() {
        System.out.println("Folder: " + name);

        for (File file : files) {
            file.showDetails();
        }

        for (Folder folder : subFolders) {
            folder.showDetails();
        }
    }

    public int getSize() {
        int totalSize = 0;

        for (File file : files) {
            totalSize += file.getSize();
        }

        for (Folder folder : subFolders) {
            totalSize += folder.getSize();
        }

        return totalSize;
    }
}
