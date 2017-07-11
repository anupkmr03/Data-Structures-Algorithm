package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MostOftenUsedIp {
    public static void main(String[] args) {
	String[] ips = { "10.0.0.1 - google [10/Oct/2000:13:55:36 -0700] GET /apache_pb.gif HTTP/1.0 200 2326",
		"10.0.0.1 - google [10/Oct/2000:13:55:36 -0700] GET /apache_pb.gif HTTP/1.0 200 2326",
		"10.0.0.2 - google [10/Oct/2000:13:55:36 -0700] GET /apache_pb.gif HTTP/1.0 200 2326" };

	String result = getMostOftenUsedIP(ips);
	System.out.println(result);

    }

    private static String getMostOftenUsedIP(String[] ips) {
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

	Set<Entry<String, Integer>> set = map.entrySet();
	List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
	Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
	    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
		return (o2.getValue()).compareTo(o1.getValue());
	    }
	});

	Entry<String, Integer> entry = list.get(0);

	return entry.getKey();
    }

}