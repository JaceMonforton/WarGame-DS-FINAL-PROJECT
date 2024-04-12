package FinalProject;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class WarGameTest {

    // Set timeout to 10 seconds for each test case
    @Test
    @Timeout(10)
    public void testEmptyDeck() {
        String input = "\n\n";
        simulateUserInput(input);
    }

    @Test
    @Timeout(10)
    public void testSingleCard() {
        String input = "1\n2\n1\n3\n";
        simulateUserInput(input);
        assertDoesNotThrow(() -> WarGame.main(new String[0]));
    }

//    @Test
//    @Timeout(10)
//    public void testEqualNumberOfCards() {
//        String input = "3\n2 3 4\n3\n5 6 7\n";
//        simulateUserInput(input);
//    }
//
//    @Test
//    @Timeout(10)
//    public void testDifferentNumberOfCards() {
//        String input = "3\n2 3 4\n2\n5 6\n";
//        simulateUserInput(input);
//        assertDoesNotThrow(() -> WarGame.main(new String[0]));
//    }

    @Test
    @Timeout(10)
    public void testTenThousandCards() {
        StringBuilder inputBuilder = new StringBuilder();
        inputBuilder.append("10000\n");
        for (int i = 0; i < 10000; i++) {
            inputBuilder.append("2 ");
        }
        inputBuilder.append("\n10000\n");
        for (int i = 0; i < 10000; i++) {
            inputBuilder.append("3 ");
        }
        inputBuilder.append("\n");
        String input = inputBuilder.toString();
        simulateUserInput(input);
        assertDoesNotThrow(() -> WarGame.main(new String[0]));
    }

    // Helper method to simulate user input
    private void simulateUserInput(String input) {
        String inputWithNewlines = input.replaceAll("\\s+", "\n") + "\n";
        ByteArrayInputStream in = new ByteArrayInputStream(inputWithNewlines.getBytes());
        System.setIn(in);
    }



    @Test
    @Timeout(10)
    public void testOneHundredCards() {
        StringBuilder inputBuilder = new StringBuilder();
        inputBuilder.append("100\n");
        for (int i = 0; i < 100; i++) {
            inputBuilder.append("2 ");
        }
        inputBuilder.append("\n100\n");
        for (int i = 0; i < 100; i++) {
            inputBuilder.append("3 ");
        }
        inputBuilder.append("\n");
        String input = inputBuilder.toString();
        simulateUserInput(input);
        assertDoesNotThrow(() -> WarGame.main(new String[0]));
    }
    @Test
    @Timeout(10)
    public void testFiveHundredCards() {
        StringBuilder inputBuilder = new StringBuilder();
        inputBuilder.append("500\n");
        for (int i = 0; i < 500; i++) {
            inputBuilder.append("2 ");
        }
        inputBuilder.append("\n500\n");
        for (int i = 0; i < 500; i++) {
            inputBuilder.append("3 ");
        }
        inputBuilder.append("\n");
        String input = inputBuilder.toString();
        simulateUserInput(input);
        assertDoesNotThrow(() -> WarGame.main(new String[0]));
    }

    @Test
    @Timeout(10)
    public void testTwoThousandCards() {
        StringBuilder inputBuilder = new StringBuilder();
        inputBuilder.append("2000\n");
        for (int i = 0; i < 2000; i++) {
            inputBuilder.append("2 ");
        }
        inputBuilder.append("\n2000\n");
        for (int i = 0; i < 2000; i++) {
            inputBuilder.append("3 ");
        }
        inputBuilder.append("\n");
        String input = inputBuilder.toString();
        simulateUserInput(input);
        assertDoesNotThrow(() -> WarGame.main(new String[0]));
    }

}



