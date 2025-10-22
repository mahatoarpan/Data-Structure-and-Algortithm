package greedy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JobSequenceTest {

    private JobSequence obj;

    @Before
    public void setup() {
        obj = new JobSequence();
    }

    @Test
    public void test1() {
        JobSequence.Job[] jobs = new JobSequence.Job[4];
        jobs[0] = new JobSequence.Job(1, 4, 20);
        jobs[1] = new JobSequence.Job(2, 1, 10);
        jobs[2] = new JobSequence.Job(3, 1, 40);
        jobs[3] = new JobSequence.Job(4, 1, 30);

        Assert.assertEquals(60, obj.maximizeProfit(jobs));
    }

    @Test
    public void test2() {
        JobSequence.Job[] jobs = new JobSequence.Job[4];
        jobs[0] = new JobSequence.Job(1, 4, 20);
        jobs[1] = new JobSequence.Job(2, 1, 10);
        jobs[2] = new JobSequence.Job(3, 2, 40);
        jobs[3] = new JobSequence.Job(4, 1, 30);

        Assert.assertEquals(90, obj.maximizeProfit(jobs));
    }

    @Test
    public void test3() {
        JobSequence.Job[] jobs = new JobSequence.Job[6];
        jobs[0] = new JobSequence.Job(1, 4, 20);
        jobs[1] = new JobSequence.Job(4, 1, 30);
        jobs[2] = new JobSequence.Job(3, 4, 25);
        jobs[3] = new JobSequence.Job(5, 1, 25);
        jobs[4] = new JobSequence.Job(2, 3, 30);
        jobs[5] = new JobSequence.Job(6, 3, 25);

        Assert.assertEquals(110, obj.maximizeProfit(jobs));
    }

}