/* version = 0.6.0 */

import java.util.Scanner;

/**
 * Главный класс консольной версии игрового приложения "Быки и коровы".
 */
public class BullsAndCowsMain
{
    /**
     * Количество цифр в числе заданное пользователем при выборе уровня сложности.
     */
    byte numberCount = 0;

    /**
     * Введенное пользователем число.
     */
    int inputedNumeric = 0;

    /**
     * Количество попыток отгадать число.
     */
    int attemptsCount = 0;

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
            System.exit(0);
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
        attemptsCount ++;

        System.out.println("Число загадано, попробуйте его отгадать.");
        System.out.println("Попытка № " + attemptsCount);
        System.out.println("Введите число равное " + numberCount + " цифрам.");

        BullsAndCowsHiddenNumeric hiddenNumeric = new BullsAndCowsHiddenNumeric(numberCount);
        guessingProcess(hiddenNumeric);

        System.out.println("Поздравляем Вы победили!" );
        System.out.println("Загаданное число действительно " + hiddenNumeric.getNumeric());
        System.out.println("Вы угадали это число с " + attemptsCount + " попыток.");
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

            boolean isInt  = in.hasNextInt();
            String line =  in.nextLine();
            boolean isValidInputedNumeric = false;

            if ((line.length() == numberCount &&
                 isInt == true &&
                 line.charAt(0) != 48) ||
                 line.equals("сдаюсь"))
            {

                isValidInputedNumeric = true;
            }

            while(isValidInputedNumeric == false)
            {
                System.out.println("Введенное число не соответствует условию.");
                System.out.println("Попробуйте еще раз.\n");
                System.out.println("Введите число равное " + numberCount + " цифрам.");

                isInt = in.hasNextInt();
                line = in.nextLine();

                if ((line.length() == numberCount &&
                    isInt == true &&
                    line.charAt(0) != 48) ||
                    line.equals("сдаюсь"))
                {
                    isValidInputedNumeric = true;
                }
            }

            if (line.equals("сдаюсь"))
            {
                System.out.println("Очень жаль что Вы не смогли отгадать число!");
                System.out.println("Было загаданно число " + hiddenNumeric.getNumeric());
                System.out.println("Осуществляется выход из программы.");
                System.exit(0);
            }

            Scanner input = new Scanner(line);
            inputedNumeric = input.nextInt();

            BullsAndCowsInputedNumeric userNumeric = new BullsAndCowsInputedNumeric(inputedNumeric);
            BullsAndCowsCompareNumerics compare = new BullsAndCowsCompareNumerics(
                    hiddenNumeric.getNumericList(), userNumeric.getInputedNumericList());

            win = compare.isWin();

            if (win == false)
            {
                attemptsCount ++;

                System.out.println("К сожалению Вы не угадали загаданное число.");
                System.out.println("В введенном Вами числе:");
                System.out.println(compare.getBulls() + " цифр(ы) находятся на правильных позициях.");
                System.out.println(compare.getCows() + " цифр(ы) находядятся на не правильных позициях.\n");

                System.out.println("=====================================");
                System.out.println("Попытка № " + attemptsCount);
                System.out.println("Попробуйте еще раз. Введите число равное " + numberCount + " цифрам.");
                System.out.println("Если не хотите больше делать попыток, ведите \"сдаюсь\"");
            }
        }
    }
    public static void main (String [] args)
    {
        new BullsAndCowsMain();
    }
}