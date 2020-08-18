package JavaCollectionFramework.thuc_hanh.TestHashMapLinkedHashMapTreeMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Thiên", 20);
        hashMap.put("Địa", 21);
        hashMap.put("Huyền", 22);
        hashMap.put("Hoàng", 23);
        System.out.println("Display entries in HashMap");
        System.out.println(hashMap + "\n");

        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        linkedHashMap.put("Thiên",20);
        linkedHashMap.put("Địa",21);
        linkedHashMap.put("Huyền",22);
        linkedHashMap.put("Hoàng",23);
        System.out.println("\nThe age for " + "Địa is " + linkedHashMap.get("Địa"));

    }
}
