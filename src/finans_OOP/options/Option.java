package finans_OOP.options;

import java.io.IOException;

public abstract class Option {
  private String name;

  public Option(String name) {
    this.name = name;
  }

  public abstract void run() throws IOException;

  public String getName() {
    return name;
  }
}
