package P4_Design_Patterns.P3_Structural.P4_Composite.E1_File_System.Refactored_Code;

import P4_Design_Patterns.P3_Structural.P4_Composite.E1_File_System.Refactored_Code.models.FileSystemComponent;
import P4_Design_Patterns.P3_Structural.P4_Composite.E1_File_System.Refactored_Code.models.impl.File;
import P4_Design_Patterns.P3_Structural.P4_Composite.E1_File_System.Refactored_Code.models.impl.Folder;

public class Client {
    public static void main(String[] args) {
        FileSystemComponent file1 = new File("file1.txt", 10);
        FileSystemComponent file2 = new File("file2.txt", 20);

        Folder folder1 = new Folder("Documents");
        folder1.addFileSystem(file1);

        Folder folder2 = new Folder("Images");
        folder2.addFileSystem(file2);

        Folder root = new Folder("Root");
        root.addFileSystem(folder1);
        root.addFileSystem(folder2);

        FileSystemComponent file3 = new File("file3.png", 200);
        root.addFileSystem(file3);

        root.showDetails();

        System.out.println("Total Size: " + root.getSize() + " KB");
    }
}
