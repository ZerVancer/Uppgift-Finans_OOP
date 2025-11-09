package finans_OOP.options;

import finans_OOP.Application;

public class BalanceOption extends Option {
  public BalanceOption(Application application) {
    super("Balance", 1, application);
  }

  @Override
  public void run(String[] parsedInput) {
    System.out.println("Balance: " + application.getUser().getWallet().getBalance());
  }
}
