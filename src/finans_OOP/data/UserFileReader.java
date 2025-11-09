package finans_OOP.data;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserFileReader implements FileManagement {

  private File getFilePath(String username) {
    return new File("src\\finans_OOP\\users\\"+username+".txt");
  }

  private void createUser(String username) throws IOException {
    FileWriter writer;
    writer = new FileWriter(getFilePath(username));
    writer.write(username + "\n" + 0);
    writer.close();
  }

  @Override
  public User getUser(String username) throws IOException {
    if (!userExist(username)) {
      createUser(username);
      return new User(username, new Wallet());
    }
    return readFile(username);
  }

  @Override
  public User readFile(String username) {
    Wallet wallet = null;
    FileReader reader;
    try {
      reader = new FileReader(getFilePath(username));
      BufferedReader bufferedReader = new BufferedReader(reader);
      bufferedReader.readLine();
      wallet = new Wallet(Integer.parseInt(bufferedReader.readLine()));
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
    return new User(username, wallet);
  }

  @Override
  public void createTransaction(User user, int result) {
    Transaction transaction = new Transaction(result);
    user.getWallet().addToBalance(result);
    user.getWallet().addTransaction(transaction);
    addTransaction(user, transaction);
  }

  // Very inefficient with more transactions
  @Override
  public void addTransaction(User user, Transaction transaction) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(getFilePath(user.getUsername()), false));

      writer.write(user.getUsername());
      int result = user.getWallet().getBalance()+transaction.getAmount();
      writer.write("\n"+result);
      for (Transaction t : user.getWallet().getTransactions()) {
        writer.write("\n"+t.getTimeStamp().toString()+" "+t.getAmount());
      }

      writer.close();
      user.getWallet().addTransaction(transaction);
    } catch (IOException e) {
      System.out.println("Missing file");
    }
  }

  private boolean userExist(String username) {
    return getFilePath(username).exists();
  }

}
