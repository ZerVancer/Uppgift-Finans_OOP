package finans_OOP.options;

import finans_OOP.Period;
import finans_OOP.UserData;
import finans_OOP.data.Input;
import finans_OOP.data.PeriodicExpensesAndIncome;

import java.util.ArrayList;

public class IncomeExpensesHelper {
  private static Period period;

  static void run(boolean income) {
    System.out.println("Type return to return to the main menu");
    System.out.println("Pick a period: ");
    System.out.println("Year");
    System.out.println("Month");
    System.out.println("Week");
    System.out.println("Day");
    String input = Input.getString().toLowerCase();
    if (input.equalsIgnoreCase("return")) return;
    while (true) {
      period = switch (input) {
        case "year" -> Period.YEARLY;
        case "month" -> Period.MONTHLY;
        case "week" -> Period.WEEKLY;
        case "day" -> Period.DAILY;
        default -> null;
      };
      if (period == null) {
        System.out.println("Invalid input, try again");
        continue;
      }

      ArrayList<PeriodicExpensesAndIncome> list = UserData.wallet.getIncomeOrExpenses(period, income);
      printIncomeExpenses(list);

      break;
    }
  }

  static void printIncomeExpenses(ArrayList<PeriodicExpensesAndIncome> list) {
    if (period == Period.YEARLY) {
      System.out.println("Year | Amount");
      for (PeriodicExpensesAndIncome pei : list) {
        System.out.println(pei.getYear() + " | " + pei.getAmount());
      }
    } else {
      System.out.println("Year | " + period.toString() + " | Amount");
      for (PeriodicExpensesAndIncome pei : list) {
        System.out.println(pei.getYear() + " | " + pei.getPeriod() + " | " + pei.getAmount());
      }
    }
  }
}
