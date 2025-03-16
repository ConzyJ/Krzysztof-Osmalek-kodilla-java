
import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@DisplayName("Testy klasy OddNumbersExterminator")
class CollectionTestSuite {
    private OddNumbersExterminator exterminator;

    @BeforeEach
    void setUp() {
        exterminator = new OddNumbersExterminator();
        System.out.println("Rozpoczynam test...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test zakończony.");
    }

    @Test
    @DisplayName("Test pustej listy")
    void testOddNumbersExterminatorEmptyList() {

        List<Integer> emptyList = Collections.emptyList();


        List<Integer> result = exterminator.exterminate(emptyList);


        assertTrue(result.isEmpty(), "Lista wynikowa powinna być pusta");
    }

    @Test
    @DisplayName("Test listy z liczbami parzystymi i nieparzystymi")
    void testOddNumbersExterminatorNormalList() {

        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> expectedList = Arrays.asList(2, 4, 6, 8);


        List<Integer> result = exterminator.exterminate(inputList);


        assertEquals(expectedList, result, "Lista wynikowa powinna zawierać tylko liczby parzyste");
    }
}
