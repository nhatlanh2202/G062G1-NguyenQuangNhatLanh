package service;

import java.util.HashMap;
import java.util.Map;

public class LibraryServiceImpl implements LibraryService {
    private static Map<String, String> libraryList;

    static {
        libraryList = new HashMap<>();
        libraryList.put("car","xe");
        libraryList.put("phone","dien thoai");
        libraryList.put("book","sach");
        libraryList.put("dog","con cho");
        libraryList.put("cat","con meo");
    }

    @Override
    public String findByAll(String key) {
        return libraryList.get(key);
    }

    @Override
    public String findByKey(String key) {
        return libraryList.get(key);
    }
}
