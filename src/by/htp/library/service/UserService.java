package by.htp.library.service;

import by.htp.library.bean.User;

public interface UserService {
	
	boolean authorization(User user)  throws ServiceException;
	boolean registration(User user)  throws ServiceException;

}
