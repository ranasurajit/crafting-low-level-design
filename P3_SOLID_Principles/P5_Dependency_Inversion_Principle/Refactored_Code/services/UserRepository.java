package P3_SOLID_Principles.P5_Dependency_Inversion_Principle.Refactored_Code.services;

public interface UserRepository {
    void save(String id, String name);

    String findNameById(String id);
}
