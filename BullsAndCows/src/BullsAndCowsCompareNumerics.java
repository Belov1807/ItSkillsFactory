import java.util.ArrayList;

/**
 * Класс сравнения чисел.
 */
public class BullsAndCowsCompareNumerics
{
    /**
     * Загаданное число.
     */
    ArrayList hiddenNumericList;
    /**
     * Введенное пользователем число.
     */
    ArrayList userNumericList;

    /**
     * Количество угаданных цифр находящихся на правильных позициях.
     */
    int bulls;
    /**
     * Количество угаданных цифр находящихся на не правильных позициях.
     */
    int cows;

    /**
     * Состояние победы пользователя.
     */
    boolean win;

    /**
     * Возвращает количество угаданных цифр находящихся на правильных позициях.
     * @return - количество цифр.
     */
    public int getBulls()
    {
        return bulls;
    }
    /**
     * Возвращает количество угаданных цифр находящихся на не правильных позициях.
     * @return - количество цифр.
     */
    public int getCows()
    {
        return cows;
    }

    /**
     * Возвращает состояние победы пользователя.
     * @return true - пользователь победил.
     */
    public boolean isWin()
    {
        return win;
    }

    /**
     * Конструктор.
     * @param hiddenNumericList - загаданное число.
     * @param userNumericList -введенное пользователем число.
     */
    BullsAndCowsCompareNumerics(ArrayList hiddenNumericList, ArrayList userNumericList)
    {
        this.hiddenNumericList = hiddenNumericList;
        this.userNumericList = userNumericList;
        compareNumerics();
    }

    /**
     * Сравнение чисел.
     */
    public void compareNumerics()
    {
        for (int i = 0; i < hiddenNumericList.size(); i ++)
        {
            if (hiddenNumericList.get(i) == userNumericList.get(i))
            {
                 bulls ++;
            }
            if (userNumericList .contains(hiddenNumericList.get(i)) &&
                userNumericList.get(i) != hiddenNumericList.get(i))
            {
                cows ++;
            }
        }
        if (bulls == hiddenNumericList.size())
        {
            win = true;
        }
    }
}

