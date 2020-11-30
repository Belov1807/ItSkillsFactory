import java.util.ArrayList;

/**
 * Сервис по работе с тестами.
 */
public class TestingTestService implements TestingTestServiceInterface
{
    TestingQuestionServiceInterface question;
    /**
     * Список тестов.
     */
    private ArrayList<TestingTheTest> testsList = new ArrayList<TestingTheTest>();

    /**
     * Конструктор.
     */
    public TestingTestService()
    {
    }

    /**
     * Добавляет тест в список.
     * @param testName - имя теста.
     * @throws Exception - выбрасываемое исключение.
     */
    @Override
    public void addTest(String testName) throws Exception
    {
        checkFoundTestName(testName);

        TestingTheTest test = new TestingTheTest();
        test.setTestName(testName);
        testsList.add(test);
    }

    /**
     * Изменяет название у теста по индексу.
     * @param index - индекс.
     * @param newTestName - новое название теста.
     * @throws Exception - выбрасываемое исключение.
     */
    @Override
    public void renameTest(int index, String newTestName) throws Exception
    {
        checkFoundTestName(newTestName);

        testsList.get(index).setTestName(newTestName);
    }

    /**
     * Возвращает количество тестов.
     * @return количество тестов.
     */
    @Override
    public int getTestsCount()
    {
        return testsList.size();
    }

    /**
     * Возвращает имя теста по индексу.
     * @param  - индекс.
     * @return имя теста.
     */
    @Override
    public String getTestNameAt(int index)
    {
        return testsList.get(index).getTestName();
    }

    /**
     * Удаляет тест по индексу.
     */
    @Override
    public void removeTestAt(int index)
    {
        testsList.remove(index);
    }

    /**
     * Проверяет существование заданого имени теста в списке.
     * @param testName - имя теста.
     * @throws Exception - выбрасываемое исключение.
     */
    private void checkFoundTestName(String testName) throws Exception
    {
        for (int i = 0; i < getTestsCount(); i ++)
        {
            if (getTestNameAt(i).equals(testName))
            {
                throw new Exception("Тест с названием \"" + testName + "\" уже существует");
            }
        }
    }

    @Override
    public TestingQuestionServiceInterface getQuestionServiceTestAt(int index)
    {
        return testsList.get(index).getQuestionService();
    }

    @Override
    public int getAllScores()
    {int scores = 0;
        for (int i = 0; i < question.getQuestionsCount(); i ++)
        {
            scores += question.getScoreQuestionAt(i);
        }

        return scores;
    }
}
