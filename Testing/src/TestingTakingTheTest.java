import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс прохождения теста.
 */
public class TestingTakingTheTest
{
    private boolean rightAnswerOption = false;

    int userScores = 0;

    ArrayList<String> userAnswers = new ArrayList<>();

    TestingQuestionServiceInterface question = new TestingQuestionService();

    /**
     * Конструктор.
     */
    public TestingTakingTheTest()
    {
    }


    public void addUserAnswers(String answer)
    {
        userAnswers.add(answer);
    }


    public void checkRightAnswer(int indexQuestion)
    {
        ArrayList<String> rightAnswers = question.getRightAnswerOptionsAt(indexQuestion);
        for (int i = 0; i < rightAnswers.size(); i++)
        {
            if (userAnswers.contains(rightAnswers.get(i)))
            {
                rightAnswerOption = true;
            }
            else
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

    public int getUserScores()
    {
        return userScores;
    }

    public boolean isRightAnswerOption()
    {
        return rightAnswerOption;
    }

    public void setQuestion(TestingQuestionServiceInterface question)
    {
        this.question = question;
    }
}
