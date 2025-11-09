package finans_OOP.options;

import finans_OOP.Application;
import finans_OOP.data.User;
import finans_OOP.data.Input;
import finans_OOP.menus.LoginMenu;
import finans_OOP.menus.MainMenu;

import java.io.IOException;

public class LoginOption extends Option{
  public LoginOption(Application application) {
    super("Login", 1, application);
  }

  @Override
  public void run(String[] parsedInput) throws IOException {
    String username = Input.getString();
    if (!validUser(username)) {
      application.setMenu(new LoginMenu(application));
      return;
    }
    application.setUser(new User(username));

    application.setMenu(new MainMenu(application));
  }

  boolean validUser(String username) {
    char[] invalidChars = {'\\', '/', ':', '*', '?', '"', '<', '>', '|', ' '};
    for (int i = 0; i < username.length(); i++)
      for (char c : invalidChars)
        if (username.charAt(i) == c) {
          System.out.println("Invalid character used: '" + c + "'");
          return false;
        }
    return true;
  }
}
