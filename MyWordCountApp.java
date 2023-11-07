import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MyWordCountApp {
    public static final String fileName = "data/fit.txt";
    // <word, its occurences>
    private Map<String, Integer> map = new HashMap<String, Integer>();

    // Load data from fileName into the above map (containing <word, its occurences>)
    // using the guide given in TestReadFile.java
    public void loadData()  {
        Scanner input = null;
        try {
            input = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (input.hasNext()) {
            String word = input.next();
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase(); // Remove non-alphabetic characters and convert to lowercase
            if (!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        input.close();
    }


    // Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
    public int countUnique() {
        return map.size();
    }

    // Prints out the number of times each unique token appears in the file
    // data/hamlet.txt (or fit.txt)
    // In this method, we do not consider the order of tokens.
    public void printWordCounts() throws FileNotFoundException {
        loadData();
        for ( Map.Entry<String, Integer > entry: map.entrySet() ) {
            String temp = entry.getKey();
            int val = entry.getValue();
            System.out.println(temp + "  " + val);
        }
    }

    // Prints out the number of times each unique token appears in the file
    // data/hamlet.txt (or fit.txt) according to ascending order of tokens
    // Example: An - 3, Bug - 10, ...
    public void printWordCountsAlphabet() {
        loadData();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        // Sort the list by keys (tokens) in ascending order
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e1.getKey().compareTo(e2.getKey());
            }
        });

        // Print the sorted entries
        for (Map.Entry<String, Integer> entry : entryList) {
            String token = entry.getKey();
            int count = entry.getValue();
            System.out.println(token + " - " + count);
        }
    }
}
