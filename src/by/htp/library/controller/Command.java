package by.htp.library.controller;

import by.htp.library.bean.User;

public interface Command {
	
	String execute(String request);
	String execute(User request);


}
