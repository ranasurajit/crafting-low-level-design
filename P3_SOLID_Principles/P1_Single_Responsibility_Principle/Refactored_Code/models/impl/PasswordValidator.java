package P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.models.impl;

import P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.models.IValidator;

public class PasswordValidator implements IValidator {
    @Override
    public boolean isValid(String input) {
        return !(input == null || input.length() < 6);
    }
}
