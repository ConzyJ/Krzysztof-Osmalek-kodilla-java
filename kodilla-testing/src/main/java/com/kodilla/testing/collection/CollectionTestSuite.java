package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@DisplayName("Testy klasy OddNumbersExterminator")
public class CollectionTestSuite {
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
        // Given
        List<Integer> emptyList = Collections.emptyList();

        // When
        List<Integer> result = exterminator.exterminate(emptyList);

        // Then
        Assertions.assertTrue(result.isEmpty(), "Lista wynikowa powinna być pusta");
    }

    @Test
    @DisplayName("Test listy z liczbami parzystymi i nieparzystymi")
    void testOddNumbersExterminatorNormalList() {
        // Given
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> expectedList = Arrays.asList(2, 4, 6, 8);

        // When
        List<Integer> result = exterminator.exterminate(inputList);

        // Then
        Assertions.assertEquals(expectedList, result, "Lista wynikowa powinna zawierać tylko liczby parzyste");
    }
}
