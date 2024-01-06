package account;

import dictionary.DictionaryWord;

import java.util.Set;

public class AccountValidator {
    private DictionaryWord dictionaryWord;
    private Account account;
    private AccountManager accountManager;

    public AccountValidator() {
    }

    public AccountValidator(DictionaryWord dictionaryWord, Account account, AccountManager accountManager) {
        this.dictionaryWord = dictionaryWord;
        this.account = account;
        this.accountManager = accountManager;
    }
    public boolean checkUserAnswer(String answer, int key){
        return answer.equals(dictionaryWord.getWordDictionary(key));
    }

    public void checkAccountPassword(String string, String password) {
        while (true) {
            if (string.equals(password)) {
                System.out.println("Пароль верный");
                System.out.println("Добро пожаловать, " + account.getLogin());
                break;
            } else {
                System.out.println("Пароль неверный. Попробуйте ещё раз");
                accountManager.userSayPasswordAccount();
                string = account.getPassword();
            }
        }
    }

    public void checkAccountExists(Set<String> list, String string){
        while (true) {
            if (!list.contains(string)) {
                System.out.println("Такой профиль не найден");
                accountManager.userSayNameAccount();
                string = account.getLogin();
            }
            else {
                System.out.println("Профиль найден");
                break;
            }
        }
    }


    public void checkAccountExists(String string, Set<String> list) {

        while (true) {
            if (list.contains(string)) {
                System.out.println("Такой профиль уже есть. Придумайте новый");
                accountManager.userSayNameAccount();
                string = account.getLogin();
            }
            else{
                break;
            }
        }
    }

}
