package group144.goldov;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondPartTasksTest {

    @Test
    public void testFindQuotes() {
        List<String> list = Arrays.asList("aaaa", "aaab", "aaac", "aaad", "a", "ab", "cc");
        assertEquals(Arrays.asList("aaaa", "aaab", "aaac", "aaad"), SecondPartTasks.findQuotes(list, "aa"));
    }

    @Test
    public void testPiDividedBy4() {
        assertEquals(Math.PI / 4, SecondPartTasks.piDividedBy4(), 0.001);
    }

    @Test
    public void testFindPrinter() {
        List<String> a = Arrays.asList("book1", "book2");
        List<String> b = Collections.singletonList("boooooooooooooook1");
        Map<String, List<String>> map = new HashMap<>();
        map.put("a", a);
        map.put("b", b);
        assertEquals("b", SecondPartTasks.findPrinter(map));
    }

    @Test
    public void testCalculateGlobalOrder() {
        List<Map<String, Integer>> a = new ArrayList<>();
        a.add(new HashMap<>());
        a.add(new HashMap<>());
        a.add(new HashMap<>());
        a.get(0).put("a", 1);
        a.get(0).put("b", 1);
        a.get(1).put("b", 3);
        a.get(1).put("c", 1);
        a.get(2).put("a", 2);
        a.get(2).put("b", 100);
        HashMap<String, Integer> answer = new HashMap<>();
        answer.put("a", 3);
        answer.put("b", 104);
        answer.put("c", 1);
        assertEquals(answer, SecondPartTasks.calculateGlobalOrder(a));
    }
}