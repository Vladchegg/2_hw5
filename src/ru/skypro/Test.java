package ru.skypro;

import java.util.Objects;

public class Test {

    private static final String SYMBOLS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789";

    private Test() {

    }

    static boolean check(String login, String password, String confirmPassword) {
        try {
            test(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void test (String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() > 20) {
            throw new WrongLoginException("Длина логина должна быть <= 20");
        }
        if (!containsSymbols(login)) {
            throw new WrongLoginException("Логин состоит из запрещенных символов");
        }
        if (Objects.isNull(password) || password.length() >= 20)  {
            throw new WrongPasswordException("Длина пароля должна быть < 20");
        }
        if (Objects.isNull(confirmPassword) || confirmPassword.length() >= 20) {
            throw new WrongPasswordException("Длина пароля должна быть < 20");
        }
        if (!containsSymbols(password) || !containsSymbols(confirmPassword)) {
            throw new WrongPasswordException("Пароль состоит из запрещенных символов");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать!");
        }
    }

    private static boolean containsSymbols(String b) {
        char[] symbols = b.toCharArray();
        for (char symbol : symbols) {
            if (!SYMBOLS.contains(String.valueOf(symbol))) {
                    return false;
                }
            }
        return true;
    }
}
