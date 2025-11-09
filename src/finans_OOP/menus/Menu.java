package finans_OOP.menus;

import finans_OOP.Application;
import finans_OOP.options.Option;

import java.io.IOException;
import java.util.Arrays;

public abstract class Menu {
  private Option[] options;
  protected Application application;

  protected Menu(Application application) {
    this.application = application;
  }

  public void setOptions(Option[] options) {
    this.options = options;
  }

  public abstract void write() throws IOException;

  public void runOption(String input) throws IOException {
    String[] parsedInput = input.split(" ");
    Option option = Arrays.stream(options).filter((o) -> o.getName().equalsIgnoreCase(parsedInput[0])).findFirst().orElse(null);
    if (option != null && parsedInput.length == option.getNumberOfCommands()) {
        option.run(parsedInput);
        return;
    }
    System.out.println("Invalid option, try again");
  }
}
