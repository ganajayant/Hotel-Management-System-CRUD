package Utilities;

import java.sql.ResultSet;

public class Print {
    public static void printHeader(ResultSet rs) {

        try {
            System.out.println("Search Result: ");
            System.out.println("----------------------------------------------------------------------------");
            int count = rs.getMetaData().getColumnCount();

            String colName[] = new String[count];
            for (int i = 0; i < count; i++) {
                colName[i] = (String) rs.getMetaData().getColumnLabel(i + 1);
                System.out.printf("%15s", colName[i]);
            }
            System.out.println("\n----------------------------------------------------------------------------");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void printValues(ResultSet rs) {
        try {
            if (!rs.isBeforeFirst()) {
                System.out.println("                                    No Data");
                System.exit(0);
            }
            int count = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 0; i < count; i++) {
                    Object val = rs.getObject(i + 1);
                    System.out.printf("%15s", val);
                }
                System.out.println();
            }
            System.out.println("----------------------------------------------------------------------------");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
