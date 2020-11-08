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
    private String textQuestion;

    /**
     * Список вариантов ответа.
     */
    ArrayList<String> answerOptionsList = new ArrayList<String>();
    /**
     * Список правильных вариантов ответа.
     */
    ArrayList<String> rightAnswerOptionsList = new ArrayList<String>();

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

    TestingQuestion(String textQuestion, TestingTypesOfQuestion type,
                    TestingComplexityOfTheQuestion complexity,
                    TestingUser author)
    {
        this.textQuestion = textQuestion;
        this.type = type;
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

        if (isRightAnswerOptionThis == true)
        {
            rightAnswerOptionsList.add(answerOption);

            idAnswerOptions ++;
        }

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
    public String getTextQuestion()
    {
        return textQuestion;
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
     * Возвращает тип вопроса.
     * @return тип вопроса.
     */
    public TestingTypesOfQuestion getType()
    {
        return type;
    }


}
