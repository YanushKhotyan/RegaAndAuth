package by.htp.library.service.impl;

import by.htp.library.bean.User;
import by.htp.library.dao.DaoException;
import by.htp.library.dao.DaoProvider;
import by.htp.library.dao.UserDao;
import by.htp.library.service.ServiceException;
import by.htp.library.service.UserService;

public class UserServiceImpl implements UserService
{

    @Override
    public boolean authorization(User user) throws ServiceException
    {
        if (user == null)
        {
            throw new RuntimeException("Вы не ввели данные");// stub
        }

        boolean result;

        DaoProvider provider = DaoProvider.getInstance();
        UserDao userDao = provider.getUserDao();
        try
        {
            result = userDao.authorization(user.getLogin(), user.getPassword());
        }
        catch (DaoException e)
        {
            throw new ServiceException(e);
        }
        return result;
    }

    @Override
    public boolean registration(User user) throws ServiceException
    {
        String password = user.getPassword();
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
//        boolean noSpecialChar = password.matches("[a-zA-Z0-9 ]*");
        if (user == null)
        {
            throw new RuntimeException("Вы не ввели данные");// stub
        }
        else if (password.length() < 6)
        {
            throw new RuntimeException("Пароль меньше 6-ти символов");
        }
        else if (!hasUppercase)
        {
            throw new RuntimeException("Хотябы один из симвалов должен быть в аперкейсе");
        }
        else if (!hasLowercase)
        {
            throw new RuntimeException("Хотябы один из симвалов должен быть в лоукейсе");
        }

        boolean result;

        DaoProvider provider = DaoProvider.getInstance();
        UserDao userDao = provider.getUserDao();
        try
        {
            result = userDao.registration(user);
        }
        catch (DaoException e)
        {
            throw new ServiceException(e);
        }
        return result;
    }

}
