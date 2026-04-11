package P4_Design_Patterns.P2_Behavioral.P3_Chain_Of_Responsibility.E1_Expense_Approval_System.Refactored_Code.services.impl;

import P4_Design_Patterns.P2_Behavioral.P3_Chain_Of_Responsibility.E1_Expense_Approval_System.Refactored_Code.models.ExpenseRequest;
import P4_Design_Patterns.P2_Behavioral.P3_Chain_Of_Responsibility.E1_Expense_Approval_System.Refactored_Code.services.ExpenseHandler;

public class DirectorExpenseHandler extends ExpenseHandler {
    private static final double LIMIT = 100000;

    @Override
    protected boolean canHandle(ExpenseRequest request) {
        return request.getAmount() <= LIMIT;
    }

    @Override
    protected void handle(ExpenseRequest request) {
        System.out.println("Approved by Director");
    }
}
