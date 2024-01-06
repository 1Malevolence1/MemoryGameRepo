package account;

import game.User;

public class AccountManager {
    private Account account;
    private User user;


    public AccountManager() {
    }

    public AccountManager(Account account, User user) {
        this.account = account;
        this.user = user;
    }

    public void userSayNameAccount(){
        System.out.println("Ввидите имя профиля: ");
        account.setLogin(user.sayAccount());
    }

    public void userSayNameNewAccount(){
        System.out.println("Придумайте имя профиля: ");
        account.setLogin(user.sayAccount());
    }

    public void userSayPasswordAccount(){
        System.out.println("Ввидите пароль: ");
        account.setPassword(user.sayAccount());
    }

    public void userSayPasswordNewAccount(){
        System.out.println("Придумайте пароль: ");
        account.setPassword(user.sayAccount());
    }

    public void accountCreated(){
        System.out.println("Аккаунт создан");
    }
}
