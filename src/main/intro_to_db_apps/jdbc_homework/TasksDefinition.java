package jdbc_homework;

public class TasksDefinition {
    public static String welcome = "Input which problem you want to test(p2, p3...p9) \nor type 'exit' to close the program:";

    public static String p2 = "Write a program that prints on the console all villains’ names \n" +
            "and their number of minions of those who has more than 3 minions \n" +
            "ordered descending by number of minions.\n";

    public static String p3 = "Write a program that prints on the console all minion names and age for given villain id.\n" +
            "Input villain id:";

    public static String p4 = "Write a program that reads information about minion and its villain \n" +
            "and adds it to the database. In case the town of the minion is not in the database \n" +
            "insert it as well. In case the villain is not present in the database add him too \n" +
            "with default evilness factor of “evil”. Finally set the new minion to be servant \n" +
            "of the villain and villain. Print appropriate messages after each operation.\n";

    public static String p5 = "Write a program that change all town names to uppercase for towns for given country.\n" +
            "Input country name:";

    public static String p6 = "Write a program that receives ID of a villain, deletes him from the database \n" +
            "and releases his minions from serving to him. \n" +
            "Input villain id:";

    public static String p7 = "Write a program that prints all minion names from the minions table \n" +
            "in order first record, last record, first + 1, last – 1, first + 2, last – 2… first + n, last – n. \n";

    public static String p8 = "Read from console minion IDs separated by space. \n" +
            "Increment age of those minions by 1 and make their name title case. \n" +
            "Finally print names and ages of all minions that are in the database.\n";

    public static String p9 ="Write a program that uses that stored procedure to increase \n" +
            "age of a minion whose id will be given as input from the console. \n" +
            "After that print the name and the age of that minion\n" +
            "Input minion id:";
}
