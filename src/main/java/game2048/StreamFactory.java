package game2048;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by employee on 10/22/15.
 */
public class StreamFactory {
    public static InputStream getInputStream() {
        return System.in;
    }

    public static PrintStream getPrintStream() {
        return System.out;
    }
}
