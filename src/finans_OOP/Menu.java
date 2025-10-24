package finans_OOP;

import finans_OOP.data.PeriodicExpensesAndIncome;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
  private static boolean running = true;
  private static Scanner scanner = new Scanner(System.in);
  private static Period period;

  public static void setRunning() {
    running = true;
  }

  public static void stopRunning() {
    running = false;
  }

  static void run() throws IOException {
    login();
    while (running) {
      mainMenu();
    }
  }

  static void mainMenu() {
    System.out.println("--- Menu ---");
    System.out.println("Balance");
    System.out.println("Deposit");
    System.out.println("Withdraw");
    System.out.println("Income");
    System.out.println("Expenses");
    System.out.println("Quit");
    String input = scanner.nextLine();
    switch (input.toLowerCase()) {
      case "balance":
        System.out.println("Balance: " + UserData.wallet.getBalance());
        break;
      case "deposit":
        depositWithdraw(true);
        break;
      case "withdraw":
        depositWithdraw(false);
        break;
      case "income":
        incomeExpenses(true);
        break;
      case "expenses":
        incomeExpenses(false);
        break;
      case "quit":
        stopRunning();
        break;
      default:
        System.out.println("Invalid input, try again");
    }
  }

  static void login() throws IOException {
    String username;
    while (true) {
      System.out.print("Type username: ");
      username = scanner.nextLine();
      if (!validUser(username)) continue;
      break;
    }
    UserData.initialiseUser(username);
    UserData.setWallet(username);
  }

  static boolean validUser(String username) {
    char[] invalidChars = {'\\', '/', ':', '*', '?', '"', '<', '>', '|', ' '};
    for (int i = 0; i < username.length(); i++)
      for (char c : invalidChars)
        if (username.charAt(i) == c) {
          System.out.println("Invalid character used: '" + c + "'");
          return false;
        }
    return true;
  }

  static void depositWithdraw(Boolean deposit) {
    while (true) {
      System.out.println("Type quit to exit");
      System.out.println("Amount: ");
      String input = scanner.nextLine();
      if (input.equalsIgnoreCase("quit")) return;
      try {
        int amount = Integer.parseInt(input);
        if (amount > 0) {
          if (deposit) {
            UserData.wallet.createTransaction(amount, 1);
            System.out.println("Deposited: " + amount);
          }
          else {
            UserData.wallet.createTransaction(amount, -1);
            System.out.println("Withdrawn " + amount);
          }
          break;
        } else {
          System.out.println("Must be more than zero, try again");
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input, try again.");
      }
    }
  }

  static void incomeExpenses(boolean income) {
    System.out.println("Pick a period: ");
    System.out.println("Year");
    System.out.println("Month");
    System.out.println("Week");
    System.out.println("Day");
    while (true) {
      switch (scanner.nextLine().toLowerCase()) {
        case "year" -> period = Period.YEARLY;
        case "month" -> period = Period.MONTHLY;
        case "week" -> period = Period.WEEKLY;
        case "day" -> period = Period.DAILY;
      }
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
