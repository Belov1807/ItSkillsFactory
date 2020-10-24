/* version = 0.2.0 */

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
        int difficultyLevel = in.nextInt();

        if (difficultyLevel < 3 | difficultyLevel > 5)
        {
            System.out.println("Вы ввели некорректное значение.");
            System.out.println("Осуществляется выход из игры.");
            return;
        }
        else
        {
            String strDifficultyLevel = new String();
            if (difficultyLevel == 3)
            {
                strDifficultyLevel = "самый легкий уровень: ***.";
            }
            if (difficultyLevel == 4)
            {
                strDifficultyLevel = "средний уровень сложности : ****.";
            }
            if (difficultyLevel == 5)
            {
                strDifficultyLevel = "самый сложный уровень: *****.";
            }

            System.out.println("Вы выбрали ".concat(strDifficultyLevel));

            BullsAndCowsNumeric numeric = new BullsAndCowsNumeric(difficultyLevel);
            System.out.println(numeric.getNumeric());
        }
    }

    public static void main (String [] args)
    {
        new BullsAndCowsMain();
    }
}
