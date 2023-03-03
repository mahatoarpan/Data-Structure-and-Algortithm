package queue;

import org.junit.Assert;
import org.junit.Test;

public class QueueLinkedListImplTest {

    QueueLinkedListImpl queue = new QueueLinkedListImpl();

    @Test
    public void test1() throws QueueException {
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }
        String expectedOutput = "0123456789";
        String actualOutput = "";
        while(!queue.isEmpty()) {
            actualOutput += queue.deQueue();
        }
        Assert.assertEquals(expectedOutput, actualOutput);
    }
}