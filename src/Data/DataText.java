package Data;

import org.javatuples.Triplet;

import java.sql.*;
import java.util.ArrayList;

public class DataText {
    public static void main(String[] args) {

        DataOperation dataOperation=new DataOperation();
        String AID="2";
        ArrayList<Triplet<String,Float,Integer>> res=dataOperation.SearchTheTeamRank("2",2);

    }
}
