package P4_Design_Patterns.P3_Structural.P4_Composite.E1_File_System.Violated_Code;

import P4_Design_Patterns.P3_Structural.P4_Composite.E1_File_System.Violated_Code.models.File;
import P4_Design_Patterns.P3_Structural.P4_Composite.E1_File_System.Violated_Code.models.Folder;

public class Client {
    public static void main(String[] args) {
        File file1 = new File("file1.txt", 10);
        File file2 = new File("file2.txt", 20);

        Folder folder1 = new Folder("Documents");
        folder1.addFile(file1);

        Folder folder2 = new Folder("Images");
        folder2.addFile(file2);

        Folder root = new Folder("Root");
        root.addFolder(folder1);
        root.addFolder(folder2);

        root.showDetails();

        System.out.println("Total Size: " + root.getSize() + " KB");
    }
}
