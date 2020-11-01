/**
 * Виды вопроса.
 */
public enum TestingTypesOfQuestion
{
    SINGLE_TRUE_OPTION("Вопрос с единственным правильным ответом", "Выберите правильный ответ"),
    /**< Вопрос с единственным правильным ответом */
    MULTIPLE_TRUE_OPTIONS("Вопрос с множественными правильными ответами", "Выберите все правильные варианты ответа"),
    /**< Вопрос с множественными правильными ответами */
    OPENING_QUESTION("Открытый вопрос", "Запишите ответ на вопрос");
    /**< Открытый вопрос */

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
