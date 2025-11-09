package finans_OOP.menus;

import finans_OOP.Application;
import finans_OOP.options.LoginOption;
import finans_OOP.options.Option;
import finans_OOP.options.QuitOption;

import java.io.IOException;

public class LoginMenu extends Menu {
  Option[] options = {
      new LoginOption(application)
  };

  public LoginMenu(Application application) {
    super(application);
    setOptions(options);
  }

  public void write() throws IOException {
    System.out.print("Type username: ");

    runOption("Login");
  }
}
