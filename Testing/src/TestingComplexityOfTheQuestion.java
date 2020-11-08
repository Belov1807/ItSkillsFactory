/**
 * Сложности вопроса.
 */
public enum TestingComplexityOfTheQuestion
{
    /**
     * Легкий вопрос.
     */
    LOW("Легкий вопрос"),
    /**
     * Вопрос средней сложности.
     */
    MEDIUM("Вопрос средней сложности"),
    /**
     * Сложный вопрос.
     */
    HARD("Сложный вопрос");

    /**
     * Сложность вопроса.
     */
    private String complexityOfTheQuestion;

    /**
     * Возвращает сложность вопроса.
     * @return сложность вопроса.
     */
    public String getComplexityOfTheQuestion()
    {
        return complexityOfTheQuestion;
    }

    /**
     * Конструктор.
     * @param complexityOfTheQuestion - сложность вопроса.
     */
    private TestingComplexityOfTheQuestion(String complexityOfTheQuestion)
    {
        this.complexityOfTheQuestion = complexityOfTheQuestion;
    }

}