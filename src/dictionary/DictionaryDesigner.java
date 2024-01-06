package dictionary;

import game.User;

import java.util.ArrayList;
import java.util.Map;

public class DictionaryDesigner {

    private DictionaryWord dictionaryWord;
    private User user;

    public DictionaryDesigner() {
    }

    public DictionaryDesigner(DictionaryWord dictionaryWord, User user) {
        this.dictionaryWord = dictionaryWord;
        this.user = user;
    }

    public static String[] transferringWordsFromDictionaryArray(Map<Integer, String> dictionary){
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : dictionary.entrySet()
             ) {
            list.add(entry.getValue());
        }
        return transferringWordsFromCollectionArray(list);
    }

    private static String[] transferringWordsFromCollectionArray(ArrayList<String> arrayList){
        int size = arrayList.size();
        String[] newArray = new String[size];
        for (int indexArray = 0; indexArray < newArray.length; indexArray++) {
            for (int indexList = indexArray; true; indexList++) {
                newArray[indexArray] = arrayList.get(indexList);
                break;
            }
        }
        return newArray;
    }


    // добавление слов в словарь
    public Map<Integer, String> fillingDictionary() {
        int count = 0;
        while (count < 5) {
            System.out.println("Запишите слово под номером " + count + ": ");
            dictionaryWord.addWordDictionary(count, user.sayWord());
            count++;
        }
        return dictionaryWord.getDictionary();
    }

    public void printKyeAndWordsDictionary(Map<Integer,String> dictionary) {
        if(dictionary.isEmpty()) System.out.println("Сначала придумайте слова");
        for (Map.Entry<Integer, String> entry : dictionary.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
