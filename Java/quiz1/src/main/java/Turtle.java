public class Turtle {

    // Attributes
    int courages = -3; // They all start with -3.
    int allCourages; //Total count of the turtles courage.

    public void seen(){
        
        if (courages < 3){
            courages++;
            allCourages++;
        }    
        else if (courages >= 3){
            socialstatus(courages);
        }
    }

    public String socialstatus(int courages){

            if( courages == 3){
                return "Loved";
            }

            else if (courages >= 3) {
                return "Explodes like Master Ugwe";
            }

            else
             return "Disliked";
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
