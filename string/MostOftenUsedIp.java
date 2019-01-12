package string;

import java.util.*;
import java.util.Map.Entry;

public class MostOftenUsedIp {
    public static void main(String[] args) {
        String[] ips = {"10.0.0.1 - google [10/Oct/2000:13:55:36 -0700] GET /apache_pb.gif HTTP/1.0 200 2326",
                "10.0.0.1 - google [10/Oct/2000:13:55:36 -0700] GET /apache_pb.gif HTTP/1.0 200 2326",
                "10.0.0.2 - google [10/Oct/2000:13:55:36 -0700] GET /apache_pb.gif HTTP/1.0 200 2326",
                "10.0.0.1 - google [10/Oct/2000:13:55:36 -0700] GET /apache_pb.gif HTTP/1.0 200 2326",
                "10.0.0.3 - google [10/Oct/2000:13:55:36 -0700] GET /apache_pb.gif HTTP/1.0 200 2326",
                "10.0.0.3 - google [10/Oct/2000:13:55:36 -0700] GET /apache_pb.gif HTTP/1.0 200 2326",
                "10.0.0.1 - google [10/Oct/2000:13:55:36 -0700] GET /apache_pb.gif HTTP/1.0 200 2326",
        };

       getMostOftenUsedIP(ips,3);

    }

    private static void getMostOftenUsedIP(String[] ips,int topResult) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < ips.length; i++) {
            String temp = ips[i];
            String ip = temp.split(" ")[0];

            if (map.containsKey(ip)) {
                map.put(ip, map.get(ip) + 1);
            } else {
                map.put(ip, 1);
            }
        }

        List<Entry<String, Integer>> output = findGreatest(map, topResult);

        System.out.println("Showing Top "+topResult+" Results");
        for (int i = 0; i <topResult; i++) {
            System.out.println("IP :"+output.get(i).getKey() + " :: Occurrence Count :" +output.get(i).getValue());
        }

    }


    private static <K, V extends Comparable<? super V>> List<Entry<K, V>> findGreatest(Map<K, V> map, int n) {
        Comparator<? super Entry<K, V>> comparator =
                new Comparator<Entry<K, V>>() {
                    @Override
                    public int compare(Entry<K, V> e0, Entry<K, V> e1) {
                        V v0 = e0.getValue();
                        V v1 = e1.getValue();
                        return v1.compareTo(v0);//reverse order
                    }
                };


        PriorityQueue<Entry<K, V>> heap =
                new PriorityQueue<>(map.size(), comparator);

        for (Entry<K, V> entry : map.entrySet()) {
            heap.add(entry);
        }

        List<Entry<K, V>> result = new ArrayList<Map.Entry<K, V>>();
        while (heap.size() > 0 && n >= 0) {
            result.add(heap.poll());
        }
        return result;
    }
}
