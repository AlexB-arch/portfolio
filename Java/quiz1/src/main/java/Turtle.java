public class Turtle {

    // Attributes
    int courages; // They all start with -3.
    int allCourages; //Total count of the turtles courage.

    public Turtle(){
        courages = -3;
        allCourages = 0;
    }

    public void seen(){

        allCourages += 1;

        if (courages < 3){
            courages++;
        }    
        else if (courages > 3){
            socialstatus(courages);
        }
    }

    public String socialstatus(int courages){

        if (courages < 3){
            return "Disliked";
        }

        else if( courages == 3){
            return "Loved";
        }

        else
            return "Explodes like Master Ugwe";
            
    }

    public int bravery(){
        return courages;
    }

    public int allCourages(){
        return allCourages;
    }

    public void lose(String outcome){

        if (outcome.equals("L")){
            
            if(courages != -3)
            courages--;
        }
    }

    public static void main(String[] args) {
    }
}
