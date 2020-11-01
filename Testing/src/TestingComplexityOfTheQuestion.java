/**
 * Сложности вопроса.
 */
public enum TestingComplexityOfTheQuestion
{
    LOW("Легкий вопрос"),
    MEDIUM("Вопрос средней сложности"),
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