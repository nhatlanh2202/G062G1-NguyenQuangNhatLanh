package DSAStackVaQueue.bai_tap.DemSoLanXuatHienKyTu;

import java.util.TreeMap;

public class CountCharacter {
    public static void main(String[] args) {
        String string = "Tôi là một thằng ngốc! Bạn cũng là một thằng ngốc! ";
        String[] array = string.split("\\s");
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        String temp;
        int count;
        for(String element : array){
            temp = element.toLowerCase();
            if(treeMap.containsKey(temp)){
                count = treeMap.get(temp);
                treeMap.put(temp, count + 1);
            }else treeMap.put(temp, 1);
        }
        System.out.println(treeMap);
    }
}
