import java.util.ArrayList;
import java.util.Collections;

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
    //private ArrayList<TestingQuestion> questionsList = new ArrayList<TestingQuestion>();
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
        chechQuestionsRightAnswer();

        setAllScores();

        //Collections.shuffle(questionsList);
    }

    /**
     * Возвращает список вопросов.
     * @return список вопросов.
     */
    //public ArrayList<TestingQuestion> getQuestionsList()
    //{
        //return questionsList;
    //}


    /**
     * Задает общее количество баллов за все вопросы.
     */
    private void setAllScores()
    {
//        for (int i = 0; i < questionsList.size(); i ++)
//        {
//            allScores += questionsList.get(i).getComplexity().getScore();
//        }
    }

    /**
     * Возвращает общее количество баллов за все вопросы.
     * @return общее количество баллов за все вопросы.
     */
    public int getAllScores()
    {
        return allScores;
    }

    /**
     * Добавляет вопрос в список.
     * @param question - вопрос.
     */
    public void addQuestion(TestingQuestion question)
    {
        //questionsList.add(question);
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
     * Проверяет нет ли в списке вопросов, вопроса без правильного варианта ответа.
     */
    private void chechQuestionsRightAnswer() throws Exception {
//        for (int i = 0; i < questionsList.size(); i ++)
//        {
//            if (questionsList.get(i).isEmptyRightAnswerOptionsList())
//            {
//                throw new Exception("Ошибка построения списка вопросов! В вопросе \"" + questionsList.get(i).getQuestionText()  +
//                    "\" не задан правильный ответ.");
//            }
//        }
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
