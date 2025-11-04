package finans_OOP.options;

import finans_OOP.Application;
import finans_OOP.UserData;
import finans_OOP.data.Input;
import finans_OOP.menu.MainMenu;

import java.io.IOException;

public class LoginOption extends Option{
  public LoginOption(String name) {
    super(name);
  }

  @Override
  public void run() throws IOException {
    String username;
    while (true) {
      username = Input.getString();
      if (!validUser(username)) continue;
      break;
    }
    UserData.initialiseUser(username);
    UserData.setWallet(username);

    Application.setMenu(new MainMenu());
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
