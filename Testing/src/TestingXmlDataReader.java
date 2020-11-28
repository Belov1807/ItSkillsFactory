import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Класс считывания данных из файла формата XML.
 */
public class TestingXmlDataReader
{
    /**
     * Путь к файлу.
     */
    private String xmlFilePath = new String();

    /**
     * Элемент xml.
     */
    private Element element = null;

    /**
     * Название теста.
     */
    private String testName = new String();

    /**
     * Список вопросов.
     */
    private ArrayList<TestingQuestion> questionsList = new ArrayList<TestingQuestion>();

    /**
     * Конструктор.
     * @param xmlFilePath - путь к файлу.
     * @throws Exception - выбрасываемое исключение.
     */
    public TestingXmlDataReader(String xmlFilePath) throws Exception
    {
        this.xmlFilePath = xmlFilePath;

        setQuestionsListFromXml();
    }

    /**
     * Задает список вопросов из файла.
     * @throws Exception - выбрасываемое исключение.
     */
    private void setQuestionsListFromXml() throws Exception
    {
        if (xmlFilePath.endsWith(".xml") == false)
        {
            throw new Exception("Указан файл неверного формата.\n");
        }

        File xmlFile = new File(xmlFilePath);

        if (xmlFile.isFile() == false)
        {
            throw new Exception("Файл не найден.\n");
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;

        builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();

        element = document.getDocumentElement();

        if (element.getTagName() != TestingConst.TEST)
        {
            throw new Exception("Ошибка чтения из файла. Отсутствует обязательный тэг: \"" + TestingConst.TEST + "\"");
        }

        checkAttribute(TestingConst.TEST_NAME);

        testName = element.getAttribute(TestingConst.TEST_NAME);

        NodeList questionsNodeList = element.getElementsByTagName(TestingConst.QUESTION);

        for (int i = 0; i < questionsNodeList.getLength(); i++)
        {
            element = (Element) questionsNodeList.item(i);

            NodeList answerOptionsNodeList = element.getElementsByTagName(TestingConst.ANSWER_OPTION);

            checkAttribute(TestingConst.QUESTION_TEXT);
            checkAttribute(TestingConst.COMPLEXITY);
            checkAttribute(TestingConst.AUTHOR);

            //Создает список перечеслений TestingComplexityOfTheQuestion, и конвертирует в список строк.
            List<TestingComplexityOfTheQuestion> complexityList = Arrays.asList(TestingComplexityOfTheQuestion.values());
            List<String> complexityToStringList = complexityList.stream().map(Object::toString).collect(Collectors.toList());

            if (complexityToStringList.contains(element.getAttribute(TestingConst.COMPLEXITY)) == false)
            {
                throw new Exception("Ошибка чтения из файла. Некорректная сложность вопроса.");
            }

            TestingUser author = new TestingUser(element.getAttribute(TestingConst.AUTHOR));

            TestingQuestion question = new TestingQuestion(element.getAttribute(TestingConst.QUESTION_TEXT),
                    TestingComplexityOfTheQuestion.valueOf(element.getAttribute(TestingConst.COMPLEXITY)), author);

            for (int j = 0; j < answerOptionsNodeList.getLength(); j++)
            {

                element = (Element) answerOptionsNodeList.item(j);

                checkAttribute(TestingConst.IS_RIGHT_ANSWER_OPTION_THIS);
                checkAttribute(TestingConst.ANSWER_OPTION_TEXT);

                question.addAnswerOption(Boolean.valueOf(element.getAttribute(TestingConst.IS_RIGHT_ANSWER_OPTION_THIS)),
                        element.getAttribute(TestingConst.ANSWER_OPTION_TEXT));
            }
            questionsList.add(question);
        }
    }

    /**
     * Проверяет наличие аттрибута в файле.
     *
     * @param attribute - аттрибут.
     * @throws Exception - выбрасываемое исключение.
     */
    private void checkAttribute(String attribute) throws Exception
    {
        if (element.hasAttribute(attribute) == false)
        {
            throw new Exception("Ошибка чтения из файла. Отсутствует обязательный аттрибут: \"" + attribute + "\"");
        }
    }

    /**
     * Возвращает список вопросов.
     *
     * @return список вопросов.
     */
    public ArrayList<TestingQuestion> getQuestionsList()
    {
        return questionsList;
    }

    /**
     * Возвращает имя теста.
     *
     * @return имя теста.
     */
    public String getTestName()
    {
        return testName;
    }
}
