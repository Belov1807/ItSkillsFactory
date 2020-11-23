import java.util.ArrayList;

/**
 * Класс списка тестов.
 */
public class TestingTestsList
{
    /**
     * Список тестов.
     */
    ArrayList<TestingTheTest> testsList = new ArrayList<TestingTheTest>();

    /**
     * Конструктор.
     * @param xmlFilePath - путь к файлу.
     * @throws Exception - выбрасываемое исключение.
     */
    public TestingTestsList(String xmlFilePath) throws Exception
    {
        TestingTheTest test = new TestingTheTest(xmlFilePath);

        testsList.add(test);
    }

    /**
     * Конструктор.
     * @throws Exception - выбрасываемое исключение.
     */
    public TestingTestsList() throws Exception
    {
        TestingTheTest test = new TestingTheTest();

        testsList.add(test);
    }

    /**
     * Возвращает список тестов.
     * @return список тестов.
     */
    public ArrayList<TestingTheTest> getTestsList()
    {
        return testsList;
    }

    /**
     * Возвращает тест из листа по индексу.
     * @param index - индекс.
     * @return тест.
     */
    public TestingTheTest getTestsListAt(int index)
    {
        return testsList.get(index);
    }
}
