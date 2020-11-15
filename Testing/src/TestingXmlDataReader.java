import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * Класс считывания данных из файла формата XML.
 */
public class TestingXmlDataReader
{
    /**
     * Конструктор.
     */
    public TestingXmlDataReader()
    {

    }

    /**
     * Возвращает список вопросов из файла формата XML.
     * @param xmlFilePath - путь к xml - файлу.
     * @return список вопросов.
     */
    public ArrayList<TestingQuestion> getQuestionsListFromXml(String xmlFilePath)
    {
        ArrayList<TestingQuestion> questionsList = new ArrayList<TestingQuestion>();

        String filepath = xmlFilePath;

        try
        {
            File xmlFile = new File(filepath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;


            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            Element docElement = document.getDocumentElement();
            NodeList questionsNodeList = docElement.getElementsByTagName(TestingConst.QUESTION);

            for (int i = 0; i < questionsNodeList.getLength(); i++)
            {
                TestingUser user = new TestingUser();

                Element questionElement = (Element) questionsNodeList.item(i);

                NodeList answerOptionsNodeList = questionElement.getElementsByTagName(TestingConst.ANSWER_OPTION);

                TestingQuestion question = new TestingQuestion(questionElement.getAttribute(TestingConst.QUESTION_TEXT),
                        TestingComplexityOfTheQuestion.valueOf(questionElement.getAttribute(TestingConst.COMPLEXITY)), user);

                for (int j = 0; j < answerOptionsNodeList.getLength(); j++)
                {

                    questionElement = (Element) answerOptionsNodeList.item(j);

                    question.addAnswerOption(Boolean.valueOf(questionElement.getAttribute(TestingConst.IS_RIGHT_ANSWER_OPTION_THIS)),
                            questionElement.getAttribute(TestingConst.ANSWER_OPTION_TEXT));
                }
                questionsList.add(question);
            }
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }

        return questionsList;
    }
}
