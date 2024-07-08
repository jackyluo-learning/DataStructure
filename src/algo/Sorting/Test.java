package algo.Sorting;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import java.util.Arrays;
import java.util.Random;


public class Test {

    private static int len = 100;
    private static int[] a = new int[len];
    private static int[] testArray;
    private static int[] resultArray;
    private long l;

    @Rule
    public TestName name = new TestName();


    static {
        Random random = new Random();
        for (int t = 0; t < a.length; t++) a[t] = (random.nextInt(10000));
        testArray = Arrays.copyOf(a, a.length);
        Arrays.sort(a);
    }

    @Before//在每个测试方法之前运行
    public void testBegin(){
        l = System.currentTimeMillis();
    }


    @org.junit.Test
    public void testBS(){
        resultArray = BS.BS(testArray);
        Assert.assertArrayEquals(a, resultArray);
    }

    @org.junit.Test
    public void testSS(){
        resultArray = SS.selectionSort(testArray);
        Assert.assertArrayEquals(a, resultArray);
    }

    @org.junit.Test
    public void testIS(){
        resultArray = IS.insertionSort(testArray);
        Assert.assertArrayEquals(a, resultArray);
    }

    @org.junit.Test
    public void testMS(){
        resultArray = MS.mergeSort(testArray);
        Assert.assertArrayEquals(a, resultArray);
    }

    @org.junit.Test
    public void testQS(){
        resultArray = QS.quickSort(testArray);
        Assert.assertArrayEquals(a, resultArray);
    }

    @org.junit.Test
    public void testHS () {
        HS hs = new HS(testArray);
        resultArray = hs.sort();
        Assert.assertArrayEquals(a, resultArray);
    }

    @org.junit.Test
    public void testHSInsertion () {
        HS hs = new HS(len);
        resultArray = hs.sort(testArray);
        Assert.assertArrayEquals(a, resultArray);
    }

    @org.junit.Test
    public void testBucketSort () {
        resultArray = BucketSort.bucketSort(testArray, 100);
        Assert.assertArrayEquals(a, resultArray);
    }

    @org.junit.Test
    public void testCountingSort () {
        resultArray = CountingSort.countingSort(testArray);
        Assert.assertArrayEquals(a, resultArray);
    }

    @After//在每个方法之后运行
    public void testEnd(){
        l=System.currentTimeMillis()-l;
//        System.out.println("\nInput: "+Arrays.toString(testArray));
        System.out.println(name.getMethodName()+" run for "+l+"ms");
//        System.out.println(String.format("%s result: %s", name.getMethodName(), Arrays.toString(resultArray)));
    }

}
