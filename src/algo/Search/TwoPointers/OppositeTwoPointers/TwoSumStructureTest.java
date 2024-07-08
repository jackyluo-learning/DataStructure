/**
 * @author xuqiluo
 * @date 2024-06-20
 */
package algo.Search.TwoPointers.OppositeTwoPointers;

import org.junit.*;
import org.junit.rules.TestName;

public class TwoSumStructureTest {

    private TwoSumStructureContext context;
    private long l;

    @Rule
    public TestName name = new TestName();

    @Before
    public void testBegin(){
        l = System.currentTimeMillis();
    }

    @Test
    public void testTwoSumStructureWithMap(){
        context = new TwoSumStructureContext(new TwoSumStructureWithMap());
        context.add(1);
        context.add(3);
        context.add(5);
        Assert.assertTrue(context.find(4));
        Assert.assertFalse(context.find(7));
    }

    @Test
    public void testTwoSumStructureWithTwoPointers(){
        context = new TwoSumStructureContext(new TwoSumStructureWithTwoPointers());
        context.add(1);
        context.add(3);
        context.add(5);
        Assert.assertTrue(context.find(4));
        Assert.assertFalse(context.find(7));
    }

    @After
    public void testEnd(){
        l = System.currentTimeMillis() - l;
        System.out.println(this.name.getMethodName() + " run for " + l + "ms");
    }
}
