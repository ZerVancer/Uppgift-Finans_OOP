package finans_OOP;

import finans_OOP.data.Input;
import finans_OOP.data.User;
import finans_OOP.menus.LoginMenu;
import finans_OOP.menus.Menu;

import java.io.IOException;

public class Application {

  private boolean running = true;
  private Menu menu;
  private User user;

  public void main(String[] args) throws IOException {
    Application application = new Application();

    application.setMenu(new LoginMenu(application));

    while (application.running) {
      String input = Input.getString();
      application.menu.runOption(input);
    }
  }

  public void setMenu(Menu menu) throws IOException {
    this.menu = menu;
    this.menu.write();
  }

  public void stopRunning() {
    running = false;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }
}