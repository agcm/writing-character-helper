import java.util.TreeMap;
import java.util.Map;
import java.util.Comparator;

public class Plot {

    TreeMap<Name, Actor> tree;
    public Plot (){
        
        tree = new TreeMap<>(new Comparator <Name>(){

            @Override
            public int compare (Name a, Name b){
                return (a.lastCommaFirst.compareTo(b.lastCommaFirst));
            }

        });
        Actor original  = new Actor(new Name (Utils.randomNameGenerator(), Utils.randomNameGenerator()));
        tree.put(original.name, original);
    }
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Name, Actor> entry: tree.entrySet()){

            result.append(entry.getKey().lastCommaFirst + "\n"); 
        }
        return result.toString();
    }
    
    public static void main (String[] args){
        Plot plot = new Plot();
        
        System.out.println(plot.toString());
    
    }
}

