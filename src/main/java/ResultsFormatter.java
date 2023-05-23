public class ResultsFormatter {
    private Results results;

    // takes in Results, sets up toString


    public ResultsFormatter(Results results) {
        this.results = results;
    }

    public String printResults() {
        StringBuilder sb = new StringBuilder();

        sb.append("*** \n");
        sb.append("Simulation of " + results.getSim().getNumOfDies() + " dice tossed for " + results.getSim().getNumOfTosses() + " times. \n");
        sb.append("*** \n\n");

        for (int binNum: results.getBins().getBinsMap().keySet()) {

            int sum = results.getSumResults().get(binNum);
            String pc = results.getPcResults().get(binNum);
            String stars = results.getStarsResults().get(binNum);

            sb.append(String.format("%3d :%9d: %s %s\n", binNum ,sum ,pc ,stars));

        }

        return sb.toString();
    }


}
