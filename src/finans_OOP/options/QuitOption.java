package finans_OOP.options;

import finans_OOP.Application;

import java.io.IOException;

public class QuitOption extends Option {
  public QuitOption() {
    super("Quit");
  }

  @Override
  public void run() throws IOException {
    Application.stopRunning();
  }
}
