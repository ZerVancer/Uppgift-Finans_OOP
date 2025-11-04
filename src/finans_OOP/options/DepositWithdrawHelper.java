package finans_OOP.options;

import finans_OOP.UserData;
import finans_OOP.data.Input;


public abstract class DepositWithdrawHelper {
  public static void run(Boolean deposit) {
    while (true) {
      System.out.println("Type return to return to the main menu");
      System.out.println("Amount: ");
      String input = Input.getString();
      if (input.equalsIgnoreCase("return")) return;
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
}
