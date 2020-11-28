import java.util.Arrays;
import java.util.List;

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
     * Описание сложности вопроса.
     */
    private String complexityOfTheQuestion = new String();
    /**
     * Количество баллов.
     */
    private int score = 0;

    /**
     * Конструктор.
     * @param complexityOfTheQuestion - описание сложности вопроса.
     * @param score - количество баллов.
     */
    private TestingComplexityOfTheQuestion(int score, String complexityOfTheQuestion)
    {
        this.score = score;
        this.complexityOfTheQuestion = complexityOfTheQuestion;
    }

    /**
     * Возвращает описание сложности вопроса.
     * @return описание сложности вопроса.
     */
    public String getComplexityOfTheQuestion()
    {
        return complexityOfTheQuestion;
    }

    /**
     * Возвращает описание сложности вопроса по индексу.
     * @param index - индекс.
     * @return описание сложности вопроса.
     */
    public static String getComplexityNameAt(int index)
    {
        return getListComplexity().get(index).getComplexityOfTheQuestion();
    }

    /**
     * Возвращает сложность по индексу.
     * @param index - индекс.
     * @return сложность вопроса.
     */
    public static TestingComplexityOfTheQuestion getComplexityOfTheQuestionAt(int index)
    {
        return Arrays.asList(values()).get(index);
    }
    /**
     * Возвращает количество баллов.
     * @return количество баллов.
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Возвращает список сложностей.
     * @return список сложностей.
     */
    private static List<TestingComplexityOfTheQuestion> getListComplexity()
    {
        return Arrays.asList(values());
    }

    /**
     * Возвращает количество сложностей.
     * @return количество сложностей.
     */
    public static int complexitysCount()
    {
        return values().length;
    }
}