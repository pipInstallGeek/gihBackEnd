package ma.uiass.eia.pds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class MainPy {

    public static void main(String[] args) throws IOException {
        List<Integer> integerList = Arrays.asList(1, 0, 2,2);
        int nbrofsteps = 5;
            String list = String.join(",", integerList.stream().map(Object::toString).toArray(String[]::new));
        String nbrStr = Integer.toString(nbrofsteps);
        Path projectdir = Paths.get("").toAbsolutePath();
        String cwd = String.valueOf(projectdir);
        System.out.println(cwd);
        //Path cwd = Paths.get(projectdir, "Python");
        ProcessBuilder processBuilder = new ProcessBuilder("py", "Python\\PredictionBed.py",list, nbrStr);
        Process process = processBuilder.start();

        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line;
        while (((line= input.readLine()))!= null ){
            System.out.println(line);}
        while (((line= error.readLine()))!= null ){
            System.out.println(line);}
    }
}
