package txtProcess;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class sentenceDivison {
    public static List<String> sDivison(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
       StringBuilder stringBuilder=new StringBuilder();
       String Add;
       while((Add=bufferedReader.readLine())!=null){
           stringBuilder.append(Add);
       }
        String[] setence=stringBuilder.toString()
                .replace(" ", "")
                .replace("”","")
                .replace("：“","")
                .replace("？","。")
                .split("。");
        List<String> senlist= Arrays.asList(setence);
        return senlist;
    }
}
