package finans_OOP.menu;

import finans_OOP.options.LoginOption;
import finans_OOP.options.Option;

import java.io.IOException;

public class LoginMenu extends Menu {

  public void write() throws IOException {
    Option[] options = {new LoginOption("login")};
    setOptions(options);

    System.out.print("Type username: ");

    runOption("Login");
  }
}
