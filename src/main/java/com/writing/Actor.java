import java.util.LinkedList;
import java.util.HashSet;
import java.util.PriorityQueue;

import java.util.Set;
import java.util.List;
import java.util.Queue;
import java.util.Comparator;

class Actor{

    
    Name name;
    boolean gender;
    Set <Actor> allies;
    Set <Actor> enemies;
    List<Action> queuedPlans;
    Queue<Action> priorityPlans;
    
    House house;
    Actor pledgedLoyalty;
    Actor mother;
    Actor father;



    Actor (Name name, boolean gender){
        this.name = name;
        this.gender = gender;
        allies = new HashSet<>();
        enemies = new HashSet<>();
        queuedPlans = new LinkedList<>();
        priorityPlans = new PriorityQueue<>(new Comparator<Action>() {

            @Override
            public int compare (Action a, Action b){
                if (a.priority == b.priority){
                    return a.name.compareTo(b.name);
                } 
                return b.priority.compareTo(a.priority);
            }

        });
    }

    

    
}