import java.util.ArrayList;
import java.util.Collections;

/**
 * Класс вопроса.
 */
public class TestingQuestion
{
    /**
     * Идентификатор вопроса.
     */
    private static int idQuestion = 0;
    /**
     * Идентификатор варианта ответа.
     */
    private int idAnswerOptions = 0;

    /**
     * Текст вопроса.
     */
    private String questionText = new String();

    /**
     * Список вариантов ответа.
     */
    private ArrayList<String> answerOptionsList = new ArrayList<String>();
    /**
     * Список правильных вариантов ответа.
     */
    private ArrayList<String> rightAnswerOptionsList = new ArrayList<String>();

    /**
     * Тип вопроса.                                                                                                                                                                                                                                             
     */
    private TestingTypesOfQuestion type;
    /**
     * Сложность вопроса.
     */
    private TestingComplexityOfTheQuestion complexity;
    /**
     * Автор вопроса.
     */
    private TestingUser author;

    TestingQuestion(String questionText,
                    TestingComplexityOfTheQuestion complexity,
                    TestingUser author)
    {
        this.questionText = questionText;
        this.complexity = complexity;
        this.author = author;

        idQuestion ++;
    }

    /**
     * Добавляет вариант ответа.
     * @param answerOption - вариант ответа.
     */
    public void addAnswerOption(boolean isRightAnswerOptionThis, String answerOption)
    {
        answerOptionsList.add(answerOption);
        idAnswerOptions ++;

        if (isRightAnswerOptionThis == true)
        {
            rightAnswerOptionsList.add(answerOption);
        }

        setTypeOfQuestion();

        // Перемешивает список вариантов ответа.
        Collections.shuffle(answerOptionsList);
    }

    /**
     * Добавляет вариант ответа.
     * @param answerOption - вариант ответа.
     */
    public void addAnswerOption(String answerOption)
    {
        addAnswerOption(false, answerOption);
    }

    /**
     * Устанавливает тип вопроса.
     */
    private void setTypeOfQuestion()
    {
        if (rightAnswerOptionsList.size() > 1)
        {
            type = TestingTypesOfQuestion.MULTIPLE_RIGHT_OPTIONS;
        }
        else if (rightAnswerOptionsList.size() == 1 && answerOptionsList.size() != 1)
        {
            type = TestingTypesOfQuestion.SINGLE_RIGHT_OPTION;
        }
        else if (rightAnswerOptionsList.size() == 1 && answerOptionsList.size() == 1)
        {
            type = TestingTypesOfQuestion.OPENING_QUESTION;
        }
    }

    /**
     * Возвращает идентификатор вопроса.
     * @return идентификатор вопроса.
     */
    public static int getIdQuestion()
    {
        return idQuestion;
    }

    /**
     * Возвращает текст вопроса.
     * @return текст вопроса.
     */
    public String getQuestionText()
    {
        return questionText;
    }

    /**
     * Возвращает список вариантов ответа.
     * @return список вариантов ответа.
     */
    public ArrayList<String> getAnswerOptionsList()
    {
        return answerOptionsList;
    }

    /**
     * Возвращает вариант ответа по индексу.
     * @param index - индекс.
     * @return вариант ответа.
     */
    public String getAnswerOption(int index)
    {
        return answerOptionsList.get(index);
    }

    /**
     * Возвращает список правильных вариантов ответа.
     * @return список правильных вариантов ответа.
     */
    public ArrayList<String> getRightAnswerOptionsList()
    {
        return rightAnswerOptionsList;
    }

    /**
     * Возвращает состояние отсутствия правильного варианта ответа в вопросе.
     * @return true - в вопросе отсутствует правильный вариант ответа.
     */
    public boolean isEmptyRightAnswerOptionsList()
    {
        if (rightAnswerOptionsList.isEmpty())
        {
            return true;
        }
        return false;
    }

    /**
     * Возвращает тип вопроса.
     * @return тип вопроса.
     */
    public TestingTypesOfQuestion getType()
    {
        return type;
    }

    /**
     * Возвращает сложность вопроса.
     * @return сложность вопроса.
     */
    public TestingComplexityOfTheQuestion getComplexity()
    {
        return complexity;
    }
}
