import java.util.ArrayList;
import java.util.Collections;

/**
 * Класс вопроса.
 */
public class TestingQuestion
{
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
    private TestingTypesOfQuestion type = null;
    /**
     * Сложность вопроса.
     */
    private TestingComplexityOfTheQuestion complexity = null;
    /**
     * Автор вопроса.
     */
    private String author = new String();

    /**
     * Конструктор.
     * @param questionText - текст вопроса.
     * @param complexity - сложность вопроса.
     * @param author - автор вопроса.
     */
    TestingQuestion(String questionText,
                    TestingComplexityOfTheQuestion complexity,
                    String author)
    {
        this.questionText = questionText;
        this.complexity = complexity;
        this.author = author;
    }

    /**
     * Добавляет вариант ответа.
     * @param answerOption - вариант ответа.
     */
    public void addAnswerOption(boolean isRightAnswerOptionThis, String answerOption)
    {
        answerOptionsList.add(answerOption);

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

    /**
     * Возвращает автора вопроса.
     * @return автор вопроса.
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * Устанавливает текст вопроса.
     * @param questionText - текст вопроса.
     */
    public void setQuestionText(String questionText)
    {
        this.questionText = questionText;
    }
}
