package ratings;

import java.util.ArrayList;
import java.util.HashMap;

public class DegreesOfSeparation{
    private ArrayList<Movie> movies;

    public DegreesOfSeparation(ArrayList<Movie> movies){
        this.movies=movies;
    }

    public int degreesOfSeparation(String a1,String a2){
        if (a1.equals(a2)){
            return 0;
        }
        Graph<String> graph=new Graph<>();
        HashMap<String,Integer> separation=new HashMap<>();
        ArrayList<String> crossOut=new ArrayList<>();
        ArrayList<String> next=new ArrayList<>();
        boolean check1=false;
        boolean check2=false;
        for (Movie movie :movies){
            ArrayList<String> cast=movie.getCast();
                for (int x=0;x < cast.size();x++){
                    if (cast.get(x).equals(a1)) check1=true;
                    if (cast.get(x  ).equals(a2)) check2=true;
                for (int y=x +1;y < cast.size();y++){
                    graph.addEdge(cast.get(x),cast.get(y));
                    graph.addEdge(cast.get(y),cast.get(x));
                }
            }
        }
        if (check1==false||check2==false){
            return -1;
        }
        if(check1==false && check2==false){
            return -1;
        }
        next.add(a1);
        separation.put(a1,0);
        crossOut.add(a1);

        while (!next.isEmpty()){
            String current =next.remove(0);
            int i =separation.get(current);
            for (String j :graph.adjacencyList.get(current)){
                if (!crossOut.contains(j)){
                    if (j.equals(a2)){
                        return i+1;
                    }
                    next.add(j);
                    crossOut.add(j);
                    separation.put(j, i+1);
                }
            }
        }
        return -1;
    }
}




