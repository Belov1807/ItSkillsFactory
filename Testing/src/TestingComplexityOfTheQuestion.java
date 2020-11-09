/**
 * Сложности вопроса.
 */
public enum TestingComplexityOfTheQuestion
{
    /**
     * Легкий вопрос.
     */
    LOW(1,"Легкий вопрос"),
    /**
     * Вопрос средней сложности.
     */
    MEDIUM(2,"Вопрос средней сложности"),
    /**
     * Сложный вопрос.
     */
    HARD(3,"Сложный вопрос");

    /**
     * Сложность вопроса.
     */
    private String complexityOfTheQuestion = new String();
    /**
     * Количество баллов.
     */
    private int score = 0;

    /**
     * Конструктор.
     * @param complexityOfTheQuestion - сложность вопроса.
     * @param score - количество баллов.
     */
    private TestingComplexityOfTheQuestion(int score, String complexityOfTheQuestion)
    {
        this.score = score;
        this.complexityOfTheQuestion = complexityOfTheQuestion;
    }

    /**
     * Возвращает сложность вопроса.
     * @return сложность вопроса.
     */
    public String getComplexityOfTheQuestion()
    {
        return complexityOfTheQuestion;
    }

    /**
     * Возвращает количество баллов.
     * @return количество баллов.
     */
    public int getScore()
    {
        return score;
    }
}