package com.kodilla.testing.weather;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testy klasy WeatherForecast")
class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;
    private WeatherForecast weatherForecast;

    @BeforeEach
    void setUp() {
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);

        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        weatherForecast = new WeatherForecast(temperaturesMock);
        System.out.println("Rozpoczynam test...");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test zakończony.");
    }

    @Test
    @DisplayName("Test obliczania prognozy")
    void testCalculateForecastWithMock() {
        // When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        // Then
        assertEquals(5, quantityOfSensors, "Prognoza powinna zawierać 5 miast");
    }

    @Test
    @DisplayName("Test obliczania średniej temperatury")
    void testCalculateAverageTemperature() {
        // When
        double averageTemperature = weatherForecast.calculateAverageTemperature();

        // Then
        assertEquals(25.56, averageTemperature, 0.01, "Średnia temperatura powinna wynosić 25.56");
    }

    @Test
    @DisplayName("Test obliczania mediany temperatury")
    void testCalculateMedianTemperature() {
        // When
        double medianTemperature = weatherForecast.calculateMedianTemperature();

        // Then
        assertEquals(25.2, medianTemperature, 0.01, "Mediana temperatury powinna wynosić 25.2");
    }
}
