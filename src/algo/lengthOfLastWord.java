package algo;

import org.junit.Assert;
import org.junit.Test;

public class lengthOfLastWord {
    /*
    Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
    If the last word does not exist, return 0.
     */
    public int lengthOfLastWord1(String s){
        String[] words = s.split(" ");
        int size = words.length;
        if(size!=0){
            return words[size-1].length();
        }
        else{
            return 0;
        }
    }

    public int lengthOfLastWord2(String s){
        String use = s.trim();
        String[] words = use.split(" ");
        int size = words.length;
        if(size!=0){
            return words[size-1].length();
        }
        else{
            return 0;
        }
    }

    @Test
    public void test(){
        Assert.assertEquals(0, lengthOfLastWord1("  "));
        Assert.assertEquals(5, lengthOfLastWord2(" world    "));
    }
}
