package by.htp.library.start;

import by.htp.library.bean.User;
import by.htp.library.controller.Controller;

public class Main
{


    public static void main(String[] args)
    {
        Controller controller = new Controller();
        User user = new User("exe@gmail.com", "Qwerty1", "Linux");
        String request;
        String response;

        request = "Registration";

        response = controller.action(user, request);

        System.out.println(response);

        user = null;

        request = "Authorization";

        user = new User("exe@gmail.com", "Qwerty1");
        response = controller.action(user, request);

        System.out.println(response);
    }

}
