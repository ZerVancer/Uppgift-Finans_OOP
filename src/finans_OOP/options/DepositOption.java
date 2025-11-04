package finans_OOP.options;

import java.io.IOException;

public class DepositOption extends Option {
  public DepositOption() {
    super("Deposit");
  }

  @Override
  public void run(){
    DepositWithdrawHelper.run(true);
  }
}
