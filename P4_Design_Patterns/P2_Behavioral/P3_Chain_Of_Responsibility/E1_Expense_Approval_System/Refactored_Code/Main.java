package P4_Design_Patterns.P2_Behavioral.P3_Chain_Of_Responsibility.E1_Expense_Approval_System.Refactored_Code;

import P4_Design_Patterns.P2_Behavioral.P3_Chain_Of_Responsibility.E1_Expense_Approval_System.Refactored_Code.models.ExpenseRequest;
import P4_Design_Patterns.P2_Behavioral.P3_Chain_Of_Responsibility.E1_Expense_Approval_System.Refactored_Code.services.ExpenseHandler;
import P4_Design_Patterns.P2_Behavioral.P3_Chain_Of_Responsibility.E1_Expense_Approval_System.Refactored_Code.services.impl.DirectorExpenseHandler;
import P4_Design_Patterns.P2_Behavioral.P3_Chain_Of_Responsibility.E1_Expense_Approval_System.Refactored_Code.services.impl.ManagerExpenseHandler;
import P4_Design_Patterns.P2_Behavioral.P3_Chain_Of_Responsibility.E1_Expense_Approval_System.Refactored_Code.services.impl.TeamLeadExpenseHandler;

public class Main {
    public static void main(String[] args) {
        ExpenseHandler approver = new TeamLeadExpenseHandler();
        ExpenseHandler manager = new ManagerExpenseHandler();
        ExpenseHandler director = new DirectorExpenseHandler();
        approver.setNextHandler(manager);
        manager.setNextHandler(director);

        ExpenseRequest r1 = new ExpenseRequest(500);
        ExpenseRequest r2 = new ExpenseRequest(5000);
        ExpenseRequest r3 = new ExpenseRequest(20000);

        approver.approveExpense(r1);
        approver.approveExpense(r2);
        approver.approveExpense(r3);
    }
}
