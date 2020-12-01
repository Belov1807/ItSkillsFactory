import java.util.ArrayList;

/**
 * Класс прохождения теста.
 */
public class TestingTakingTheTest
{
    /**
     * Состояние правильности пользовательского варианта ответа.
     */
    private boolean rightAnswerOption = false;

    /**
     * Количество баллов набранных пользователем при прохождении теста.
     */
    int userScores = 0;

    /**
     * Список пользовательских вариантов ответа.
     */
    ArrayList<String> userAnswers = new ArrayList<>();

    /**
     * Сервис по работе с вопросами.
     */
    TestingQuestionServiceInterface question;

    /**
     * Конструктор.
     */
    public TestingTakingTheTest()
    {
        System.out.println("public TestingTakingTheTest()");
    }

    /**
     * Добавляет пользовательскийвариант ответа в список.
     *
     * @param answer - вариант ответ.
     */
    public void addUserAnswers(String answer)
    {
        userAnswers.add(answer);
    }

    /**
     * Проверяет правильность ответов пользователя.
     *
     * @param indexQuestion - индекс вопроса.
     */
    public void checkRightAnswer(int indexQuestion)
    {
        rightAnswerOption = false;

        System.out.println("checkRightAnswer(int indexQuestion)");
        ArrayList<String> rightAnswers = question.getRightAnswerOptionsAt(indexQuestion);
        for (int i = 0; i < rightAnswers.size(); i++)
        {
            System.out.println("userAnswers = " + userAnswers.get(i));
            System.out.println("rightAnswers = " + rightAnswers.get(i));
            if (userAnswers.equals(rightAnswers.get(i)))
            {
                rightAnswerOption = true;
            } else
            {
                rightAnswerOption = false;
                break;
            }
        }

        if (rightAnswerOption = true)
        {
            userScores += question.getScoreQuestionAt(indexQuestion);
        }
    }

    /**
     * возвращает количество баллов набранных пользователем при прохождении теста.
     *
     * @return количество баллов набранных пользователем.
     */
    public int getUserScores()
    {
        return userScores;
    }

    /**
     * Возвращает состояние правильности ответа пользователя.
     *
     * @return true - пользователь ответил верно.
     */
    public boolean isRightAnswerOption()
    {
        return rightAnswerOption;
    }

    /**
     * Устанавливает сервис по работе с вопросами.
     *
     * @param question - сервис по работе с вопросами.
     */
    public void setQuestion(TestingQuestionServiceInterface question)
    {
        this.question = question;
    }
}
