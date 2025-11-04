package finans_OOP;

import finans_OOP.menu.LoginMenu;
import finans_OOP.menu.Menu;

import java.io.IOException;

public class Application {

  private static boolean running = true;
  private static Menu menu;

  public static void main(String[] args) throws IOException {

    menu = new LoginMenu();

    while (running) {
      menu.write();
    }
  }

  public static void setMenu(Menu newMenu) {
    menu = newMenu;
  }

  public static void stopRunning() {
    running = false;
  }
}