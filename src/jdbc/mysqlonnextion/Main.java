package jdbc.mysqlonnextion;

import java.io.FileReader;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SignIn si = new SignIn();
        System.out.println(si.judgeSignIn());
    }
}

