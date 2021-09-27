package week7;

// 오픈채팅방
import java.util.*;

class Solution_5 {
    public static String[] solution(String[] record) {
        int length = record.length;
        HashMap<String, String> list = new HashMap<>();
        String[] answer = new String[length];
        int count = 0;

        for (int index = 0; index < length; ++index) {
            String sentence = record[index];
            String[] slicing = sentence.split(" ");

            if (slicing[0].equals("Enter")) {
                String key = slicing[1];
                String value = slicing[2];

                if (list.containsKey(key))
                    list.replace(key, value);
                else
                    list.put(key, value);
                answer[count++] = key + "@님이 들어왔습니다.";
            } else if (slicing[0].equals("Leave")) {
                String key = slicing[1];
                answer[count++] = key + "@님이 나갔습니다.";
            } else {
                String key = slicing[1];
                String value = slicing[2];

                list.replace(key, value);
            }
        }

        String[] check = new String[count];
        for (int index = 0; index < count; ++index) {
            String sentence = answer[index];
            String[] split = sentence.split("@");

            check[index] = list.get(split[0]) +
                    split[1];
        }

        return check;
    }
}