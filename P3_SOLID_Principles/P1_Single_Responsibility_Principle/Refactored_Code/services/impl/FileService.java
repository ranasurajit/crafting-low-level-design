package P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.services.impl;

import java.io.FileWriter;
import java.io.IOException;

import P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.services.IStorageService;

public class FileService implements IStorageService {
    public void save(String username, String email, String hashed) {
        try (FileWriter fw = new FileWriter("users.txt", true)) {
            fw.write(username + "," + email + "," + hashed + "\n");
        } catch (IOException e) {
            throw new RuntimeException("could not save user", e);
        }
    }
}
