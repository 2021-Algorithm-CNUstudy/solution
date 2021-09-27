package week7;

// 입실 퇴실
import java.util.*;

class Solution_1 {
    public int[] solution(int[] enter, int[] leave) {
        List<Integer> room = new ArrayList<>();
        int[] list = new int[enter.length];
        
        room.add(enter[0]);
        int index = 0;
        for (int end : leave) {
            while (! room.contains(end))
                room.add(index++);
            
            for (int man : room)
                list[man - 1] += room.size() - 1;
            
            room.remove((Object) end);
        }
        
        return list;
    }
}