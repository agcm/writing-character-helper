import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class FastRandomAccessHashSet <T> {
    ArrayList<T> list = new ArrayList<>();
    HashMap<T, Integer> map = new HashMap<>();
    HashSet<String> set = new HashSet<>();



    public void add(String name, T value){
        if (!set.contains(name)){
            set.add(name);
            list.add(value);
            map.put(value, list.size() - 1);
        }
    }

    public T getRandom(){
        return get(Utils.diceRoll(list.size()));
    }

    public T get(int index){
        return list.get(index);
    }

    public void remove(String name, T value){
        if (set.contains(name)){
            set.remove(name);
            int index = map.get(value);
            T newValue = list.get(list.size() -1);
            map.put(newValue, index);
            Collections.swap(list, list.size() - 1, index);
            list.remove(list.size() - 1);
            map.remove(value); 
        }     
    }

    public boolean contains(String name){
        return set.contains(name);
    }

    public int size(){
        return set.size();
    }

}