/**
 * Виды вопроса.
 */
public enum TestingTypesOfQuestion
{
    /**
     * Вопрос с единственным правильным ответом.
     */
    SINGLE_RIGHT_OPTION(1,1,"Вопрос с единственным правильным ответом",
            "\nВведите номер правильного варианта ответа"),
    /**
     * Вопрос с множественными правильными ответами.
     */
    MULTIPLE_RIGHT_OPTIONS(2,9,"Вопрос с множественными правильными ответами",
            "\nВведите номера всех правильных вариантов ответа через запятую"),
    /** Вопрос с множественными правильными ответами */
    /**
     * Открытый вопрос.
     */
    OPENING_QUESTION(1,1,"Открытый вопрос", "\nВведите ответ на вопрос");

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
     * Информация для пользователя.
     */
    private String userInfo = new String();

    /**
     * Конструктор.
     * @param minRightAnswerOptionsCount - Минимальное количество правильных вариантов ответа.
     * @param maxRightAnswerOptionsCount - Максимальное количество правильных вариантов ответа.
     * @param type - вид вопроса.
     * @param userInfo - информация для пользователя.
     */
    private TestingTypesOfQuestion(int minRightAnswerOptionsCount,
                                   int maxRightAnswerOptionsCount,
                                                      String type,
                                                  String userInfo)
    {
        this.minRightAnswerOptionsCount = minRightAnswerOptionsCount;
        this.maxRightAnswerOptionsCount = maxRightAnswerOptionsCount;
        this.type = type;
        this.userInfo = userInfo;
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
     * Возвращает информацию для пользователя.
     * @return информация для пользователя
     */
    public String getUserInfo()
    {
        return userInfo;
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
