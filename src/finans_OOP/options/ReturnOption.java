package finans_OOP.options;

import finans_OOP.Application;
import finans_OOP.menus.MainMenu;

import java.io.IOException;

public class ReturnOption extends Option {
  public ReturnOption(Application application) {
    super("Return", 1, application);
  }

  @Override
  public void run(String[] parsedInput) throws IOException {
    application.setMenu(new MainMenu(application));
  }
}
