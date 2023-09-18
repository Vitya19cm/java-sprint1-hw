import java.util.Scanner;


class StepTracker {
    private Scanner scanner;
    private MonthData[] monthToData = new MonthData[12];
    private int goalByStepsPerDay = 10000; // Значение цели по умолчанию
    int getStepGoal() {
        return goalByStepsPerDay;
    }

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    // Метод для изменения цели по количеству шагов в день
    void changeStepGoal() {
        System.out.println("Введите новую цель по количеству шагов в день (больше нуля):");
        int newGoal = scanner.nextInt();
        if (newGoal > 0) {
            goalByStepsPerDay = newGoal;
            System.out.println("Цель успешно изменена.");
        } else {
            System.out.println("Некорректное значение цели. Цель не изменена.");
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца (от 1 до 12):");
        int monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Некорректный номер месяца.");
            return;
        }

        System.out.println("Введите день (от 1 до 30 включительно):");
        int dayNumber = scanner.nextInt();
        if (dayNumber < 1 || dayNumber > 30) {
            System.out.println("Некорректный номер дня.");
            return;
        }

        System.out.println("Введите количество шагов (положительное число):");
        int steps = scanner.nextInt();
        if (steps <= 0) {
            System.out.println("Некорректное количество шагов.");
            return;
        }

        // Получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[monthNumber - 1]; // Вычитаем 1, чтобы получить индекс массива

        // Сохранение полученных данных
        monthData.days[dayNumber - 1] = steps; // Вычитаем 1, чтобы получить индекс массива
    }


    private Converter converter = new Converter(); // Поле для хранения экземпляра Converter

    // Метод для вывода статистики
    void printStatistic() {
        System.out.println("Введите номер месяца (от 1 до 12):");
        int monthNumber = scanner.nextInt();

        if (monthNumber >= 1 && monthNumber <= 12) {
            MonthData monthData = monthToData[monthNumber - 1]; // Получение соответствующего месяца

            System.out.println("Статистика для месяца " + monthNumber + ":");

            // Вывод количества шагов по дням
            monthData.printDaysAndStepsFromMonth();

            // Вывод общего количества шагов за месяц
            int sumSteps = monthData.sumStepsFromMonth();
            System.out.println("Общее количество шагов за месяц: " + sumSteps);

            // Вывод максимального пройденного количества шагов за месяц
            int maxSteps = monthData.maxSteps();
            System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);

            // Вывод среднего количества шагов за месяц
            double averageSteps = (double) sumSteps / 30;
            System.out.println("Среднее количество шагов за месяц: " + averageSteps);

            // Вывод пройденной за месяц дистанции в км
            int distanceInKm = converter.convertToKm(sumSteps);
            System.out.println("Пройденная за месяц дистанция: " + distanceInKm + " км");

            // Вывод количества сожжённых килокалорий за месяц
            int kilocaloriesBurned = converter.convertStepsToKilocalories(sumSteps);
            System.out.println("Количество сожжённых килокалорий за месяц: " + kilocaloriesBurned + " килокалорий");

            // Вывод лучшей серии
            int bestSeries = monthData.bestSeries(getStepGoal());
            System.out.println("Лучшая серия: " + bestSeries + " дней");
        } else {
            System.out.println("Некорректный номер месяца.");
        }
    }
}