package database;

import account.Account;

import java.sql.*;
import java.util.*;

public class InteractionWithTheDatabase extends DataBase {
    private Account account;
    private static final String REQUESTING_ACCOUNTS = "SELECT name_account FROM accounts";

    private static final String REQUESTING_ARRAY_WORDS = "SELECT words FROM accounts WHERE name_account = ?";
    private static final String REQUESTING_ACCOUNTS_PASSWORD = "SELECT password_account FROM accounts WHERE name_account = ?";
    public InteractionWithTheDatabase(Account account) {
        this.account = account;
    }

    public InteractionWithTheDatabase() {
    }

    public List<String> requestForAccountLists() throws SQLException {
        List list = new ArrayList();
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(REQUESTING_ACCOUNTS)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) list.add(rs.getString("name_account"));
        }
        return list;
    }

    public List<String> requestForWordLists() throws SQLException {
        List<String> wordList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(REQUESTING_ARRAY_WORDS)) {
            stmt.setString(1, account.getLogin());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Array id = rs.getArray(1);
                String[] arrayWord = (String[]) id.getArray();
                wordList.addAll(Arrays.asList(arrayWord));
            }
            return wordList;
        }
    }

    public  String requestForAccountPassword() throws SQLException {
        String password = null;
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(REQUESTING_ACCOUNTS_PASSWORD)) {
            stmt.setString(1, account.getLogin());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) password = rs.getString("password_account");
        }
        return password;
    }
}
