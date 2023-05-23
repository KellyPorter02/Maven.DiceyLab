import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Results {

    private Simulation sim;
    private int numDice;
    private int numTosses;
    private Bins bins;
    private Map<Integer,Integer> sumResults;
    private Map<Integer,String> pcResults;
    private Map<Integer,String> starsResults;


    public Results(Simulation sim) {
        this.sim = sim;
        bins = sim.getBins();
        numTosses = sim.getNumOfTosses();
        createResultsMaps();
        populateResults();
    }

    private void createResultsMaps() {
        int min = bins.getMinBin();
        int max = bins.getMaxBin();

        sumResults = new HashMap<Integer, Integer>();
        pcResults = new HashMap<Integer, String>();
        starsResults = new HashMap<Integer, String>();

        for (int i = min; i <= max; i++) {
            sumResults.put(i, 0);
            pcResults.put(i, "0");
            starsResults.put(i, "");
        }
    }

    public void populateResults() {
        populateSumResults();
        populatePcResults();
        populateStarsResults();
    }

    private void populateSumResults() {
        // foreach bin in bins, saveBinnum result is binnum * count, put(binNum, result)
        for (int binNum: bins.getBinsMap().keySet()) {
            int count = bins.getBinCount(binNum);
            int sumResult = count * binNum;
            sumResults.put(binNum, sumResult);
        }
    }

    private void populatePcResults() {
        // foreach bin in bins, count/numrolls, round to 2decimal, put in pcresults
        for (int binNum: bins.getBinsMap().keySet()) {
            int count = bins.getBinCount(binNum);
            String pcResult = calcPc(count, numTosses);
            pcResults.put(binNum, pcResult);
        }
    }

    private String calcPc(int count, int numRolls) {
        double pc = (double) count / (double) numRolls;
        BigDecimal bd = new BigDecimal(pc);
        bd = bd.setScale(2, RoundingMode.HALF_EVEN);
        pc = bd.doubleValue();
        DecimalFormat df = new DecimalFormat("0.00");
        String formattedStr = df.format(pc);
        return formattedStr;
    }

    public int getNumTosses() {
        return numTosses;
    }

    public Bins getBins() {
        return bins;
    }

    public Map<Integer, Integer> getSumResults() {
        return sumResults;
    }

    public Map<Integer, String> getPcResults() {
        return pcResults;
    }

    public Map<Integer, String> getStarsResults() {
        return starsResults;
    }

    private void populateStarsResults() {
        // for each bin, use binnum to pull pc from pcresults, multiply by 100, cast to int,
        // make string w that numb of stars, add to starsresults
        for (int binNum: bins.getBinsMap().keySet()) {
            String pcRes = pcResults.get(binNum);
            double pcDb = Double.parseDouble(pcRes);
            int pcInt = (int) (pcDb * 100);
            String stars = createStarsStr(pcInt);
            starsResults.put(binNum, stars);
        }
    }

    private String createStarsStr(int numStars) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numStars; i++) {
            result.append("*");
        }
        return result.toString();
    }

    @Override
    public String toString() {
        return "Results{" +
                "numTosses=" + numTosses +
                ", bins=" + bins +
                ", sumResults=" + sumResults.toString() +
                ", pcResults=" + pcResults.toString() +
                ", starsResults=" + starsResults.toString() +
                '}';
    }

    public Simulation getSim() {
        return sim;
    }


}
