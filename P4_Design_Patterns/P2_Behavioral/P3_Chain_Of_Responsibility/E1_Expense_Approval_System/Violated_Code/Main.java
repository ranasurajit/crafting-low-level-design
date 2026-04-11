package P4_Design_Patterns.P2_Behavioral.P3_Chain_Of_Responsibility.E1_Expense_Approval_System.Violated_Code;

import P4_Design_Patterns.P2_Behavioral.P3_Chain_Of_Responsibility.E1_Expense_Approval_System.Violated_Code.models.ExpenseRequest;
import P4_Design_Patterns.P2_Behavioral.P3_Chain_Of_Responsibility.E1_Expense_Approval_System.Violated_Code.services.ExpenseApprover;

public class Main {
    public static void main(String[] args) {
        ExpenseApprover approver = new ExpenseApprover();

        ExpenseRequest r1 = new ExpenseRequest(500);
        ExpenseRequest r2 = new ExpenseRequest(5000);
        ExpenseRequest r3 = new ExpenseRequest(20000);

        approver.approveExpense(r1);
        approver.approveExpense(r2);
        approver.approveExpense(r3);
    }
}
