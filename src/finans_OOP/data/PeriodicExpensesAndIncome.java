package finans_OOP.data;

public class PeriodicExpensesAndIncome {
  private int year;
  private int period;
  private int amount;

  public PeriodicExpensesAndIncome(int year, int period, int amount) {
    this.year = year;
    this.period = period;
    this.amount = amount;
  }

  public PeriodicExpensesAndIncome(int year, int amount) {
    this.year = year;
    this.amount = amount;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public void setPeriod(int period) {
    this.period = period;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getYear() { return year; }
  public int getPeriod() { return period; }
  public int getAmount() { return amount; }
}
