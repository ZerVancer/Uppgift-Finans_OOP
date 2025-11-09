package finans_OOP.data;

import java.io.*;

public class User {

  private final String username;
  private final Wallet wallet;
  private final UserFileReader ufr = new UserFileReader();

  public User(String username) throws IOException {
    this.username = username;
    this.wallet = ufr.getUser(username).getWallet();
  }

  public User(String username, Wallet wallet) {
    this.username = username;
    this.wallet = wallet;
  }

  public void addTransaction(int amount, int signifier) {
    ufr.createTransaction(this, amount*signifier);
  }

  public Wallet getWallet() {
    return wallet;
  }
  public String getUsername() {
    return username;
  }
}
