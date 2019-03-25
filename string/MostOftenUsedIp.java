package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;

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

        getMostOftenUsedIP(ips, 3);

    }

    private static void getMostOftenUsedIP(String[] ips, int topResult) {
        HashMap<String, Integer> map = new HashMap<>();

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

        System.out.println("Showing Top " + topResult + " Results");
        for (int i = 0; i < topResult; i++) {
            System.out.println("IP :" + output.get(i).getKey() + " :: Occurrence Count :" + output.get(i).getValue());
        }

    }


    private static List<Entry<String, Integer>> findGreatest(HashMap<String, Integer> map, int n) {
        PriorityQueue<Entry<String, Integer>> heap = new PriorityQueue<>(map.size(),
                (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        heap.addAll(map.entrySet());

        List<Entry<String, Integer>> result = new ArrayList<>();
        while (heap.size() > 0 && n >= 0) {
            result.add(heap.poll());
        }
        return result;
    }
}
