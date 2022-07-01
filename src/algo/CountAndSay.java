package algo;

import org.junit.Assert;
import org.junit.Test;

public class CountAndSay {

    /*
        The count-and-say sequence is the sequence of integers with the first five terms as following:
            1.     1
            2.     11
            3.     21
            4.     1211
            5.     111221
        1 is read off as "one 1" or 11.
        11 is read off as "two 1s" or 21.
        21 is read off as "one 2, then one 1" or 1211.
     */
    public static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        else{
            String previous = countAndSay(n-1);
            StringBuilder sb = new StringBuilder();
            int len = previous.length();
            int i = 0;
            for(int j = 0; j<len; j++){
                if(j==len-1 || !previous.substring(j, j+1).equals(previous.substring(j+1, j+2))){
                    int count = j-i+1;
                    i = j;
                    sb.append(count).append(previous, j, j+1);
                    i++;
                }
            }
            return sb.toString();
        }
    }

    @Test
    public void test(){
        Assert.assertEquals("13112221", countAndSay(7));
    }
}
