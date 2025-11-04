package finans_OOP.options;

public class IncomeOption extends Option {
  public IncomeOption() {
    super("Income");
  }

  @Override
  public void run() {
    IncomeExpensesHelper.run(true);
  }
}
