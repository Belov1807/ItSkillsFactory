import java.util.ArrayList;

/**
 * Интерфейс сервиса по работе с вопросами.
 */
public interface TestingQuestionServiceInterface
{
    void addQuestion(TestingQuestion question);

    void removeQuestionAt(int index);

    String getQuestionTextAt(int index);

    String getQuestionTextFromXmlAt(int index);

    int getQuestionsXmlCount();

    /**
     * Возвращает количество вопросов в тесте.
     * @return количество вопросов в тесте.
     */
    public int getQuestionsCount();

    /**
     * Добавляет список вопросов из xml-файла.
     * @param xmlFilePath
     * @throws Exception
     */
    public void addQuestionsListFromXml(String xmlFilePath) throws Exception;

    String getComplexityAt(int index);

    String getAuthorAt(int index);

    String getTypeAt(int index);

    ArrayList<String> getAnswerOptionsAt(int index);

    ArrayList<String> getRightAnswerOptionsAt(int index);

    void renameQuestionTextAt(int index, String textQuestion);
}
