package finans_OOP.data;

import java.time.LocalDateTime;

public class Transaction {
  private final LocalDateTime timeStamp;
  private final int amount;

  public Transaction(int amount) {
    this.timeStamp = LocalDateTime.now();
    this.amount = amount;
  }

  public Transaction(int amount, LocalDateTime date) {
    this.timeStamp = date;
    this.amount = amount;
  }

  public LocalDateTime getTimeStamp() { return timeStamp; }
  public int getAmount() { return amount; }
}
