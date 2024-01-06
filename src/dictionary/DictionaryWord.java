package dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DictionaryWord {
    private Map<Integer, String> dictionary;

    public DictionaryWord() {
        dictionary = new HashMap<>();
    }


    public void addWordDictionary(int key,String values){
        if(dictionary == null){
            dictionary = new HashMap<>();
        }

        dictionary.put(key, values);
    }

    public String getWordDictionary(int key){
        return dictionary.get(key);
    }

    public void printDictionary(Map<Integer, String> dictionary){
        for (Map.Entry<Integer, String> entry : dictionary.entrySet()) {
            System.out.println("Ключ: " + entry.getKey() + ", Значение: " + entry.getValue());
        }
    }

    public Map<Integer, String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<Integer, String> dictionary) {
        this.dictionary = dictionary;
    }


    public int randomKeyDictionary(Map<Integer,String> map){
        return new Random().nextInt(map.size());
    }

}
