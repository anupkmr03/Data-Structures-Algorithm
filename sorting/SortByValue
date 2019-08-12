
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class SortByValue {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(4, 1);
        map.put(2, 5);
        map.put(3, 10);
        System.out.println(map);
        System.out.println(sortByValue1(map));
    }

    private static SortedSet<Map.Entry<Integer, Integer>> sortByValue(Map<Integer, Integer> map) {

        SortedSet<Map.Entry<Integer, Integer>> sortedEntries = new TreeSet<>(
                new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                        return e2.getValue().compareTo(e1.getValue());
                    }
                }
        );

        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    private static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> sortByValue1(Map<K, V> map) {
        SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<>(
                new Comparator<Map.Entry<K, V>>() {
                    @Override
                    public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                        return e2.getValue().compareTo(e1.getValue());
                    }
                }
        );

        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }


    private static SortedSet<Map.Entry<Integer, Integer>> sortByValue3(Map<Integer, Integer> map) {
        SortedSet<Map.Entry<Integer, Integer>> sortedEntries = new TreeSet<>((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    private static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> sortByValue4(Map<K, V> map) {
        SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<>((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

}
