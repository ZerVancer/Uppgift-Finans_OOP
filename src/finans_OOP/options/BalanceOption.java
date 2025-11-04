package finans_OOP.options;

import finans_OOP.UserData;

import java.io.IOException;

public class BalanceOption extends Option {
  public BalanceOption() {
    super("Balance");
  }

  @Override
  public void run(){
    System.out.println("Balance: " + UserData.wallet.getBalance());
  }
}
