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
    private int idAnswerOptions = 1;
    /**
     * Текст вопроса.
     */
    private String text;
    /**
     * Список вариантов ответа.
     */
    ArrayList<String> answerOptionsList = new ArrayList<String>();
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

    TestingQuestion(String text, TestingTypesOfQuestion type,
                   TestingComplexityOfTheQuestion complexity,
                                          TestingUser author)
    {
        this.text = text;
        this.type = type;
        this.complexity = complexity;
        this.author = author;

        idQuestion ++;
    }

    /**
     * Добавляет вариант ответа.
     * @param answerOption - вариант ответа.
     */
    public void addAnswerOption(String answerOption)
    {
        answerOptionsList.add(answerOption);
        idAnswerOptions ++;

                Collections.shuffle(answerOptionsList);

    }

    public int getIdAnswerOptions()
    {
        return idAnswerOptions;
    }

    public static int getIdQuestion()
    {
        return idQuestion;
    }

    public String getText()
    {
        return text;
    }

    public ArrayList<String> getAnswerOptionsList()
    {
        return answerOptionsList;
    }
}
