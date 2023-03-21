package datedmap;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DatedMapImpl implements DatedMap {

    Map<String, DatedValue> map = new HashMap<>();

    @Override
    public void put(String key, String value) {
        DatedValue data = new DatedValue(value);
        map.put(key, data);

    }

    @Override
    public String get(String key) {
        DatedValue value = map.get(key);
        return value == null ? null : value.value;
    }

    @Override
    public boolean containsKey(String key) {
        return map.containsKey(key);
    }

    @Override
    public void remove(String key) {
        map.remove(key);
    }

    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @Override
    public Date getKeyLastInsertionDate(String key) {
        if (map.containsKey(key)) {
            return map.get(key).dateAdded;
        } else {
            return null;
        }
    }
}