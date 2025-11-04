package finans_OOP.data;

import java.util.Scanner;

public class Input {
  static Scanner scanner = new Scanner(System.in);

  public static String getString() {
    return scanner.nextLine();
  }

  public static int getInt() {
    return scanner.nextInt();
  }
}
