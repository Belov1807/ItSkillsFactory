/* version = 0.5.0 */

import java.util.Scanner;

/**
 * Главный класс консольной версии игрового приложения "Быки и коровы".
 */
public class BullsAndCowsMain
{
    /**
     * Количество цифр в числе заданное пользователем при выборе уровня сложности.
     */
    byte numberCount;

    /**
     * Введенное пользователем число.
     */
    int inputedNumeric;
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
        }
    }

    /**
     * Диалог отгадывания числа.
     */
    public void guessingDialog()
    {
        System.out.println("Число загадано, попробуйте его отгадать.");
        System.out.println("Введите число равное " + numberCount + " цифрам.");

        BullsAndCowsHiddenNumeric hiddenNumeric = new BullsAndCowsHiddenNumeric(numberCount);

        guessingProcess(hiddenNumeric);
        System.out.println("Поздравляем Вы победили!" );
        System.out.println("Загаданное число действительно " + hiddenNumeric.getNumeric());
    }

    /**
     * Процесс угадывания числа.
     * @param hiddenNumeric - загаданное число.
     */
    public void guessingProcess(BullsAndCowsHiddenNumeric hiddenNumeric)
    {
        boolean win = false;

        while (win == false)
        {
            Scanner in = new Scanner(System.in);
            inputedNumeric = in.nextInt();

            BullsAndCowsInputedNumeric userNumeric = new BullsAndCowsInputedNumeric(inputedNumeric);
            BullsAndCowsCompareNumerics compare = new BullsAndCowsCompareNumerics(
                    hiddenNumeric.getNumericList(), userNumeric.getInputedNumericList());

            win = compare.isWin();

            if (win == false)
            {
                System.out.println("К сожалению Вы не угадали загаданное число.");
                System.out.println("В введенном Вами числе:");
                System.out.println(compare.getBulls() + " цифр(ы) находятся на правильных позициях.");
                System.out.println(compare.getCows() + " цифр(ы) находядятся на не правильных позициях.\n");

                System.out.println("Попробуйте еще раз. Введите число равное " + numberCount + " цифрам.");
            }
        }
    }
    public static void main (String [] args)
    {
        new BullsAndCowsMain();
    }
}
