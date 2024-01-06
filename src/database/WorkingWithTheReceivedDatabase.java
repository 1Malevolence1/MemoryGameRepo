package database;

import java.sql.SQLException;
import java.util.*;

public class WorkingWithTheReceivedDatabase {

    private AccountBaseData accountBaseData;

    private InteractionWithTheDatabase interactionWithTheDatabase;

    public WorkingWithTheReceivedDatabase() {
    }

    public WorkingWithTheReceivedDatabase(AccountBaseData accountBaseData, InteractionWithTheDatabase interactionWithTheDatabase) {
        this.accountBaseData = accountBaseData;
        this.interactionWithTheDatabase = interactionWithTheDatabase;
    }

    public static Set<String> gettingListOfAccounts(List<String> list){
        Set<String> setList = new HashSet<>();
        for (int index = 0; index < list.size(); index++) {
            setList.add(list.get(index));
        }
       return setList;
    }

    public static Map<Integer, String> gettingDictionaryFromList(List<String> string){
        Map<Integer, String> dictionary = new HashMap<>();
        for (int index = 0; index < string.size(); index++) {
            dictionary.put(index, string.get(index));
        }
        return dictionary;
    }

    public void sqlAccountName() throws SQLException {
        accountBaseData.setList(WorkingWithTheReceivedDatabase.gettingListOfAccounts(
                interactionWithTheDatabase.requestForAccountLists()));
    }

    public static String getPasswordAccountDataBae(String string){
        return string;
    }


}
