import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: Tools
 * @Description:
 * @Author jinzbone
 * @Date: 2020/7/30 11:18
 * @Version 1.0
 */
public class Tools {


    public static void main(String[] args) throws SQLException {
        Tools tool = new Tools();
        List<Integer> lst1 = new ArrayList<Integer>();
        List<Integer> lst2 = new ArrayList<Integer>();
        lst1.add(1);
        lst1.add(2);
        lst2.add(3);
        lst2.add(4);
        System.out.println(lst1.addAll(lst2));
        System.out.println(lst1);

    }
}
