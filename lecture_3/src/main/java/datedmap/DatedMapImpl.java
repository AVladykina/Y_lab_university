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
        var v = map.get(key);
        return v == null ? null : v.getValue();
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
        var v = map.get(key);
        return v == null ? null: v.getDateAdded();
    }
}