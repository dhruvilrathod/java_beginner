package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet_380 {

    private Map _mapping;
    private ArrayList _arr;

    public RandomizedSet_380() {
        this._mapping = new HashMap<>();
        this._arr = new ArrayList<>();
    }

    public static void main(String[] args) {
        RandomizedSet_380 obj = new RandomizedSet_380();
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(1));
        System.out.println(obj.remove(1));
        System.out.println(obj.remove(1));
        System.out.println(obj.insert(1));
        System.out.println(obj.insert(2));
        System.out.println(obj.insert(3));
        System.out.println(obj.insert(4));
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
    }

    public boolean insert(int val) {
        if (!this._mapping.containsKey(val)) {
            this._arr.add(val);
            this._mapping.put(val, this._arr.size() - 1);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (this._mapping.containsKey(val)) {
            int removeIndex = (int) this._mapping.get(val);
            this._arr.set(removeIndex, this._arr.get(this._arr.size() - 1));
            this._mapping.put(this._arr.get(removeIndex), removeIndex);
            this._arr.removeLast();
            this._mapping.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        Random r = new Random();
        return (int) this._arr.get(r.nextInt(this._arr.size()));
    }
}
