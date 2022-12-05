import java.util.Comparator;

public class RatingComparator implements Comparator<Films> {
    /*compares two film object's rating*/
    @Override
    public int compare(Films firstF, Films secondF) {
        return Integer.compare(firstF.getRatingInteger(), secondF.getRatingInteger());
    }

}
