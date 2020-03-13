package by.htp.library.dao.impl;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import by.htp.library.bean.User;
import by.htp.library.dao.DaoException;
import by.htp.library.dao.UserDao;

public class FileUserDao implements UserDao
{

    @Override
    public boolean authorization(String login, String password) throws DaoException
    {
        try (FileReader writer = new FileReader("C:\\Users\\khotyan.y\\Downloads\\anlys\\jd1-les19\\src\\resources\\authorization.txt"))
        {
            Scanner scan = new Scanner(writer);
            int i = 0;
            String[] passMass = new String[2];
            while (scan.hasNextLine())
            {
                String a = scan.nextLine();
                passMass[i] = a;
                i++;
            }
            if (passMass[0].equals(login)  && passMass[1].equals(password)){
                return true;
            }

            writer.close();
        }
        catch (IOException e)
        {
            throw new DaoException(e);
        }

        return false;
    }

    @Override
    public boolean registration(User newUser) throws DaoException
    {
        try (FileWriter writer = new FileWriter("C:\\Users\\khotyan.y\\Downloads\\anlys\\jd1-les19\\src\\resources\\registration.txt"))
        {
            writer.write(newUser.getName());
            writer.append('\n');
            writer.write(newUser.getLogin());
            writer.append('\n');
            writer.write(newUser.getPassword());
            writer.append('\n');
            writer.flush();
        }
        catch (IOException e)
        {
            throw new DaoException(e);
        }
        return false;
    }

    @Override
    public boolean changeUserStatus(int idUser, String newStatus)
    {
        // TODO Auto-generated method stub
        return false;
    }

}
