package algo;

import org.junit.Test;

public class ExcelSheetColumnTitle {
    /*

     */
    public String convertToTitle(int n){
        StringBuilder result = new StringBuilder();
        while (n>=1){
            n--;
            int j = n%26;
            result.insert(0, (char) (j + 65));
            n /= 26;
        }
        return result.toString();
    }

    public int titleToNumber(String s) {
        int len = s.length();
        int result = 0;
        int count = 0;
        for (int i = len-1; i>=0; i--){
            int c = (int) s.charAt(i) - 65+1;
            result += Math.pow(26, count) * c;
            count++;
        }
        return result;
    }

    @Test
    public void test(){
        System.out.println(convertToTitle(701));
        System.out.println(titleToNumber("ZYZZ"));
    }
}
