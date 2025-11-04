package finans_OOP.options;

public class ExpensesOption extends Option {
  public ExpensesOption() {
    super("Expenses");
  }

  @Override
  public void run() {
    IncomeExpensesHelper.run(false);
  }
}
