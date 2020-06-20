import java.util.TreeMap;
import java.util.HashSet;

import java.util.Map;
import java.util.Set;

import java.util.Comparator;

public class Plot {

    static final int MAX_CAST = 40;

    Map<String, Actor> cast;
    FastRandomAccessHashSet<House> houses;
    public Plot (){
        
        cast = new TreeMap<>((a,b) -> a.compareTo(b));
        houses = new FastRandomAccessHashSet<House>();
        for (int i = 0; i < MAX_CAST; i++){
            String lastName = "";
            //determine if new last name is generated
            if (Utils.diceRoll(10) < 4){
                lastName = Utils.randomNameGenerator();
            } else {
                lastName = houses.getRandom().name;
            }
            
            Name name = new Name (Utils.randomNameGenerator(), lastName);
            long count = 0;
            //for full name the permutations double for first and last name
            while(count < Utils.permutations() * 2){
                name = new Name (Utils.randomNameGenerator(), lastName);
                if (cast.get(name.lastCommaFirst) == null){
                    break;
                }
                count ++;
            }
            Actor actor  = new Actor(name);
            cast.put(actor.name.lastCommaFirst, actor);
            if  (Utils.diceRoll(3) == 0){
                houses.add(actor.name.last, new House(actor.name.last, actor.gender, houses.size() == 0));
            }
        }
        
        
    }
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();

        for(House entry: houses.list){
            result.append("House " + entry.name + " | is Matrilinear " + entry.matrilinear +  " | is Royal " + entry.royal + "\n");
        }
        result.append ("\n");

        for (Map.Entry<String, Actor> entry: cast.entrySet()){
            
            result.append(entry.getKey() + "\n"); 
        }
        return result.toString();
    }
    
    public static void main (String[] args){
        Plot plot = new Plot();
        
        System.out.println(plot.toString());
    
    }
}

