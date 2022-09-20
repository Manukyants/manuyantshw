import exception.WrongLoginException;
import exception.WrongPasswordException;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String login = "iuyt123";
        String password ="vfr_123";
        String confirmPassword =  "vfr_123";
        accept(login, password,confirmPassword);
    }

    public static boolean accept(String login, String password, String confirmPassword){
        boolean checkLogin;
        boolean checkPassword;
        boolean checkLength;
        boolean checkLoginLength;
        boolean checkPassMatch;
        try {
            checkLogin = checkValidate(login);
            checkPassword = checkValidate(password);
            checkLength = checkLoginLength(login);
            checkLoginLength = checkLoginLength(password);
            checkPassMatch = checkPassMatch(password, confirmPassword);
        }catch (WrongLoginException | WrongPasswordException e){
            System.out.println(e.getMessage());
            return false;
        }

        return checkLogin && checkPassword && checkLength && checkLoginLength && checkPassMatch;

    }
    public static boolean checkValidate(String checkWord){
        if(checkWord == null){
            throw new  NullPointerException("Введите текст");
        }
        if(checkWord.matches("\\w+")){
            return true;
        }
        System.out.printf("Недопустимые символы - %s\n", checkWord );
        return false;
    }
    public static boolean checkLoginLength(String login) throws WrongLoginException {
        if (login.length()>20){
            throw new WrongLoginException("Слишком длиный логин");
        }
        return true;
    }
    public static boolean checkLoginPassword(String pass){
        if (pass.length()>19){
            System.out.println("Длина не соответствует");
            return false;
        }
        return true;
    }
    public static boolean checkPassMatch(String password, String confirmPassword){
        if (password.equals(confirmPassword)) return true;
        throw new WrongPasswordException("Пароль не верный");
        }
    }