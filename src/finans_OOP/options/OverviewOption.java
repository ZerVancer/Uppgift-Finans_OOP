package finans_OOP.options;

import finans_OOP.Application;
import finans_OOP.menus.OverviewMenu;

import java.io.IOException;

public class OverviewOption extends Option {
  public OverviewOption(Application application) {
    super("Overview", 1, application);
  }

  @Override
  public void run(String[] parsedInput) throws IOException {
    application.setMenu(new OverviewMenu(application));
  }
}
