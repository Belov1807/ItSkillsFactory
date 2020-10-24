/* version = 0.3.0 */

import java.util.Scanner;

/**
 * Главный класс консольной версии игрового приложения "Быки и коровы".
 */
public class BullsAndCowsMain
{
    /**
     * Конструктор.
     */
    BullsAndCowsMain()
    {
        startDialod();
    }
    /**
     * Первоначальный диалог с пользователем.
     */
    public void startDialod()
    {
        System.out.println("Добро пожаловать в игру \"Быки и коровы\" !\n");
        System.out.println("Правила игры: Вы должны угадать загаданное число.");
        System.out.println("Задайте сложность игры (3, 4 или 5).");

        Scanner in = new Scanner(System.in);

        int inputedValue = in.nextInt();

        if (inputedValue != difficultyLevel.LOW.getLevel() &&
            inputedValue != difficultyLevel.MEDIUM.getLevel() &&
            inputedValue != difficultyLevel.HARD.getLevel())
        {
            System.out.println(difficultyLevel.LOW.getLevel());
            System.out.println(inputedValue);

            System.out.println("Вы ввели некорректное значение.");
            System.out.println("Осуществляется выход из игры.");
            return;
        }
        else
        {
            System.out.println("Вы выбрали ".concat(difficultyLevel.getDescription(inputedValue)));

            BullsAndCowsNumeric numeric = new BullsAndCowsNumeric(inputedValue);
            System.out.println(numeric.getNumeric());
        }
    }

    public static void main (String [] args)
    {
        new BullsAndCowsMain();
    }
}
