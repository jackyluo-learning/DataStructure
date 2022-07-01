package algo;

import org.junit.Assert;
import org.junit.Test;

public class MostCommonPrefix {

    @Test
    public void test(){
        Assert.assertEquals("fl", mostCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public static String mostCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        else {
            String prefix = strs[0];
            for (int i = 0; i < strs.length; i++) {
                while (strs[i].indexOf(prefix) != 0) {
                        prefix = prefix.substring(0, prefix.length() - 1);
                    }
                if(prefix.length() == 0) return "";
                }
            return prefix;
        }
    }
}
