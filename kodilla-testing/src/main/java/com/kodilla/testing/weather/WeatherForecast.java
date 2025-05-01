package com.kodilla.testing.weather;

import java.util.HashMap;
import java.util.Map;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        double sum = 0;
        int count = temperatures.getTemperatures().size();
        for (double temp : temperatures.getTemperatures().values()) {
            sum += temp;
        }
        return count > 0 ? sum / count : 0;
    }

    public double calculateMedianTemperature() {
        var values = temperatures.getTemperatures().values().stream()
                .sorted().toList();
        int size = values.size();
        if (size == 0) return 0;
        if (size % 2 == 0) {
            return (values.get(size / 2 - 1) + values.get(size / 2)) / 2.0;
        } else {
            return values.get(size / 2);
        }
    }
}
