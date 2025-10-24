package finans_OOP;

import finans_OOP.data.Transaction;
import finans_OOP.data.Wallet;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserData {

  public static Wallet wallet;

  public static void setWallet(String username) {
    wallet = UserData.readUser(username);
  }

  private static File getFilePath(String username) {
    return new File("src\\main\\java\\com\\leo\\individuell_javafx\\users\\"+username+".txt");
  }

  public static void initialiseUser(String username) throws IOException {
    if (!getFilePath(username).exists()) {
      createUser(username);
    }
  }

  private static void createUser(String username) throws IOException {
    FileWriter writer;
    writer = new FileWriter(getFilePath(username));
    writer.write(username + "\n" + 0);
    writer.close();
  }

  public static Wallet readUser(String username) {
    Wallet wallet = null;
    FileReader reader;
    try {
      reader = new FileReader(getFilePath(username));
      BufferedReader bufferedReader = new BufferedReader(reader);
      wallet = new Wallet(bufferedReader.readLine(), Integer.parseInt(bufferedReader.readLine()));
      String transactionString;
      ArrayList<Transaction> transactions = new ArrayList<>();
      while ((transactionString = bufferedReader.readLine()) != null) {
        String[] transactionSplit = transactionString.split("\\s");
        Transaction transaction = new Transaction(Integer.parseInt(transactionSplit[1]), LocalDateTime.parse(transactionSplit[0]));
        transactions.add(transaction);
      }
      wallet.setTransactions(transactions);
    } catch (IOException e) {
      System.out.println("Missing file");
    }
    return wallet;
  }

  // Very inefficient with more transactions
  public static void addTransaction(Transaction transaction, String username) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(getFilePath(username), false));

      writer.write(UserData.wallet.getName());
      int result = UserData.wallet.getBalance()+transaction.getAmount();
      writer.write("\n"+result);
      for (Transaction t : UserData.wallet.getTransactions()) {
        writer.write("\n"+t.getTimeStamp().toString()+" "+t.getAmount());
      }

      writer.close();
    } catch (IOException e) {
      System.out.println("Missing file");
    }
  }

}
