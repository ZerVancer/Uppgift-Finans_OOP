package finans_OOP.data;

import finans_OOP.Period;
import finans_OOP.UserData;

import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Wallet {
  private int balance;
  private final String name;
  private ArrayList<Transaction> transactions = new ArrayList<>();

  public Wallet(String name) {
    this.balance = 0;
    this.name = name;
  }

  public Wallet(String name, int balance) {
    this(name);
    this.balance = balance;
  }

  public void createTransaction(int amount, int signifier) {
    int result = amount*signifier;
    addTransaction(new Transaction(result));
    balance += result;
  }

  public void addTransaction(Transaction transaction) {
    transactions.add(transaction);
    UserData.addTransaction(transaction, name);
  }

  // Very convoluted
  public List<PeriodicExpensesAndIncome> getIncomeOrExpenses(Period period, boolean positive) {
    List<PeriodicExpensesAndIncome> result = new ArrayList<>();
    if (transactions.isEmpty()) return result;
    PeriodicExpensesAndIncome pei;
    int time = getTransactionPeriod(transactions.getFirst(), period);
    int total = 0;
    int year = -1;

    for (Transaction transaction : getTransactions()) {
      int amount = transaction.getAmount();
      year = transaction.getTimeStamp().getYear();
      if (amount > 0 && positive || amount < 0 && !positive) {
        if (getTransactionPeriod(transaction, period) == time && transaction.getTimeStamp().getYear() == year) {
          total += transaction.getAmount();
        } else {
          pei = new PeriodicExpensesAndIncome(year, total);
          if (period != Period.YEARLY) {
            pei.setPeriod(time);
          }
          result.add(pei);
          time = getTransactionPeriod(transaction, period);
          total = amount;
        }
      }
    }
    pei = new PeriodicExpensesAndIncome(year, total);
    if (period != Period.YEARLY) {
      pei.setPeriod(time);
    }
    result.add(pei);
    return result;
  }

  private int getTransactionPeriod(Transaction transaction, Period period) {
    return switch (period) {
      case YEARLY -> transaction.getTimeStamp().getYear();
      case MONTHLY -> transaction.getTimeStamp().getMonthValue();
      case WEEKLY -> {
        TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear();
        yield transaction.getTimeStamp().get(woy);
      }
      case DAILY -> transaction.getTimeStamp().getDayOfYear();
    };
  }

  public void setTransactions(ArrayList<Transaction> transactions) {
    this.transactions = transactions;
  }

  public int getBalance() { return balance; }
  public String getName() { return name; }
  public ArrayList<Transaction> getTransactions() { return new ArrayList<>(transactions); }
}
