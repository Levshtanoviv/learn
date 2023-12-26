package classes;

import java.util.HashMap;
import java.util.Map;

public class mapClass {
    Map map = new HashMap<>();

    public void addMap(int key, String value) {
        map.put(key, value);
    }

    public void deleteMap(int key) {
        map.remove(key);
    }

    public String searchValue(int key) {
        System.out.println(map.get(key));
        return (String) map.get(key);
    }

    public void getMap() {
        int key = 1;
        boolean flag = true;
        while (flag) {
            if(key > map.size()) {
                flag = false;
            }
            this.searchValue(key);
            key++;
        }
    }

}
