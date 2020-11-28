import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс прохождения теста.
 */
public class TestingTakingTheTest
{
    /**
     * Тест.
     */
    private TestingTestService tests = null;

    /**
     * Вопрос.
     */
    private TestingQuestion question = null;

    /**
     * Количество вариантов ответа.
     */
    private int answerOptionsCount = 0;

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
        Scanner in;
        String inputedValue = new String();
        boolean isValidInputedValue = false;

        while (isValidInputedValue == false)
        {
            System.out.println("Выберите источник загрузки теста:");
            System.out.println("1. Из XML - файла;");
            System.out.println("2. Из кода.");

            in = new Scanner(System.in);
            inputedValue = in.nextLine();

            if (inputedValue.length() != 1 ||
                    inputedValue.charAt(0) != TestingConst.ONE &&
                            inputedValue.charAt(0) != TestingConst.TWO)
            {
                System.err.println("Некорректный ввод");
            }
            else
            {
                isValidInputedValue = true;
            }
        }

        try
        {
            if (inputedValue.charAt(0) == TestingConst.ONE)
            {
                System.out.println("Укажите путь к xml - файлу.");
                in = new Scanner(System.in);

                String xmlFilePath = in.nextLine();

                try
                {
                    tests = new TestingTestService(xmlFilePath);
                } catch (FileNotFoundException exception)
                {
                    System.err.println(exception.getMessage());
                    outQuestionsList();
                }

            }
            else if (inputedValue.charAt(0) == TestingConst.TWO)
            {
                tests = new TestingTestService();
            }

            int userScores = 0;

            ArrayList testsList = tests.getTestsList();

            for (int t = 0; t < testsList.size(); t++)
            {
                TestingTheTest test = tests.getTestsListAt(t);

                System.out.println("Тест " + test.getTestName());
                for (int i = 0; i < test.getQuestionsList().size(); i++)
                {
                    question = test.getQuestionsList().get(i);

                    System.out.println("\nВопрос № " + (i + 1));
                    System.out.println(question.getQuestionText());

                    String userAnswerOption = new String();
                    boolean rightAnswerOption = false;

                    if (question.getType() != TestingTypesOfQuestion.OPENING_QUESTION)
                    {
                        answerOptionsCount = question.getAnswerOptionsList().size();
                        for (int j = 0; j < answerOptionsCount; j++)
                        {
                            System.out.println("\nВариант № " + (j + 1));

                            System.out.println("- " + question.getAnswerOption(j));
                        }

                        System.out.println(question.getType().getUserInfo());

                        in = new Scanner(System.in);
                        userAnswerOption = in.nextLine();

                        while (!isValidInputedValue(userAnswerOption))
                        {
                            System.err.println("Некорректный ввод");
                            System.out.println(question.getType().getUserInfo());

                            in = new Scanner(System.in);
                            userAnswerOption = in.nextLine();
                            isValidInputedValue(userAnswerOption);
                        }

                        for (int j = 0; j < question.getRightAnswerOptionsList().size(); j++)
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
                    }
                    else
                    {
                        System.out.println(question.getType().getUserInfo());
                        in = new Scanner(System.in);
                        userAnswerOption = in.nextLine();

                        if (question.getRightAnswerOptionsList().contains(userAnswerOption))
                        {
                            rightAnswerOption = true;
                        }
                    }
                    if (rightAnswerOption == true)
                    {
                        System.out.println("Правильный ответ");
                        userScores += question.getComplexity().getScore();
                    }
                    else
                    {
                        System.out.println("Ответ неверный");
                        System.out.println("Правильный ответ:");

                        for (int j = 0; j < question.getRightAnswerOptionsList().size(); j++)
                        {
                            System.out.println("\n- " + question.getRightAnswerOptionsList().get(j));
                        }
                    }
                    System.out.println("---------------------------------");
                }
                System.out.println("Тест завершен!");
                System.out.println("У Вас " + (100 * userScores / test.getAllScores()) + "% правильных ответов.");
            }
        } catch (Exception exception)
        {
            System.err.println(exception.getMessage());
            outQuestionsList();
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

        if (inputedValueCount > answerOptionsCount * 2 - 1 ||
                inputedValueCount > question.getType().getMaxRightAnswerOptionsCount() ||
                inputedValueCount < question.getType().getMinRightAnswerOptionsCount())
        {
            return false;
        }

        for (int j = 0; j < inputedValueCount; j++)
        {
            //Каждый второй введенный символ должен быть запятой (только если он не последний).
            if (j % 2 != 0)
            {
                if (inputedValue.charAt(j) != TestingConst.COMMA ||
                        inputedValue.charAt(inputedValueCount - 1) == TestingConst.COMMA)
                {
                    return false;
                }
            }
            else
            {
                int inputedValueElement = (int) inputedValue.charAt(j) - TestingConst.ZERO_NUMBER_IN_CHAR;

                if (inputedValueElement < 1 ||
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
