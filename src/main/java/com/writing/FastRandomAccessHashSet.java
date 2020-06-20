import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class FastRandomAccessHashSet <T> {
    ArrayList<T> list = new ArrayList<>();
    HashMap<T, Integer> map = new HashMap<>();
    HashSet<T> set = new HashSet<>();



    public void add(T value){
        if (!set.contains(value)){
            set.add(value);
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

    public void remove(T value){
        if (set.contains(value)){
            set.remove(value);
            int index = map.get(value);
            T newValue = list.get(list.size() -1);
            map.put(newValue, index);
            Collections.swap(list, list.size() - 1, index);
            list.remove(list.size() - 1);
            map.remove(value); 
        }     
    }

    public boolean contains(T value){
        return set.contains(value);
    }

    public int size(){
        return set.size();
    }

}