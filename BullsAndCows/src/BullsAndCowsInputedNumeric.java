import java.util.ArrayList;

/**
 * Класс числа введенного пользователем.
 */
public class BullsAndCowsInputedNumeric {
    /**
     * Введенное пользователем число.
     */
    int inputedNumeric;

    /**
     * Список цифр введенных пользователем.
     */
    ArrayList inputedNumericList = new ArrayList();

    /**
     * Констуктор.
     *
     * @param inputedNumeric - введенное пользователем число.
     */
    BullsAndCowsInputedNumeric(int inputedNumeric) {
        this.inputedNumeric = inputedNumeric;
        CreateInputedNumericList();
    }

    /**
     * Возвращает число введенное пользователем в виде списка цифр.
     * @return список цифр.
     */
    public ArrayList getInputedNumericList()
    {
        return inputedNumericList;
    }

    /**
     * Устанавливает список цифр цисла введенного пользователем.
     */
    private void CreateInputedNumericList() {
        String strInputedNumeric = new String();

        strInputedNumeric += inputedNumeric;

        for (int i = 0; i < strInputedNumeric.length(); i++)
        {
            strInputedNumeric.charAt(i);
            byte inputNumericElement = (byte) strInputedNumeric.charAt(i);

            inputedNumericList.add(inputNumericElement - 48);
        }
    }
}
