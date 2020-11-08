/**
 * Виды вопроса.
 */
public enum TestingTypesOfQuestion
{
    /**
     * Вопрос с единственным правильным ответом.
     */
    SINGLE_TRUE_OPTION("Вопрос с единственным правильным ответом",
            "Введите номер правильного ответа"),
    /**
     * Вопрос с множественными правильными ответами.
     */
    MULTIPLE_TRUE_OPTIONS("Вопрос с множественными правильными ответами",
            "Введите номера всех правильных вариантов ответа через запятую"),
    /** Вопрос с множественными правильными ответами */
    /**
     * Открытый вопрос.
     */
    OPENING_QUESTION("Открытый вопрос", "Введите ответ на вопрос");

    /**
     * Вид вопроса.
     */
    private String type;
    /**
     * Описание вида вопроса.
     */
    private String description;

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
     * Конструктор.
     * @param type - вид вопроса.
     * @param description - описание вида вопроса.
     */
    private TestingTypesOfQuestion(String type, String description)
    {
        this.type = type;
        this.description = description;
    }
}
