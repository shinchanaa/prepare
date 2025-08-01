package co.example.com;


import java.util.*;

public class StringQuestions {

    public static void main(String[] args) {
        StringQuestions obj = new StringQuestions();

        List<String> list= Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        Set<String> set = new java.util.HashSet<>();
        for (String word : list) {
            List<String> result =  new ArrayList<>();
            String sortedWord = obj.SortedLetterInWord(word);
            System.out.println("Original: " + word + ", Sorted: " + sortedWord);
            set.add(sortedWord);
        }

        for (String sortedWord : set) {
            List<String> anagrams = new ArrayList<>();
            for (String word : list) {
                if (obj.SortedLetterInWord(word).equals(sortedWord)) {
                    anagrams.add(word);
                }
            }
            System.out.println("Anagrams for " + sortedWord + ": " + anagrams);
        }

        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String word : list) {
            String sortedWord = obj.SortedLetterInWord(word);
            List<String> temp;
            if(anagramMap.containsKey(sortedWord)) {
                System.out.println("Anagrams for " + sortedWord + ": " + anagramMap.get(sortedWord));
                temp= anagramMap.get(sortedWord);
            } else {
                temp= new ArrayList<>();
            }
            temp.add(word);
            anagramMap.put(sortedWord,temp);

        }

        System.out.println("Anagrams grouped by sorted letters: using Map");
        for(Map.Entry<String, List<String>> entry:anagramMap.entrySet()){
            String key = entry.getKey();
            List<String> value = entry.getValue();
            System.out.println("Anagrams for " + key + ": " + value);
        }
    }




    //sort letter of a string
    String SortedLetterInWord(String word) {
        int length = word.length();
        char[] chars = word.toCharArray();

        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if(chars[i] >chars[j]){
                    //swap
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        return new String(chars);
    }

}