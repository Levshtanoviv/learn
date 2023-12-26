import classes.mapClass;

public class Main {
    public static void main(String[] args) {
        mapClass map = new mapClass();
        map.addMap(1, "qq");
        map.addMap(2, "ww");
        map.addMap(3, "ee");
        map.addMap(4, "rr");

        map.searchValue(2);
//
        map.deleteMap(3);
//
        map.searchValue(3);
//
        map.getMap();
    }
}