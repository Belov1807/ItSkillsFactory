/**
 * Класс теста.
 */
public class TestingTheTest
{
    /**
     * Общее количество баллов за все вопросы.
     */
    private int allScores = 0;
    /**
     * Список вопросов.
     */
    private TestingQuestionServiceInterface questionService = new TestingQuestionService();
    /**
     * Название теста.
     */
    private String testName = new String();

    /**
     * Конструктор.
     */
    public TestingTheTest() throws Exception
    {
    }

    /**
     * Возвращает имя теста.
     * @return
     */
    public String getTestName()
    {
        return testName;
    }

    /**
     * Устанавливает имя теста.
     * @param testName - имя теста.
     */
    public void setTestName(String testName)
    {
        this.testName = testName;
    }

    public TestingQuestionServiceInterface getQuestionService()
    {
        return questionService;
    }
}
