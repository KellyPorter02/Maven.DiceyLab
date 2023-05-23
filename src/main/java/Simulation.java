public class Simulation {

    private int numOfDies;
    private int numOfTosses;
    private Dice dice;
    private Bins bins;

    public Simulation(int numOfDies, int numOfTosses) {
        this.numOfDies = numOfDies;
        this.numOfTosses = numOfTosses;
        dice = new Dice(numOfDies);
        int maxBinNum = numOfDies * 6;
        bins = new Bins(numOfDies, maxBinNum);
    }

    public int getNumOfDies() {
        return numOfDies;
    }

    public int getNumOfTosses() {
        return numOfTosses;
    }

    public Bins getBins() {
        return bins;
    }

    public void runSimulation() {
        // do stuff
        // toss die, update bins
        // loop num of times
        // check map
        for (int i = 0; i < numOfTosses; i++) {
            int resultOfToss = dice.tossAndSum();
            bins.incrementBin(resultOfToss);
        }
    }


}
