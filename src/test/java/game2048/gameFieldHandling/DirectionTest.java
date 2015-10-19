package game2048.gameFieldHandling;

import game2048.controllers.Direction;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by employee on 10/16/15.
 */
public class DirectionTest {

    @Test
    public void testDirection() {
        assertThat(Direction.UP, is(Direction.UP));
        assertThat(Direction.DOWN, is(Direction.DOWN));
        assertThat(Direction.LEFT, is(Direction.LEFT));
        assertThat(Direction.RIGHT, is(Direction.RIGHT));
    }

    @Test
    public void testDirectionName() {
        assertThat(Direction.UP.toString(), is("UP"));
        assertThat(Direction.DOWN.toString(), is("DOWN"));
        assertThat(Direction.LEFT.toString(), is("LEFT"));
        assertThat(Direction.RIGHT.toString(), is("RIGHT"));
    }

    @Test
    public void testDirectionValues(){
        assertThat(Direction.UP.ordinal(), is(0));
        assertThat(Direction.DOWN.ordinal(), is(1));
        assertThat(Direction.LEFT.ordinal(), is(2));
        assertThat(Direction.RIGHT.ordinal(), is(3));
    }
}
