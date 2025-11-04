package finans_OOP.menu;

import finans_OOP.data.Input;
import finans_OOP.options.*;

import java.io.IOException;

public class MainMenu extends Menu {

  public void write() throws IOException {

    Option[] options = {
        new BalanceOption(),
        new DepositOption(),
        new WithdrawOption(),
        new IncomeOption(),
        new ExpensesOption(),
        new QuitOption()
    };
    setOptions(options);

    System.out.println("--- Menu ---");
    for (Option option : options) {
      System.out.println(option.getName());
    }
    Option option = runOption(Input.getString());
    if (option == null) System.out.println("Invalid option, try again");
  }
}
