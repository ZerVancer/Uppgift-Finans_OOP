package finans_OOP.menu;

import finans_OOP.options.Option;

import java.io.IOException;

public abstract class Menu {
  private Option[] options;

  protected Menu() {}

  public void setOptions(Option[] options) {
    this.options = options;
  }

  public void write() throws IOException {}

  public Option runOption(String input) throws IOException {
    for (Option option : options) {
      if (option.getName().equalsIgnoreCase(input)) {
        option.run();
        return option;
      }
    }
    return null;
  }
}
