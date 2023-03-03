package stack;

import org.junit.Assert;
import org.junit.Test;

public class ParenthesesBalanceCheckerTest {

    ParenthesesBalanceChecker balanceChecker = new ParenthesesBalanceChecker();

    @Test
    public void test1() {
        String input = "(A+B)+(C-D)";
        Assert.assertTrue(balanceChecker.isValid(input));
    }

    @Test
    public void test2() {
        String input = "((A+B)+(C-D)";
        Assert.assertFalse(balanceChecker.isValid(input));
    }

    @Test
    public void test3() {
        String input = "((A+B)+[C-D])";
        Assert.assertTrue(balanceChecker.isValid(input));
    }

    @Test
    public void test4() {
        String input = "A+B)+(C-D)";
        Assert.assertFalse(balanceChecker.isValid(input));
    }
}