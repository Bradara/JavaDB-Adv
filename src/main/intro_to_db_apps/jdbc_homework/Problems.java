package jdbc_homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problems {

    private String findVillainQuery = "SELECT v.name FROM villains as v WHERE v.id = ?";
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private Connection connection;

    public Problems(Connection connection) {
        this.connection = connection;
    }

    public void p2GetVillainsNames() throws SQLException {
        System.out.print(TasksDefinition.p2);

        String query = "SELECT v.name, count(*) as `count`\n" +
                "FROM villains as v\n" +
                "JOIN villains_minions vm ON v.id = vm.villain_id\n" +
                "GROUP BY v.name\n" +
                "HAVING `count` > 3\n" +
                "ORDER BY `count` DESC";
        Statement st = connection.createStatement();

        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            System.out.printf("%s %s%n", rs.getString(1), rs.getString(2));
        }
    }

    public void p3GetMinionsNames() throws SQLException, IOException {
        System.out.print(TasksDefinition.p3);
        PreparedStatement prstFindVillain = connection.prepareStatement(findVillainQuery);
        PreparedStatement prstFindMinions = connection.prepareStatement("SELECT m.name, m.age\n" +
                "FROM minions as m\n" +
                "JOIN villains_minions as vm ON m.id = vm.minion_id\n" +
                "WHERE vm.villain_id = ?");

        int villainID = Integer.parseInt(br.readLine());

        prstFindVillain.setInt(1, villainID);
        prstFindMinions.setInt(1, villainID);

        ResultSet rsVillain = prstFindVillain.executeQuery();
        ResultSet rsMinions = prstFindMinions.executeQuery();
        boolean isVillainExists = true;

        if (!rsVillain.isBeforeFirst()) {
            isVillainExists = false;
            System.out.printf("No villain with ID %d exists in the database.%n", villainID);
        } else {
            while (rsVillain.next())
                System.out.printf("Villain: %s%n", rsVillain.getString(1));
        }

        if (!rsMinions.isBeforeFirst() && isVillainExists)
            System.out.print("<no minions>\n");
        else if (isVillainExists) {
            rsMinions.beforeFirst();
            int count = 1;
            while (rsMinions.next())
                System.out.printf("%d. %s %d%n", count++, rsMinions.getString(1), rsMinions.getInt(2));
        }

    }

    public void p4AddMinion() throws IOException, SQLException {
        System.out.print(TasksDefinition.p4);
        String[] params = br.readLine().split("\\s+");
        String minionName = params[1];
        int age = Integer.parseInt(params[2]);
        String town = params[3];
        String villain = br.readLine().split("\\s+")[1];
        int town_id = checkTown(town);
        int villain_id = checkVillain(villain);
        int minion_id = checkForMinionId(minionName);
        int isAddMinion = 0;
        PreparedStatement st;

        if (minion_id == 0) {
            String addMinion = String.format("INSERT INTO minions(name, age, town_id)\n " +
                    "VALUE('%s', %d, %d)", minionName, age, town_id);
            st = connection.prepareStatement(addMinion);
            isAddMinion = st.executeUpdate();
        } else {
            String addMinionToVillain = String.format("INSERT INTO villains_minions(villain_id, minion_id)\n" +
                    "VALUE(%d, %d)", villain_id, minion_id);
            st = connection.prepareStatement(addMinionToVillain);
            int isAddMinionToVillain = st.executeUpdate();
            st.close();

            if (isAddMinion > 0 || isAddMinionToVillain > 0)
                System.out.printf("Successfully added %s to be minion of %s%n.", minionName, villain);
        }
    }

    public void p5ChangeTownNameToUpperCase() throws IOException, SQLException {
        System.out.print(TasksDefinition.p5);
        String country = br.readLine();
        String townsToUpper = String.format("UPDATE towns as t\n" +
                "SET t.name = upper(t.name)\n" +
                "WHERE t.country = '%s'", country);
        String selectTowns = String.format("SELECT t.name\n" +
                "FROM towns as t\n" +
                "WHERE t.country = '%s'", country);
        PreparedStatement ps = connection.prepareStatement(townsToUpper);
        int affectedTown = ps.executeUpdate();
        ps.close();
        StringBuilder sb = new StringBuilder();

        if (affectedTown > 0) {
            sb.append(affectedTown).append(" names were affected.\n[");
            ps = connection.prepareStatement(selectTowns);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                sb.append(resultSet.getString(1));
                if (!resultSet.isLast())
                    sb.append(", ");
            }

            resultSet.close();
            sb.append("]");
        } else {
            sb.append("No town names were affected.");
        }

        ps.close();
        System.out.println(sb);
    }

    public void p6RemoveVillain() throws IOException, SQLException {
        System.out.print(TasksDefinition.p6);
        int id = Integer.parseInt(br.readLine());
        PreparedStatement psFindVillain = connection.prepareStatement(findVillainQuery);
        psFindVillain.setInt(1, id);
        ResultSet resultSet = psFindVillain.executeQuery();
        String name = "";

        if (resultSet.isBeforeFirst()) {
            resultSet.next();
            name = resultSet.getString(1);
        } else {
            System.out.println("No such villain was found");
            return;
        }
        int n = 0;

        if (!name.isEmpty()) {
            String deleteVillainQue = "DELETE FROM villains WHERE id = " + id;
            String releaseMinionQuery = "DELETE FROM villains_minions WHERE villain_id = " + id;
            PreparedStatement ps;
            ps = connection.prepareStatement(releaseMinionQuery);
            n = ps.executeUpdate();
            ps.close();
            System.out.println(name + " was deleted");


            ps = connection.prepareStatement(deleteVillainQue);
            ps.executeUpdate();

            System.out.println(n + " minions released");
        }

    }

    public void p7PrintAllMinion() throws SQLException {
        System.out.print(TasksDefinition.p7);
        List<String> minions = new ArrayList<>();
        String query = "SELECT m.name\n" +
                "FROM minions as m";
        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery(query);

        while (resultSet.next())
            minions.add(resultSet.getString(1));

        int len = minions.size();

        for (int i = 0; i < len; i++) {
            int index;
            if (i % 2 == 0)
                index = i / 2;
            else
                index = len - 1 - i / 2;

            System.out.println(minions.get(index));
        }

    }

    public void p8IncreaseMinionAge() throws IOException, SQLException {
        System.out.print(TasksDefinition.p8);
        int[] indexes = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int index : indexes) {
            increaseAge(index);
        }

        printAllMinionWithAge();
    }

    public void p9CallStoredProcedure() throws SQLException, IOException {
        System.out.print(TasksDefinition.p9);
        int id = Integer.parseInt(br.readLine());
        String procedure = "CALL usp_get_older(?)";
        PreparedStatement ps = connection.prepareStatement(procedure);
        ps.setInt(1, id);

        boolean execute = ps.execute();

        if (execute) {
            ResultSet resultSet = ps.getResultSet();
            if (resultSet.isBeforeFirst()) {
                resultSet.next();
                System.out.printf("%s %d%n", resultSet.getString(1), resultSet.getInt(2));
                resultSet.close();
            } else
                System.out.println("No such id!");
        }

        ps.close();

    }

    private void printAllMinionWithAge() throws SQLException {
        String query = "SELECT m.name, m.age FROM minions as m";
        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery(query);

        while (resultSet.next())
            System.out.printf("%s %d%n", resultSet.getString(1), resultSet.getInt(2));

        st.close();
    }

    private void increaseAge(int id) throws SQLException {
        String findMinionQuery = "SELECT m.name\n" +
                "FROM minions as m\n" +
                "WHERE m.id = " + id;
        String addAge = "UPDATE minions as m\n" +
                "SET m.name = ?, m.age = m.age +1\n" +
                "WHERE m.id = " + id;
        Statement st = connection.createStatement();
        ResultSet resultSet = st.executeQuery(findMinionQuery);
        PreparedStatement ps = connection.prepareStatement(addAge);

        if (resultSet.isBeforeFirst()) {
            resultSet.next();
            String name = resultSet.getString(1);
            ps.setString(1, titleCase(name));
            ps.executeUpdate();
            ps.close();
        }

    }

    private String titleCase(String s) {

        final String DELIMITERS = " '-/"; // these cause the character following
        // to be capitalized

        StringBuilder sb = new StringBuilder();
        boolean capNext = true;

        for (char c : s.toCharArray()) {
            c = (capNext)
                    ? Character.toUpperCase(c)
                    : Character.toLowerCase(c);
            sb.append(c);
            capNext = (DELIMITERS.indexOf(c) >= 0);
        }
        return sb.toString();
    }

    private int checkForMinionId(String minionName) throws SQLException {
        String query = String.format("SELECT m.id\n" +
                "FROM minions as m\n" +
                "WHERE m.name = '%s'", minionName);
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.isBeforeFirst()) {
            resultSet.next();
            return resultSet.getInt(1);
        }
        preparedStatement.close();
        resultSet.close();

        return 0;
    }

    private int checkVillain(String villain) throws SQLException {
        PreparedStatement prst = connection.prepareStatement("SELECT v.id\n" +
                "FROM villains as v\n" +
                "WHERE v.name = ?");
        prst.setString(1, villain);

        ResultSet rs = prst.executeQuery();
        if (!rs.isBeforeFirst()) {
            PreparedStatement addVillain = connection.prepareStatement("INSERT INTO villains(name, evilness) " +
                    " VALUE (?, 3)");
            addVillain.setString(1, villain);
            addVillain.executeUpdate();
            addVillain.close();
            rs.close();
            System.out.printf("Villain %s was added to the database.%n", villain);
            rs = prst.executeQuery();
        }

        rs.next();
        int villain_id = rs.getInt(1);
        rs.close();
        prst.close();

        return villain_id;
    }

    private int checkTown(String town) throws SQLException {
        PreparedStatement prst = connection.prepareStatement("SELECT t.id\n" +
                "FROM towns as t\n" +
                "WHERE t.name = ?");
        prst.setString(1, town);

        ResultSet rs = prst.executeQuery();
        if (!rs.isBeforeFirst()) {
            PreparedStatement addTown = connection.prepareStatement("INSERT INTO towns(`name`) VALUE (?)");
            addTown.setString(1, town);
            addTown.executeUpdate();
            addTown.close();
            rs.close();
            System.out.printf("Town %s was added to the database.%n", town);
            rs = prst.executeQuery();
        }

        rs.next();
        int town_id = rs.getInt(1);
        rs.close();
        prst.close();
        return town_id;
    }


}
