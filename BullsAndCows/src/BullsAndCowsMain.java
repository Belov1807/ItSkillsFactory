/* version = 0.4.0 */

import java.util.Scanner;

/**
 * Главный класс консольной версии игрового приложения "Быки и коровы".
 */
public class BullsAndCowsMain
{
    byte numberCount;
    /**
     * Конструктор.
     */
    BullsAndCowsMain()
    {
        startDialod();
        guessingDialog();
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

        numberCount = in.nextByte();

        if (numberCount != difficultyLevel.LOW.getLevel() &&
            numberCount != difficultyLevel.MEDIUM.getLevel() &&
            numberCount != difficultyLevel.HARD.getLevel())
        {
            System.out.println(difficultyLevel.LOW.getLevel());
            System.out.println(numberCount);

            System.out.println("Вы ввели некорректное значение.");
            System.out.println("Осуществляется выход из игры.");
            return;
        }
        else
        {
            System.out.println("Вы выбрали ".concat(difficultyLevel.getDescription(numberCount)));

            BullsAndCowsHiddenNumeric numeric = new BullsAndCowsHiddenNumeric(numberCount);
            System.out.println(numeric.getNumericList());
        }
    }

    /**
     * Диалог отгадывания числа.
     */
    public void guessingDialog()
    {
        System.out.println("Число загадано, попробуйте его отгадать.");
        System.out.println("Введите число равное " + numberCount + " цифрам.");

        Scanner in = new Scanner(System.in);

        BullsAndCowsInputedNumeric numeric = new BullsAndCowsInputedNumeric(in.nextInt());
        System.out.println(numeric.getInputedNumericList());

        //numeric.checkInputedNumeric();
        //System.out.println(numeric.bulls + " совпало, и они находятся на своем месте.");

    }
    public static void main (String [] args)
    {
        new BullsAndCowsMain();
    }
}
