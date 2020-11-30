import java.util.ArrayList;
import java.util.Scanner;

/**
 * Сервис по работе с вопросами.
 */
public class TestingQuestionService implements TestingQuestionServiceInterface
{
    /**
     * Список вопросов.
     */
    private ArrayList<TestingQuestion> questionsList = new ArrayList<TestingQuestion>();

    private ArrayList<TestingQuestion> questionsListFromXml = new ArrayList<TestingQuestion>();


    /**
     * Добавить вопрос.
     */
    @Override
    public void addQuestion(TestingQuestion question)
    {
    }

    /**
     * Удалить вопрос.
     */
    @Override
    public void removeQuestionAt(int index)
    {
        questionsList.remove(index);
    }

    /**
     * Возвращает текст вопроса из по индексу.
     * @param index - индекс вопроса.
     * @return текст вопроса из по индексу.
     */
    @Override
    public String getQuestionTextAt(int index)
    {
        return questionsList.get(index).getQuestionText();
    }

    /**
     * Возвращает текст вопроса из xml-файла по индексу.
     * @param index - индекс вопроса.
     * @return текст вопроса из xml-файла по индексу.
     */
    @Override
    public String getQuestionTextFromXmlAt(int index)
    {
        return questionsListFromXml.get(index).getQuestionText();
    }

    /**
     * Возвращает количество вопросов в xml-файле.
     * @return
     */
    @Override
    public int getQuestionsXmlCount()
    {
       return questionsListFromXml.size();
    }

    /**
     * Возвращает количество вопросов в тесте.
     * @return количество вопросов в тесте.
     */
    @Override
    public int getQuestionsCount()
    {
        return questionsList.size();
    }

    /**
     * Добавляет список вопросов из xml-файла.
     * @param xmlFilePath
     * @throws Exception
     */
    public void addQuestionsListFromXml(String xmlFilePath) throws Exception
    {
        TestingXmlDataReader reader = new TestingXmlDataReader(xmlFilePath);
        questionsListFromXml = reader.getQuestionsList();
        questionsList.addAll(questionsListFromXml);
    }

    /**
     * Возвращает вопрос по индексу.
     * @param index - индекс вопроса.
     * @return вопрос.
     */
    private TestingQuestion getQuestionAt(int index)
    {
        return questionsList.get(index);
    }

    /**
     * Возвращает описание сложности вопроса.
     * @param index - индекс вопроса.
     * @return описание сложности вопроса.
     */
    @Override
    public String getComplexityAt(int index)
    {
        return getQuestionAt(index).getComplexity().getComplexityOfTheQuestion();
    }

    /**
     * Возврашает автора вопроса по индексу вопроса.
     * @param index - индекс вопроса.
     * @return автор.
     */
    @Override
    public String getAuthorAt(int index)
    {
        return getQuestionAt(index).getAuthor();
    }

    /**
     * Возвращает вид вопроса по индексу вопроса.
     * @param index - индекс вопроса.
     * @return вид вопроса.
     */
    @Override
    public String getTypeAt(int index)
    {
        return getQuestionAt(index).getType().getType();
    }

    /**
     * Возвращает информацию для пользователя о типе вопроса.
     * @param index - индекс вопроса.
     * @return информация для пользователя о типе вопроса.
     */
    @Override
    public String getTypeUserInfoAt(int index)
    {
        return getQuestionAt(index).getType().getUserInfo();
    }

    @Override
    public int getMaxRightAnswerOptionsCountAt(int index)
    {
        return getQuestionAt(index).getType().getMaxRightAnswerOptionsCount();
    }

    @Override
    public int getMinRightAnswerOptionsCountAt(int index)
    {
        return getQuestionAt(index).getType().getMinRightAnswerOptionsCount();
    }

    /**
     * Возвращает список вариантов ответа по индексу вопроса.
     * @param index - индекс вопроса.
     * @return список вариантов ответа.
     */
    @Override
    public ArrayList<String> getAnswerOptionsAt(int index)
    {
        return getQuestionAt(index).getAnswerOptionsList();
    }

    /**
     * Возвращает список правильных вариантов ответа по индексу вопроса.
     * @param index - индекс вопроса.
     * @return список правильных вариантов ответа.
     */
    @Override
    public ArrayList<String> getRightAnswerOptionsAt(int index)
    {
        return getQuestionAt(index).getRightAnswerOptionsList();
    }

    /**
     * Устанавливает текст вопрос
     * @param index
     * @param textQuestion
     */
    @Override
    public void renameQuestionTextAt(int index, String textQuestion)
    {
        getQuestionAt(index).setQuestionText(textQuestion);
    }

    @Override
    public int getScoreQuestionAt(int index)
    {
        return getQuestionAt(index).getComplexity().getScore();
    }
}
