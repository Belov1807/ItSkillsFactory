import java.util.*;

/**
 * Класс загадонного числа.
 */
public class BullsAndCowsNumeric
{
    /**
     * Количество цифр.
     */
    int numberCount;

    /**
     * Число состоящее из цифр.
     */
    ArrayList numeric = new ArrayList();

    /**
     * Конструктор.
     * @param numberCount - количество цифр в числе.
     */
    BullsAndCowsNumeric(int numberCount)
    {
        this.numberCount = numberCount;
        createNumeric();
    }

    /**
     * Возвращает число состоящее из цифр.
     * @return число сосоящее из цифр.
     */
    String getNumeric()
    {
        String strNumeric = new String();
        for (int i = 0; i < numeric.size(); i ++)
        {
            strNumeric += (numeric.get(i).toString());
        }
        return strNumeric;
    }

    /**
     * Создает число состоящее из случайных неповторяющихся цифр
     * которое пользователь должен угадать.
     */
    private void createNumeric()
    {
        for (int i = 0; i < numberCount; i ++)
        {
            int rand = (int)(Math.random() * 9);

            while (numeric.contains(rand))
            {
                rand = (int)(Math.random() * 9);
            }
            numeric.add(rand);
        }
    }
}

