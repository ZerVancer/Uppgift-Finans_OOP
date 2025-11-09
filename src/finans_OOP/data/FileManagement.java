package finans_OOP.data;

import java.io.IOException;

public interface FileManagement {

  User getUser(String username) throws IOException;
  User readFile(String username);
  void addTransaction(User user);

}
