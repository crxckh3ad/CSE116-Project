package ratings;

import java.util.ArrayList;

public class Movie extends Ratable{
    //private String title;
    private ArrayList<String> cast;
    public Movie(String title, ArrayList<String> cast){
        setTitle(title);
        this.cast = cast;
    }
    public ArrayList<String> getCast(){
        return(this.cast);
    }

}
