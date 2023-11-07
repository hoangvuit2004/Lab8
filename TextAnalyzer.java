import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextAnalyzer {
    private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

    // load words in the text file given by fileName and store into map by using add
    // method in Task 2.1.
    // Using BufferedReader reffered in file TextFileUtils.java
    public void load(String fileName) throws IOException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String line;
        int position = 0;
        while ( (line = reader.readLine()) != null){
            StringTokenizer token= new StringTokenizer(line , " ");
            position = 0;
            while(token.hasMoreTokens() ){
                position++;
                String word = token.nextToken();
                if (!word.isEmpty()) {
                    add(word, position);
                }
            }
        }
    }
    // In the following method, if the word is not in the map, then adding that word
    // to the map containing the position of the word in the file. If the word is
    // already in the map, then its word position is added to the list of word
    // positions for this word.
    // Remember to negate the word position if the word is at the end of a line in
    // the text file

    public void add(String word, int position) {
        if(map.containsKey(word)){
            map.get(word).add(position);
        }else{
            ArrayList<Integer> positions = new ArrayList<Integer>();
            positions.add(position);
            map.put(word, positions);
        }
    }

    // This method should display the words of the text file along with the
    // positions of each word, one word per line, in alphabetical order
    public void displayWords() {
        Map<String, ArrayList<Integer>> sortedMap = new TreeMap<>(map);

        for (Map.Entry<String, ArrayList<Integer>> entry : sortedMap.entrySet()) {
            String word = entry.getKey();
            ArrayList<Integer> positions = entry.getValue();

            // Display the word and its positions
            System.out.print(word + " ");
            if (positions.size() > 0) {
                for (int i = 0; i < positions.size(); i++) {
                    if (i > 0) {
                        System.out.print(",");
                    }
                    System.out.print(positions.get(i));
                }
            }
            System.out.println();
        }

    }

    // This method will display the content of the text file stored in the map
    public void displayText() {
        // TODO
    }

    // This method will return the word that occurs most frequently in the text file
    public String mostFrequentWord() {
        String mostFrequent = null;
        int maxFrequency = 0;

        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            String word = entry.getKey();
            ArrayList<Integer> positions = entry.getValue();
            int frequency = positions.size();

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostFrequent = word;
            }
        }

        return mostFrequent;
    }
}
