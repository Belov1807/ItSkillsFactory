/*Version 0.11.0*/

/**
 * Главный класс приложения по тестированию.
 */
public class TestingMain
{
    /**
     * Конструктор.
     */
    public TestingMain() throws Exception
    {
        System.out.println("Здравствуйте! Добро пожаловать в приложение по тестированию!");

        TestingUserService userService = new TestingUserService();
        userService.selectActionInSystem();
    }
    public  static  void  main (String [] args) throws Exception
    {
        new TestingMain();
    }
}
