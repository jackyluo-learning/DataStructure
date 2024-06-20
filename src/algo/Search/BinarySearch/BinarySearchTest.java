/**
 * @author xuqiluo
 * @date 2024-06-20
 */
package algo.Search.BinarySearch;

import org.junit.*;
import org.junit.rules.TestName;

import java.util.*;

public class BinarySearchTest {

    private static final int len = 100000;
    private static final int[] testArray = new int[len];
    private long l;
    private static final int target;
    private static final int targetIndex;
    private static final int firstAnswer;
    private static final int lastAnswer;
    private static final int[] answers;

    @Rule
    public TestName name = new TestName();

    static {
        Random random = new Random();
        for (int t = 0; t < testArray.length; t++) testArray[t] = (random.nextInt(10000));
        Arrays.sort(testArray);
        targetIndex = random.nextInt(len);
        target = testArray[targetIndex];
        List<Integer> list = new ArrayList<>();
        for (int j : testArray) {
            list.add(j);
        }
        firstAnswer = list.indexOf(target);
        lastAnswer = list.lastIndexOf(target);
        answers = new int[lastAnswer - firstAnswer + 1];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = i + firstAnswer;
        };
        System.out.printf("testArray: %s; target: %d;%n", Arrays.toString(testArray), target);
    }

    @Before//在每个测试方法之前运行
    public void testBegin(){
        l = System.currentTimeMillis();
    }

    @Test
    public void testFindAnyPosition(){
        BinarySearchContext context = new BinarySearchContext(new FindAnyPosition());
        int result = context.findPosition(testArray, target);
        Assert.assertTrue(Arrays.stream(answers).anyMatch(e -> Objects.equals(e, result)));
    }

    @Test
    public void testFindAnyPositionRecurrent(){
        BinarySearchContext context = new BinarySearchContext(new FindAnyPositionRecurrent());
        int result = context.findPosition(testArray, target);
        Assert.assertTrue(Arrays.stream(answers).anyMatch(e -> Objects.equals(e, result)));
    }

    @Test
    public void testFindTheFirstPosition(){
        BinarySearchContext context = new BinarySearchContext(new FindTheFirstPosition());
        int result = context.findPosition(testArray, target);
        Assert.assertEquals(firstAnswer, result);
    }

    @Test
    public void testFindTheLastPosition(){
        BinarySearchContext context = new BinarySearchContext(new FindTheLastPosition());
        int result = context.findPosition(testArray, target);
        Assert.assertEquals(lastAnswer, result);
    }

    @After//在每个方法之后运行
    public void testEnd(){
        l=System.currentTimeMillis()-l;
        System.out.println(name.getMethodName()+" run for "+l+"ms");
    }
}
