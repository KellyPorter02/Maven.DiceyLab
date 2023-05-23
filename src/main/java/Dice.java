public class Dice {

    private int numDice;


    public Dice(int numDice) {
        this.numDice = numDice;
    }

    public int getNumDice() {
        return numDice;
    }

    public Integer tossAndSum() {
        int sum = 0;
        int numRolls = numDice;

        for (int i = 0; i < numRolls; i++) {
            sum += (int) (Math.random()*(7-1)) + 1;
        }
        return sum;
    }

}
