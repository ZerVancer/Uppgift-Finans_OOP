package finans_OOP.options;

import finans_OOP.Application;

import java.io.IOException;

public class QuitOption extends Option {
  public QuitOption(Application application) {
    super("Quit", 1, application);
  }

  @Override
  public void run(String[] parsedInput) throws IOException {
    application.stopRunning();
    System.out.println("System has stopped running");
  }
}
