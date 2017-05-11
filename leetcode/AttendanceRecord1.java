package leetcode;

/**
 * Created by neagrawa on 4/27/17.
 */
public class AttendanceRecord1 {
    public boolean checkRecord(String s) {
       return !(s.contains("LLL") || s.indexOf('A')!=s.lastIndexOf('A'));
    }
}
