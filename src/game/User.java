package game;

import account.Account;

import java.util.List;
import java.util.Scanner;

public class User {


    private List<String> ArrayWordsAccountBaseData;
    private Scanner scanner;

    private Account account;

    private int id;

    public User() {
        scanner = new Scanner(System.in);
        account = new Account();
    }

    public User(Account account) {
        scanner = new Scanner(System.in);
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public String sayWord(){
        return scanner.nextLine();
   }

    public String sayAccount(){
        return scanner.nextLine();
   }

   public String say(){
        return scanner.nextLine();
   }

    public List<String> getArrayWordsAccountBaseData() {
        return ArrayWordsAccountBaseData;
    }

    public void setArrayWordsAccountBaseData(List<String> arrayWordsAccountBaseData) {
        ArrayWordsAccountBaseData = arrayWordsAccountBaseData;
    }

}
