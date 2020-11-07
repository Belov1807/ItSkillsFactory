import java.util.Scanner;

/**
 * Класс прохождения теста.
 */
public class TestingTakingTheTest
{
    /**
     * Конструктор.
     */
    public TestingTakingTheTest()
    {
        outQuestionsList();
    }

    /**
     * Выводит список вопросов.
     */
    private void outQuestionsList()
    {
        TestingTheTest test = new TestingTheTest();

        for (int i = 0; i < test.getQuestionsList().size(); i ++)
        {
            TestingQuestion question = test.getQuestionsList().get(i);

            System.out.println("\nВопрос № " + (i + 1));
            System.out.println(question.getTextQuestion());

            for (int j = 0; j < question.getAnswerOptionsList().size(); j ++)
            {
                System.out.println("\nВариант № " + (j + 1));

                System.out.println(question.getAnswerOption(j));
            }

            System.out.println("Введите правильный вариант ответа.");
            Scanner in = new Scanner(System.in);
            int userAnswerOption = in.nextInt();


            for (int j = 0; j < question.getRightAnswerOptionsList().size(); j ++)
            {
                if (question.getRightAnswerOptionsList().contains(question.getAnswerOption(userAnswerOption - 1)))
                {
                    System.out.println("Ответ верный");
                }
                else
                {
                    System.out.println("Ответ неверный");
                }
            }
            System.out.println("---------------------------------");
        }
    }
}
