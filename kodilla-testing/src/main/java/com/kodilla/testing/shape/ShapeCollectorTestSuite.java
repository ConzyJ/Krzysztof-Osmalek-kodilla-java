package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testy klasy ShapeCollector")
public class ShapeCollectorTestSuite {

    private ShapeCollector shapeCollector;

    @BeforeEach
    void setUp() {
        shapeCollector = new ShapeCollector();
        System.out.println("Rozpoczynam test...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test zakończony.");
    }

    @Nested
    @DisplayName("Testy dodawania i usuwania figur")
    class AddRemoveFigures {

        @Test
        @DisplayName("Dodanie figury do kolekcji")
        void testAddFigure() {
            // Given
            Shape shape = new Circle(5.0);

            // When
            shapeCollector.addFigure(shape);

            // Then
            assertEquals(1, shapeCollector.getShapes().size(), "Lista figur powinna zawierać 1 element");
        }

        @Test
        @DisplayName("Usunięcie figury z kolekcji")
        void testRemoveFigure() {
            // Given
            Shape shape = new Triangle(3.0, 4.0);
            shapeCollector.addFigure(shape);

            // When
            shapeCollector.removeFigure(shape);

            // Then
            assertEquals(0, shapeCollector.getShapes().size(), "Lista figur powinna być pusta");
        }
    }

    @Nested
    @DisplayName("Testy pobierania i wyświetlania figur")
    class GetShowFigures {

        @Test
        @DisplayName("Pobranie figury po indeksie")
        void testGetFigure() {
            // Given
            Shape shape = new Square(4.0);
            shapeCollector.addFigure(shape);

            // When
            Shape retrievedShape = shapeCollector.getFigure(0);

            // Then
            assertEquals(shape, retrievedShape, "Figura powinna być identyczna");
        }

        @Test
        @DisplayName("Wyświetlanie listy figur")
        void testShowFigures() {
            // Given
            shapeCollector.addFigure(new Circle(5.0));
            shapeCollector.addFigure(new Triangle(3.0, 4.0));

            // When
            List<Shape> figures = shapeCollector.getShapes();

            // Then
            assertEquals(2, figures.size(), "Lista powinna zawierać 2 figury");
        }
    }
}
