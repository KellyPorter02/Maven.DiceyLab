public class DiceyRunner implements Runnable{
    public void run() {
        Simulation simulation = new Simulation(ConsoleInput.askForNumDice(), ConsoleInput.askForNumRolls());
        simulation.runSimulation();
        ResultsWriter writer = new ResultsWriter(new ResultsFormatter(new Results(simulation)));
        writer.writeOutToFile();
    }

    public static void main(String[] args) {
        DiceyRunner dicey = new DiceyRunner();
        dicey.run();
    }
}
