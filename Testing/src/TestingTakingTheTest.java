/**
 * Класс прохождения теста.
 */
public class TestingTakingTheTest
{
    public TestingTakingTheTest()
    {
        TestingTheTest test = new TestingTheTest();

        for (int i = 0; i < test.getQuestionsList().size(); i ++)
        {
            System.out.println("\nВопрос № " + (i+1));
            System.out.println(test.getQuestionsList().get(i).getText());

            for (int j = 0; j < test.getQuestionsList().get(i).getAnswerOptionsList().size(); j ++)
            {
                System.out.println("\nВариант № " + (j+1));

                System.out.println(test.getQuestionsList().get(i).getAnswerOptionsList().get(j));
            }
            System.out.println("---------------------------------");
        }

    }
}
