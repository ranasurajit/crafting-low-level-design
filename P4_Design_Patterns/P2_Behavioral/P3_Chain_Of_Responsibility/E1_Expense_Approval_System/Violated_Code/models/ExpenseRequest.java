package P4_Design_Patterns.P2_Behavioral.P3_Chain_Of_Responsibility.E1_Expense_Approval_System.Violated_Code.models;

public class ExpenseRequest {
    private double amount;

    public ExpenseRequest(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
