package leetcode;

public class Zigzag {

    /*
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
     * of rows like this: (you may want to display this pattern in a fixed font for
     * better legibility)
     * 
     * P A H N
     * A P L S I I G
     * Y I R
     * 
     * And then read line by line: "PAHNAPLSIIGYIR"
     * 
     * Write the code that will take a string and make this conversion given a
     * number of rows:
     * 
     * string convert(string s, int numRows);
     * 
     */

     public String convert(String s, int numRows){
        if(numRows == 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < sb.length; i++){
            sb[i] = new StringBuilder();
        }
        int index = 0, step = 1;
        for(char c : s.toCharArray()){
            sb[index].append(c);
            if(index == 0){
                step = 1;
            }else if(index == numRows - 1){
                step = -1;
            }
            index += step;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : sb){
            res.append(row);
        }
        return res.toString();
     }
    
}
