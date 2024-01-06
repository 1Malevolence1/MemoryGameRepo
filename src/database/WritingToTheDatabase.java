package database;

import account.Account;
import dictionary.DictionaryDesigner;
import dictionary.DictionaryWord;

import java.sql.*;

// класс для заполнения таблицы
public class WritingToTheDatabase extends DataBase{
    private DictionaryWord dictionaryWord;
    private Account account;
    public WritingToTheDatabase() {
    }

    public WritingToTheDatabase(Account account) {
        this.account = account;
    }

    public WritingToTheDatabase(DictionaryWord dictionaryWord, Account account){
        this.dictionaryWord = dictionaryWord;
        this.account = account;
    }

    private final static String UPDATE_ARRAY_WORD = "UPDATE accounts SET words = ? WHERE name_account = ?";
    private final static String S_ENTERING_DATA = "INSERT INTO accounts (name_account, password_account, words) VALUES (?,?, ARRAY[]::text[])";

    // заполнение таблицы(имя пользователя, аккацнт, его слова)
    public void ingressesAccountDatabase() throws SQLException {
        try(Connection connection = getConnection();
            PreparedStatement stmt = connection.prepareStatement(S_ENTERING_DATA)) {
            stmt.setString(1, account.getLogin());
            stmt.setString(2, account.getPassword());
            stmt.executeUpdate();
            }
        }
        // обновление слов пользователя
        public void updateArrayWordsDataBase() throws SQLException {
            try(Connection connection = getConnection();
                PreparedStatement stmt = connection.prepareStatement(UPDATE_ARRAY_WORD)) {
                Array arrayWords = connection.createArrayOf("text",
                        DictionaryDesigner.transferringWordsFromDictionaryArray(
                                dictionaryWord.getDictionary())
                );

                stmt.setArray(1,arrayWords);
                stmt.setString(2, account.getLogin());
                stmt.executeUpdate();

            }
        }

    }




