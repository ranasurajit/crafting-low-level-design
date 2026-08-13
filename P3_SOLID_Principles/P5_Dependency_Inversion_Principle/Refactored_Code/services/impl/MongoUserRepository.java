package P3_SOLID_Principles.P5_Dependency_Inversion_Principle.Refactored_Code.services.impl;

import java.util.HashMap;
import java.util.Map;

import P3_SOLID_Principles.P5_Dependency_Inversion_Principle.Refactored_Code.services.UserRepository;

public class MongoUserRepository implements UserRepository {
    private final Map<String, String> users = new HashMap<>();

    @Override
    public void save(String id, String name) {
        users.put(id, name);
        System.out.println("[Mongo] Saved user " + id);
    }

    @Override
    public String findNameById(String id) {
        System.out.println("[Mongo] Fetching user " + id);
        return users.get(id);
    }
}
