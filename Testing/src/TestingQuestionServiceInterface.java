import javafx.util.Pair;

import java.util.ArrayList;

/**
 * Интерфейс сервиса по работе с вопросами.
 */
public interface TestingQuestionServiceInterface
{
    /**
     * Добавляет вопрос.
     * @param questionText       - текст вопроса.
     * @param complexityNumber   - номер сложности вопроса.
     * @param author             - автор вопроса.
     * @param answersOptionsList - список пар верный ответ - вариант ответа.
     */
    void addQuestion(String questionText, int complexityNumber, String author,
                     ArrayList<Pair<Boolean, String>> answersOptionsList);

    /**
     * Удалить вопрос.
     */
    void removeQuestionAt(int index);

    /**
     * Возвращает текст вопроса из по индексу.
     * @param index - индекс вопроса.
     * @return текст вопроса из по индексу.
     */
    String getQuestionTextAt(int index);

    /**
     * Возвращает текст вопроса из xml-файла по индексу.
     * @param index - индекс вопроса.
     * @return текст вопроса из xml-файла по индексу.
     */
    String getQuestionTextFromXmlAt(int index);

    /**
     * Возвращает количество вопросов в xml-файле.
     * @return
     */
    int getQuestionsXmlCount();

    /**
     * Возвращает количество вопросов в тесте.
     * @return количество вопросов в тесте.
     */
    int getQuestionsCount();

    /**
     * Добавляет список вопросов из xml-файла.
     * @param xmlFilePath - путь к xml-файлу.
     * @throws Exception
     */
    void addQuestionsListFromXml(String xmlFilePath) throws Exception;

    /**
     * Возвращает описание сложности вопроса.
     * @param index - индекс вопроса.
     * @return описание сложности вопроса.
     */
    String getComplexityAt(int index);

    /**
     * Возврашает автора вопроса по индексу вопроса.
     * @param index - индекс вопроса.
     * @return автор.
     */
    String getAuthorAt(int index);

    /**
     * Возвращает вид вопроса по индексу вопроса.
     * @param index - индекс вопроса.
     * @return вид вопроса.
     */
    String getTypeAt(int index);

    /**
     * Возвращает информацию для пользователя о типе вопроса.
     * @param index - индекс вопроса.
     * @return информация для пользователя о типе вопроса.
     */
    String getTypeUserInfoAt(int index);

    /**
     * Возвращает максимальное количество вариантов ответа у выбранного вопроса.
     * @param index - индекс вопроса.
     * @return максимальное количество вариантов ответа.
     */
    int getMaxRightAnswerOptionsCountAt(int index);

    /**
     * Возвращает минимальное количество вариантов ответа у выбранного вопроса.
     * @param index - индекс вопроса.
     * @return минимальное количество вариантов ответа.
     */
    int getMinRightAnswerOptionsCountAt(int index);

    /**
     * Возвращает список вариантов ответа по индексу вопроса.
     * @param index - индекс вопроса.
     * @return список вариантов ответа.
     */
    ArrayList<String> getAnswerOptionsAt(int index);

    /**
     * Возвращает список правильных вариантов ответа по индексу вопроса.
     * @param index - индекс вопроса.
     * @return список правильных вариантов ответа.
     */
    ArrayList<String> getRightAnswerOptionsAt(int index);

    /**
     * Устанавливает текст вопрос
     * @param index        - индекс вопроса.
     * @param textQuestion - текст вопроса
     */
    void renameQuestionTextAt(int index, String textQuestion);

    /**
     * Возвращает балл на который оценивается выбранный вопрос.
     * @param index - индекс вопроса.
     * @return балл на который оценивается выбранный вопрос.
     */
    int getScoreQuestionAt(int index);
}
