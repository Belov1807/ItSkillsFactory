import java.util.*;

/**
 * Класс загаданного числа.
 */
public class BullsAndCowsHiddenNumeric
{
    /**
     * Количество цифр.
     */
    int numberCount;

    /**
     * Список цифр загаданного числа.
     */
    ArrayList numericList = new ArrayList();

    /**
     * Возвращает список цифр загаданного числа.
     * @return список цифр загаданного числа.
     */
    public ArrayList getNumericList() {
        return numericList;
    }

    /**
     * Конструктор.
     * @param numberCount - количество цифр в числе.
     */
    BullsAndCowsHiddenNumeric(byte numberCount)
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
        for (int i = 0; i < numericList.size(); i ++)
        {
            strNumeric += (numericList.get(i).toString());
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

            while (numericList.contains(rand))
            {
                rand = (int)(Math.random() * 9);
            }
            numericList.add(rand);
        }
    }
}

