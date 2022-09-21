public class Fly {

    public double directions(String s){
        //in "North", return 0.0
        return 0.0;
    }

    public Boolean closeEnough(double a, double b){
        return Math.abs(a-b) < 0.0001;
    }
    
    public static void main(String[] args) {
        System.out.println("Fly");
    }
}
