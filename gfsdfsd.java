import java.util.HashMap;
import java.util.Map;

public class gfsdfsd {
    public static void main(String[] args) {
        String text = "This is a sample text. This text is for testing purposes.";
        String[] words = text.split("\\s+"); // Tách từng từ dựa trên khoảng trắng

        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            // Chuyển từ thành chữ thường và loại bỏ ký tự đặc biệt
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();

            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        // In ra kết quả đếm số lần xuất hiện của mỗi từ
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
