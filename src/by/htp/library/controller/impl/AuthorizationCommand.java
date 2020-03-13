package by.htp.library.controller.impl;

import by.htp.library.bean.User;
import by.htp.library.controller.Command;
import by.htp.library.service.ServiceException;
import by.htp.library.service.ServiceProvider;
import by.htp.library.service.UserService;

public class AuthorizationCommand implements Command{

	@Override
	public String execute(String request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String execute(User request)
	{
		String response = "";

		UserService service = ServiceProvider.getInstance().getUserService();
		try {
			service.authorization(request);
			if (service.authorization(request) == true){
				response = "Залогинился";
			}else{
				response = "Неполучилось";
			}
		} catch (ServiceException e) {
			// log
			response = "error";
		}
		return response;
	}

}
