import java.util.ArrayList;
import java.util.Scanner;

/*
 * Класс прохождения теста.
 */
public class TestingTakingTheTest
{
    /**
     * Количество вариантов ответа.
     */
    private int answerOptionsCount;

    /**
     * Список введенных пользователем вариантов ответа.
     */
    private ArrayList<Integer> inputedValueElementList = new ArrayList<Integer>();

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

            answerOptionsCount = question.getAnswerOptionsList().size();
            for (int j = 0; j < answerOptionsCount; j ++)
            {
                System.out.println("\nВариант № " + (j + 1));

                System.out.println("- " + question.getAnswerOption(j));
            }

            System.out.println("Введите правильный вариант ответа.");
            Scanner in = new Scanner(System.in);
            String userAnswerOption = in.nextLine();

            while(!isValidInputedValue(userAnswerOption))
            {
                System.out.println("Некорректный ввод");
                System.out.println(question.getType().getDescription());

                in = new Scanner(System.in);
                userAnswerOption = in.nextLine();
                isValidInputedValue(userAnswerOption);
            }

            boolean rightAnswerOption = false;

            for (int j = 0; j < question.getRightAnswerOptionsList().size(); j ++)
            {
                if (inputedValueElementList.contains(question.getAnswerOptionsList().indexOf(
                        question.getRightAnswerOptionsList().get(j)) + 1))
                {
                    rightAnswerOption = true;
                }
                else
                {
                    rightAnswerOption = false;
                    break;
                }
            }

            if (rightAnswerOption == true)
            {
                System.out.println("Правильный ответ");
            }
            else
            {
                System.out.println("Ответ неверный");
                System.out.println("Правильный ответ:");

                for (int j = 0; j < question.getRightAnswerOptionsList().size(); j ++)
                {
                    System.out.println("\n- " + question.getRightAnswerOptionsList().get(j));
                }
            }
            System.out.println("---------------------------------");
        }
    }

    /**
     * Возвращает валидность введенных пользователем вариантов ответа.
     * @param inputedValue - введенное значение.
     * @return true - валидное значение.
     */
    private boolean isValidInputedValue(String inputedValue)
    {
        int inputedValueCount = inputedValue.length();

        inputedValueElementList.clear();

        if(inputedValueCount > answerOptionsCount*2 -1)
        {
            return false;
        }

        for (int j = 0; j < inputedValueCount; j ++)
        {
            //Каждый второй введенный символ
            if (j % 2 != 0)
            {
                if (inputedValue.charAt(j) != ',' ||
                    inputedValue.charAt(inputedValueCount - 1) == ',')
                {
                    return false;
                }
            }
            else
            {
                int inputedValueElement = (int)inputedValue.charAt(j) - 48;

                if (inputedValueElement <1 ||
                    inputedValueElement > answerOptionsCount  ||
                    inputedValueElementList.contains(inputedValueElement))
                {
                    return false;
                }
                else
                {
                    inputedValueElementList.add(inputedValueElement);
                }
            }
        }
        return true;
    }
}