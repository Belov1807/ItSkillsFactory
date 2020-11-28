import java.util.ArrayList;
import java.util.Scanner;

/**
 * Сервис по работе с тестами.
 */
public class TestingTestService
{
    /**
     * Сервис по работе с вопросами.
     */
    private TestingQuestionService questionService = null;

    /**
     * Тест.
     */
    private TestingTheTest test = null;
    /**
     * Список тестов.
     */
    private ArrayList<TestingTheTest> testsList = new ArrayList<TestingTheTest>();

    /**
     * Конструктор.
     * @param xmlFilePath - путь к файлу.
     * @throws Exception - выбрасываемое исключение.
     */
    public TestingTestService(String xmlFilePath) throws Exception
    {
        TestingTheTest test = new TestingTheTest(xmlFilePath);

        testsList.add(test);
    }

    /**
     * Конструктор.
     */
    public TestingTestService()
    {
        questionService = new TestingQuestionService();
    }

    /**
     * Возвращает список тестов.
     * @return список тестов.
     */
    public ArrayList<TestingTheTest> getTestsList()
    {
        return testsList;
    }

    /**
     * Возвращает тест из листа по индексу.
     * @param index - индекс.
     * @return тест.
     */
    public TestingTheTest getTestsListAt(int index)
    {
        return testsList.get(index);
    }

    /**
     * Добавляет тест в список.
     * @param testName - имя теста.
     * @throws Exception - выбрасываемое исключение.
     */
    public void addTest(String testName) throws Exception
    {
        TestingTheTest test = new TestingTheTest();
        test.setTestName(testName);
        testsList.add(test);
    }

    /**
     * Возвращает количество тестов.
     * @return количество тестов.
     */
    public int getTestsCount()
    {
        return testsList.size();
    }

    /**
     * Действия над списком тестов.
     * @throws Exception - выбрасываемое исключение.
     */
    public void actionsWithTest() throws Exception
    {
        Scanner in;
        String inputedSelectAction = new String();
        boolean isValidInputedValue = false;


        while (isValidInputedValue == false)
        {
            System.out.println("1 Добавить тест");
            System.out.println("2 Выбрать тест из списка");
            System.out.println("\n0 Выйти из системы");

            in = new Scanner(System.in);
            inputedSelectAction = in.nextLine();

            if (inputedSelectAction.length() != 1 ||
                    inputedSelectAction.charAt(0) != TestingConst.ONE &&
                            inputedSelectAction.charAt(0) != TestingConst.TWO &&
            inputedSelectAction.charAt(0) != '0')
            {
                System.err.println("Некорректный ввод");
            }
            else
            {
                isValidInputedValue = true;
            }
        }

        if (inputedSelectAction.charAt(0) == TestingConst.ONE)
        {
          addTest();
        }
        if (inputedSelectAction.charAt(0) == TestingConst.TWO)
        {
            selectTest();
        }

        if (inputedSelectAction.charAt(0) == '0')
        {
            return;
        }
    }

    /**
     * Добавляет тест.
     * @throws Exception - выбрасываемое исключение.
     */
    public void addTest() throws Exception
    {
        System.out.println("Введите название теста");



        Scanner in = new Scanner(System.in);
        String testName = in.nextLine();
        addTest(testName);

        System.out.println("Тест под названием \"" + testName + "\" успешно добавлен");


        actionsWithTest();
    }

    /**
     * Удаляет тест.
     */
    public void removeTest()
    {
        System.out.println("Вы действительно хотите удалить тест");
    }

    /**
     * Выводит список тестов и дает возможность выбора теста из этого списка.
     * @throws Exception - выбрасываемое исключение.
     */
    public void selectTest() throws Exception
    {
        if (getTestsCount() != 0)
        {
            System.out.println("Список тестов:");
            for (int i = 0; i < getTestsCount(); i++)
            {
                System.out.println((i + 1) + " " + getTestsListAt(i).getTestName());
            }

            System.out.println("Введите номер теста");
            System.out.println("Чтобы закрыть список тестов ведите '0'");

            Scanner in = new Scanner(System.in);

            test = getTestsListAt(in.nextInt() - 1);
            System.out.println(test.getTestName());

            actionsWithSelectedTest();
        }
        else
        {
            System.out.println("Тестов не обнаружено\n");
            actionsWithTest();
        }
    }

    /**
     * Действия над выбранным тестом.
     * @throws Exception - выбрасываемое исключение.
     */
    public void actionsWithSelectedTest() throws Exception
    {
        String inputedSelectAction = new String();
        Boolean isValidInputedValue = false;


        while (isValidInputedValue == false)
        {
            System.out.println("1 Просмотреть список вопросов в тесте ");
            System.out.println("2 Добавить в тест список вопросов из xml-файла");
            System.out.println("3 Переименовать тест");
            System.out.println("4 Удалить тест");
            System.out.println("\n0 Назад к выбору теста");

            System.out.println("Выберите действие");

            Scanner in = new Scanner(System.in);
            inputedSelectAction = in.nextLine();

            if (inputedSelectAction.length() != 1 ||
                    inputedSelectAction.charAt(0) != TestingConst.ONE &&
                            inputedSelectAction.charAt(0) != TestingConst.TWO &&
                            inputedSelectAction.charAt(0) != '3' &&
                            inputedSelectAction.charAt(0) != '4' &&
                            inputedSelectAction.charAt(0) != '5')
            {
                System.err.println("Некорректный ввод");
            }
            else
            {
                isValidInputedValue = true;
            }
        }

        if (inputedSelectAction.charAt(0) == TestingConst.ONE)
        {
            questionService.showQuestionsListAndSelect();
        }
        if (inputedSelectAction.charAt(0) == TestingConst.TWO)
        {
            questionService.addQuestionsListFromXml("files/questions_list.xml");

            System.out.println("Список вопросов:");

            questionService.showQuestionsList();

            System.out.println("\nСписок вопросов успешно добавлен в тест\n");

            actionsWithSelectedTest();
        }
        if (inputedSelectAction.charAt(0) == '3')
        {
            System.out.println("Введите новое имя теста");
            Scanner in = new Scanner(System.in);

            test.setTestName(in.nextLine());
            System.out.println("Тест переименован.");
        }
        if (inputedSelectAction.charAt(0) == '4')
        {
            removeTest();
        }

    }
}
