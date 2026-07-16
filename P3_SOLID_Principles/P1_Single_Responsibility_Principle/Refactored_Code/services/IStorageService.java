package P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.services;

public interface IStorageService {
    public void save(String username, String email, String hashed);
}
