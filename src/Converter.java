class Converter {
    // Метод для перевода количества шагов в километры
    double convertToKm(int steps) {
        // Один шаг равен 75 см, поэтому для перевода в километры делим на 0.00075
        return steps / 0.00075;
    }

    // Метод для перевода количества шагов в килокалории
    double convertStepsToKilocalories(int steps) {
        // Один шаг равен 50 калориям, поэтому для перевода в килокалории умножаем на 0.5
        return steps * 0.5;
    }
}
