package ru.skypro;

public class Main {

    public static void main(String[] args) {
	boolean result = Test.check("checker", "JGDH_2215_jfh", "JGDH_2215_jfh");
        if (result) {
            System.out.println("Логин и пароль введены корректно");
        } else {
            System.out.println("Логин и/или пароль введены некорректно");
        }
    }
}
