import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;

/**
 * Created by employee on 10/15/15.
 */
public class PrimeNumbersTest {

    @Test
    public void testFactor() throws Exception {
        assertThat(factor(1), hasSize(0));
        assertThat(factor(2), contains(2));
        assertThat(factor(3), contains(3));
        assertThat(factor(4), contains(2, 2));
        assertThat(factor(5), contains(5));
        assertThat(factor(6), contains(2, 3));
        assertThat(factor(7), contains(7));
        assertThat(factor(8), contains(2, 2, 2));
        assertThat(factor(9), contains(3, 3));
        assertThat(factor(10), contains(2, 5));
        assertThat(factor(11), contains(11));
        assertThat(factor(12), contains(2, 2, 3));
        assertThat(factor(13), contains(13));
        assertThat(factor(14), contains(2, 7));
        assertThat(factor(15), contains(3, 5));
        assertThat(factor(25), contains(5, 5));
        assertThat(factor(2*7*7), contains(2, 7, 7));
        assertThat(factor(2*2*3*3*5*7*13*43), contains(2, 2, 3, 3, 5, 7, 13, 43));
    }

    private List<Integer> factor(int number) {
        List<Integer> factors = new ArrayList<>();
        int result = number;

        for (int divisor = 2; number >= divisor; divisor++) {
            while (result % divisor == 0) {
                factors.add(divisor);
                result = result / divisor;
            }
        }

        return factors;
    }
}
