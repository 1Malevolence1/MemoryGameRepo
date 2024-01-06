package game;

import account.*;
import database.AccountBaseData;
import database.InteractionWithTheDatabase;
import database.WorkingWithTheReceivedDatabase;
import database.WritingToTheDatabase;
import dictionary.DictionaryDesigner;
import dictionary.DictionaryWord;
import java.sql.SQLException;

public class Game {

    private AccountManager accountManager;
    private Account account;
    private AccountBaseData accountBaseData;
    private User user;
    private DictionaryWord dictionaryWord;

    private WritingToTheDatabase writingToTheDatabase;

    private Point point;

    private WorkingWithTheReceivedDatabase workingWithTheReceivedDatabase;

    private InteractionWithTheDatabase interactionWithTheDatabase;

    private AccountValidator accountValidator;

    private DictionaryDesigner dictionaryDesigner;

    public Game() throws SQLException {
        accountBaseData = new AccountBaseData();
        dictionaryWord = new DictionaryWord();
        account = new Account();
        point = new Point();

        user = new User(account);
        accountManager = new AccountManager(account, user);
        accountValidator = new AccountValidator(dictionaryWord,account,accountManager);
        interactionWithTheDatabase = new InteractionWithTheDatabase(account);
        workingWithTheReceivedDatabase = new WorkingWithTheReceivedDatabase(accountBaseData, interactionWithTheDatabase);
        dictionaryDesigner = new DictionaryDesigner(dictionaryWord, user);
        writingToTheDatabase = new WritingToTheDatabase(dictionaryWord, account);

        game();
    }



    public void game() throws SQLException {
        Text.textChoosingAccountActions();
        createAccountOrEnterAccount();
        Text.textInfoActions();
        accountActions();
    }
    public void play(){
        Text.textRules();
        guessingWords();
        point.printResultPoint();
    }

    private void createAccountOrEnterAccount() throws SQLException {
        workingWithTheReceivedDatabase.sqlAccountName();
        switch (user.say()){
            case "1":{
                accountManager.userSayNameAccount();
                accountValidator.checkAccountExists(accountBaseData.getList(), account.getLogin());
                accountManager.userSayPasswordAccount();
                accountValidator.checkAccountPassword(account.getPassword(),WorkingWithTheReceivedDatabase.getPasswordAccountDataBae(interactionWithTheDatabase.requestForAccountPassword()));
                break;
            }
            case  "2":{
                accountManager.userSayNameNewAccount();
                accountValidator.checkAccountExists(account.getLogin(), accountBaseData.getList());
                accountManager.userSayPasswordNewAccount();
                accountManager.accountCreated();
                writingToTheDatabase.ingressesAccountDatabase();
                break;
            }
        }
    }
    private void accountActions() throws SQLException {
        switch (user.say()) {
            case "1": {
                dictionaryWord.setDictionary(dictionaryDesigner.fillingDictionary());
                writingToTheDatabase.updateArrayWordsDataBase();
                System.out.println("Слова обновлены");
                Text.textInfoActions();
                accountActions();
                break;
            }

            case "2":
                dictionaryWord.setDictionary(WorkingWithTheReceivedDatabase.gettingDictionaryFromList(
                        interactionWithTheDatabase.requestForWordLists()));

                if(dictionaryWord.getDictionary().isEmpty()) {
                    System.out.println("Список слов пуст. Придумайте для начала слова, чтобы начать игру");
                    Text.textInfoActions();
                    accountActions();
                    break;
                }
                else {
                    play();
                    break;
                }
            case "3": {
                dictionaryWord.setDictionary(WorkingWithTheReceivedDatabase.gettingDictionaryFromList(
                        interactionWithTheDatabase.requestForWordLists()));
                dictionaryDesigner.printKyeAndWordsDictionary(dictionaryWord.getDictionary());
                System.out.println();
                Text.textInfoActions();
                accountActions();
                break;
            }
        }
    }

    // Логика самой игры
    private void guessingWords() {
        String stop = "";
        while (!stop.equals("Стоп")){
            int key = dictionaryWord.randomKeyDictionary(dictionaryWord.getDictionary());
            System.out.println("Какое слово находится под номером: " + key);
            stop = user.say();
            point.addingPoints(accountValidator.checkUserAnswer(stop, key));
        }
    }




}
