import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class ResultsWriter {

    private PrintWriter outLine;
    private String filePath = "/Users/kellsbells/Projects/zcw/Maven.DiceyLab/KellyResults.txt";
    private ResultsFormatter rf;
    private List<String> resultStrList;


    public ResultsWriter(ResultsFormatter rf) {
        this.rf = rf;
        createPrintWriter();
        resultStrList = readInResultsString();
    }

    private void createPrintWriter() {
        try {
            outLine = new PrintWriter(new File(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("The file doesn't exist or isn't able to be made.");
        }
    }

    public List<String> readInResultsString() {
        String resultsStr = rf.printResults();
        String[] resArr = resultsStr.split("\n");
        return Arrays.asList(resArr);
    }

    public void writeOutToFile() {
        for (String line: resultStrList) {
            outLine.println(line);
        }
        outLine.close();
    }


}
