package p2_get_minion_names;


import jdbc_homework.Connector;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {
    private static String user = "";
    private static String password = "";
    private static String local_connection = "jdbc:mysql://localhost:3306/MinionsDB";


    public static void main(String[] args) throws SQLException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Connection connection = Connector.getDefaulthConnection();
        PreparedStatement prstFindVillain = connection.prepareStatement("SELECT v.name\n" +
                "FROM villains as v\n" +
                "WHERE v.id = ?");
        PreparedStatement prstFindMinions = connection.prepareStatement("SELECT m.name, m.age\n" +
                "FROM minions as m\n" +
                "JOIN villains_minions as vm ON m.id = vm.minion_id\n" +
                "WHERE vm.villain_id = ?");

        System.out.println("Enter villains id:");
        int villainID = Integer.parseInt(br.readLine());
        prstFindVillain.setInt(1, villainID);
        prstFindMinions.setInt(1, villainID);

        ResultSet rsVillain = prstFindVillain.executeQuery();
        ResultSet rsMinions = prstFindMinions.executeQuery();

        if (!rsVillain.isBeforeFirst()) {
            System.out.printf("No villain with ID %d exists in the database.", villainID);
        } else {
            while (rsVillain.next())
                System.out.printf("Villain: %s%n", rsVillain.getString(1));
        }

        if (rsMinions == null)
            System.out.print("<no minions>\n");
        else {
            rsMinions.beforeFirst();
            int count = 1;
            while (rsMinions.next())
                System.out.printf("%d. %s %d%n", count++, rsMinions.getString(1), rsMinions.getInt(2));
        }

    }
}
