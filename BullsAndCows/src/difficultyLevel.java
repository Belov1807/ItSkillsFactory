/**
 * Уровни сложности игры.
 */
public enum difficultyLevel
{
    LOW(3, "самый легкий уровень: ***."),           /**< Самый легкий уровень.*/
    MEDIUM(4, "средний уровень сложности : ****."), /**< Средний уровень сложности.*/
    HARD(5, "самый сложный уровень: *****.");       /**< Самый сложный уровень.*/

    /**
     * Введенное пользователем значение.
     */
    int level;
    /**
     * Описание уровня.
     */
    String description;

    /**
     * Возвращает введенное пользователем значение.
     * @return введенное пользователем значение.
     */
    public int getLevel()
    {
        return level;
    }
    /**
     * Возвращает описание уровня.
     * @return описание уровня.
     */
    public String getDescription()
    {
        return description;
    }
    /**
     * Возвращает описание уровня по введенному значению.
     * @param inputedValue -введенное пользователем значение.
     * @return - описание уровня.
     */
    public static String getDescription(int inputedValue)
    {
        if (inputedValue == LOW.getLevel())
        {
            return LOW.getDescription();
        }
        if (inputedValue == MEDIUM.getLevel())
        {
            return MEDIUM.getDescription();
        }
        if (inputedValue == HARD.getLevel())
        {
            return HARD.getDescription();
        }
        return null;
    }

    /**
     * Конструктор.
     * @param level - введенное пользователем значение.
     * @param description - описание уровня.
     */
    difficultyLevel(int level, String description)
    {
        this.level = level;
        this.description = description;
    }
}

