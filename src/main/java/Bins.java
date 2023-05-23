import java.util.HashMap;
import java.util.Map;

public class Bins {

    private int minBin;
    private int maxBin;
    private Map<Integer, Integer> binsMap;

    public Bins(int minBin, int maxBin) {
        this.minBin = minBin;
        this.maxBin = minBin * 6;
        binsMap = createBinsMap();
    }

    private Map<Integer, Integer> createBinsMap() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int counter = minBin;
        int initVal = 0;

        while (counter <= maxBin) {
            map.put(counter, initVal);
            counter++;
        }
        return map;
    }

    public Integer getBinCount(int binNum) {
        return binsMap.get(binNum);
    }

    public void incrementBin(int binNum) {
        int currCount = binsMap.get(binNum);
        currCount++;
        binsMap.put(binNum, currCount);
    }

    public Map<Integer, Integer> getBinsMap() {
        return binsMap;
    }

    public int getMinBin() {
        return minBin;
    }

    public int getMaxBin() {
        return maxBin;
    }

    @Override
    public String toString() {
        return binsMap.toString();
    }


}
