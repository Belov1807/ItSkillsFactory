/**
 * Интерфейс сервиса по работе с тестами.
 */
public interface TestingTestServiceInterface
{
    /**
     * Добавляет тест в список.
     * @param testName - имя теста.
     * @throws Exception - выбрасываемое исключение.
     */
    public void addTest(String testName) throws Exception;

    /**
     * Изменяет название у теста по индексу.
     * @param index - индекс.
     * @param newTestName - новое название теста.
     * @throws Exception - выбрасываемое исключение.
     */
    void renameTest(int index, String newTestName) throws Exception;

    /**
     * Возвращает количество тестов.
     * @return количество тестов.
     */
    int getTestsCount();

    /**
     * Возвращает имя теста по индексу.
     * @param  - индекс.
     * @return имя теста.
     */
    String getTestNameAt(int index);

    /**
     * Удаляет тест по индексу.
     */
    void removeTestAt(int index);
}