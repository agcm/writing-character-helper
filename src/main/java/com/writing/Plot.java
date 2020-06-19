import java.util.TreeMap;

public class Plot {

    TreeMap<String, Character> tree;
    public Plot (){
        tree = new TreeMap<>();
        Name name = new Name("agag", "gagag");
        Character first  = new Character(new Name (Utils.randomNameGenerator(), Utils.randomNameGenerator()));

    }
    @Override
    public String toString(){
        return Utils.randomNameGenerator() + " " + Utils.randomNameGenerator();
    }
    
    public static void main (String[] args){
        Plot plot = new Plot();
        
        System.out.println(plot.toString());
    
    }
}

