
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();

            int i = scanner.nextInt();
            if (i == 1) {
                stepTracker.addNewNumberStepsPerDay();
                System.out.println("Выполняется команда 1: Введите количество шагов за день.");
            } else if (i == 2) {
                stepTracker.changeStepGoal();
                System.out.println("Выполняется команда 2: Измените цель по количеству шагов в день.");
            } else if (i == 3) {
                stepTracker.printStatistic();
                System.out.println("Выполняется команда 3: Введите месяц для вывода статистики.");
            } else if (i == 4) {
                System.out.println("Пока!");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды нет");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 - Ввести количество шагов за день");
        System.out.println("2 - Изменить цель по количеству шагов в день");
        System.out.println("3 - Вывести статистику за определенный месяц");
        System.out.println("4 - Выйти из приложения");
        System.out.print("Введите номер команды: ");
    }
}
