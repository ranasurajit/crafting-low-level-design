package P3_SOLID_Principles.P5_Dependency_Inversion_Principle.Violated_Code.services;

import java.util.HashMap;
import java.util.Map;

public class MySqlUserRepository {
    private final Map<String, String> users = new HashMap<>();

    public void save(String id, String name) {
        users.put(id, name);
        System.out.println("[MySQL] Saved user " + id);
    }

    public String findNameById(String id) {
        System.out.println("[MySQL] Fetching user " + id);
        return users.get(id);
    }
}
