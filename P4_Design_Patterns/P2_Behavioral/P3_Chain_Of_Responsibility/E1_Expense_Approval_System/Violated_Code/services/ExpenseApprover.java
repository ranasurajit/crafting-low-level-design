package P4_Design_Patterns.P2_Behavioral.P3_Chain_Of_Responsibility.E1_Expense_Approval_System.Violated_Code.services;

import P4_Design_Patterns.P2_Behavioral.P3_Chain_Of_Responsibility.E1_Expense_Approval_System.Violated_Code.models.ExpenseRequest;

public class ExpenseApprover {
    public void approveExpense(ExpenseRequest request) {
        double amount = request.getAmount();
        if (amount <= 1000) {
            System.out.println("Approved by Team Lead");
        } else if (amount <= 10000) {
            System.out.println("Approved by Manager");
        } else if (amount > 10000) {
            System.out.println("Approved by Director");
        } else {
            System.out.println("Request cannot be handled");
        }
    }
}
