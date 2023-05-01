package ma.uiass.eia.pds.Model;

import java.util.Random;

public class GeneratedCode {

    public static String generatedCodeDemande(){
        Random random = new Random();
        int codeNumber = random.nextInt(900)+100;
        String code = "D"+codeNumber;
        return code;
    }
    public static String generatedCodeDetailDemande(){
        Random random = new Random();
        int codeNumber = random.nextInt(900)+100;
        String code = "DD"+codeNumber;
        return code;
    }
}
