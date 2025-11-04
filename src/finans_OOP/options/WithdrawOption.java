package finans_OOP.options;

import java.io.IOException;

public class WithdrawOption extends Option {
  public WithdrawOption() {
    super("Withdraw");
  }

  @Override
  public void run(){
    DepositWithdrawHelper.run(false);
  }
}
