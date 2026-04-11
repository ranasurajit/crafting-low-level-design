package P4_Design_Patterns.P2_Behavioral.P3_Chain_Of_Responsibility.E1_Expense_Approval_System.Refactored_Code.services;

import P4_Design_Patterns.P2_Behavioral.P3_Chain_Of_Responsibility.E1_Expense_Approval_System.Refactored_Code.models.ExpenseRequest;

public abstract class ExpenseHandler {
    protected ExpenseHandler nextHandler;

    public void setNextHandler(ExpenseHandler next) {
        this.nextHandler = next;
    }

    public void approveExpense(ExpenseRequest request) {
        if (canHandle(request)) {
            handle(request);
        } else {
            if (nextHandler != null) {
                nextHandler.approveExpense(request);
            } else {
                throw new IllegalArgumentException("No handler found for this request");
            }
        }
    }

    protected abstract boolean canHandle(ExpenseRequest request);

    protected abstract void handle(ExpenseRequest request);
}
