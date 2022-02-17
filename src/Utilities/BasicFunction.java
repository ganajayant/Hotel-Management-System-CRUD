package Utilities;

public class BasicFunction {
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void Help() {
        System.out.println("Insert:");
        System.out.println("Enter your query in the format : '--insert --<Attrbute Name> <Path>'");
        System.out.println("\t\t\t Attributes: 1.employees 2.customers 3.rooms 4.dishes");
        System.out.println("\t\t\t Path --> Defines the location Of the CSV file");
        System.out.println("\n\nDelete:");
        System.out.println("Enter your query in the format : '--insert --<Attrbute Name> <Key>'");
        System.out.println("\t\t\t Attributes: 1.employees 2.customers 3.rooms 4.dishes");
        System.out.println("\t\t\t Key --> A Unique Id for which ensures the identity");
        System.out.println("\t\t\t         Attributes           Key          ");
        System.out.println("\t\t\t          Customer             phonenumber  ");
        System.out.println("\t\t\t          Room                 roomnumber   ");
        System.out.println("\t\t\t          Dish                 DishName  ");
        System.out.println("\n\nUpdate:");
        System.out.println("Enter your query in the format : '--update --<Attrbute Name> <Path>'");
        System.out.println("\t\t\t Attributes: 1.employees 2.customers 3.rooms 4.dishes");
        System.out.println("\t\t\t Path --> Defines the location Of the CSV file");
        System.out.println("\n\nSearch:");
        System.out.println("Enter your query in the format : '--search --<Attrbute Name> <value> --<expression> '");
        System.out.println("\t\t\t Attributes: 1.employees 2.customers 3.rooms 4.dishes");
        System.out.println(
                "\t\t\t Value --> The value based on which you wanted to Searchm, It may be a Integer or String");
        System.out.println("\t\t\t Based On the data type of choose the appropriate expression notation");
        System.out.println("\t\t\t Expression_Notation   Original Expression    Data_Type_Of_Value");
        System.out.println("\t\t\t     gt                           >              Int             ");
        System.out.println("\t\t\t     gte                          >=             Int             ");
        System.out.println("\t\t\t     lt                           <              Int             ");
        System.out.println("\t\t\t     lte                          <=             Int             ");
        System.out.println("\t\t\t     e                             =             Int             ");
        System.out.println("\t\t\t     ni                            =             String          ");
        System.out.println("Enter your query in the format : '--aggregate <Attribute Name>'");
        System.out.println("\t\t\t Attributes: 1.employees 2.customers 3.rooms 4.dishes");
        System.out.println("\n\n\nTo see the version : --v");
    }

    public static void Version() {
        System.out.println("Hotel Management System Version 1.0 ");
        System.out.println("Copyright (C) Group-20");
        System.out.println("There is NO warranty not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE");
    }
}