/**
 * Виды вопроса.
 */
public enum TestingTypesOfQuestion
{
    /**
     * Вопрос с единственным правильным ответом.
     */
    SINGLE_RIGHT_OPTION(1,1,"Вопрос с единственным правильным ответом",
            "Введите номер правильного ответа"),
    /**
     * Вопрос с множественными правильными ответами.
     */
    MULTIPLE_RIGHT_OPTIONS(2,9,"Вопрос с множественными правильными ответами",
            "Введите номера всех правильных вариантов ответа через запятую"),
    /** Вопрос с множественными правильными ответами */
    /**
     * Открытый вопрос.
     */
    OPENING_QUESTION(1,1,"Открытый вопрос", "Введите ответ на вопрос");

    /**
     * Минимальное количество правильных вариантов ответа.
     */
    private int minRightAnswerOptionsCount = 0;
    /**
     * Максимальное количество правильных вариантов ответа.
     */
    private int maxRightAnswerOptionsCount = 0;
    /**
     * Вид вопроса.
     */
    private String type = new String();
    /**
     * Описание вида вопроса.
     */
    private String description = new String();

    /**
     * Конструктор.
     * @param minRightAnswerOptionsCount - Минимальное количество правильных вариантов ответа.
     * @param maxRightAnswerOptionsCount - Максимальное количество правильных вариантов ответа.
     * @param type - вид вопроса.
     * @param description - описание вида вопроса.
     */
    private TestingTypesOfQuestion(int minRightAnswerOptionsCount,
                                   int maxRightAnswerOptionsCount,
                                                      String type,
                                               String description)
    {
        this.minRightAnswerOptionsCount = minRightAnswerOptionsCount;
        this.maxRightAnswerOptionsCount = maxRightAnswerOptionsCount;
        this.type = type;
        this.description = description;
    }


    /**
     * Возвращает вид вопроса.
     * @return вид вопроса.
     */
    public String getType()
    {
        return type;
    }
    /**
     * Возвращает описание вида вопроса.
     * @return описание вида вопроса.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Возвращает максимальное количество правильных вариантов ответа.
     * @return максимальное количество правильных вариантов ответа.
     */
    public int getMaxRightAnswerOptionsCount()
    {
        return maxRightAnswerOptionsCount;
    }

    /**
     * Возвращает минимальное количество правильных вариантов ответа.
     * @return минимальное количество правильных вариантов ответа.
     */
    public int getMinRightAnswerOptionsCount()
    {
        return minRightAnswerOptionsCount;
    }
}
