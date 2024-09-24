package com.erp;

import java.util.Scanner;

public class LoginEN {
    Scanner scanner = new Scanner(System.in);
    public String admin = "admin";
    public String senha = "senha";

    public boolean login(String admin, String senha) {
        System.out.print("login: ");
        String usuario = scanner.nextLine();
        System.out.print("password: ");
        String password = scanner.nextLine();

        if (usuario.equals(admin) && password.equals(senha)) {
            System.out.println();
            System.out.println("Login successful!");
            return true;
        } else {
            return false;
        }

    }

}
