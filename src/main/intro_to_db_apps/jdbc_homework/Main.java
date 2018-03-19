package jdbc_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Connection connection = Connector.getDefaulthConnection();
        Problems p = new Problems(connection);

        testAgain:
        while (true) {
            System.out.print(TasksDefinition.welcome);
            String problemN = br.readLine();

            try {
                switch (problemN) {
                    case "p2":
                        p.p2GetVillainsNames();
                        continue testAgain;
                    case "p3":
                        p.p3GetMinionsNames();
                        continue testAgain;
                    case "p4":
                        p.p4AddMinion();
                        continue testAgain;
                    case "p5":
                        p.p5ChangeTownNameToUpperCase();
                        continue testAgain;
                    case "p6":
                        p.p6RemoveVillain();
                        continue testAgain;
                    case "p7":
                        p.p7PrintAllMinion();
                        continue testAgain;
                    case "p8":
                        p.p8IncreaseMinionAge();
                        continue testAgain;
                    case "p9":
                        p.p9CallStoredProcedure();
                        continue testAgain;
                    case "exit":
                        break testAgain;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Connector.close();

    }
}
