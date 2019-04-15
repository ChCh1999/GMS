package Data;

import java.sql.*;

public class DataText {
    public static void main(String[] args) {

        DataOperation dataOperation=new DataOperation();
        String formname="student",condition="201730258",modified="赵彪";
        dataOperation.ModifyPID(condition,modified);
        dataOperation.finalize();
    }
}
