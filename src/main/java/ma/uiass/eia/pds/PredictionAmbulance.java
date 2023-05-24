package ma.uiass.eia.pds;


import ma.uiass.eia.pds.Model.StateAMB;

import static java.lang.Math.max;

public class PredictionAmbulance {

    public static double[][] getMat(double x){
        double q = 7/9;
        double A = 100;
        double B = 100;
        double alpha0 = max((A - x) / B,0);
        double alpha1 = max((A - x) / B,0);
        double alpha2 = max((A - x) / B,0);
        double gamma1 = (1-alpha0)*q;
        double gamma2 = (1-alpha0)*(1-q);
        return new double[][]{{alpha0, gamma1, gamma2},{1-alpha1, alpha1, 0},{1-alpha2, 0, alpha2}};
    }

    public static double getM(double[][] P, int i, int j){
        return (P[i][i] + P[i][j] - (P[i][i] * P[j][j]) + (P[i][j] * P[j][i]))/(1 - P[i][i] - P[j][j]+ (P[i][i] * P[j][j]) - (P[i][j] * P[j][i]));
    }

    public static void setY(double[][] P, StateAMB state){
        if (state.getNomState().equalsIgnoreCase("nfcd")){
            state.setParaY(getM(P, 1, 0) - state.getParaX());
        }
        if (state.getNomState().equalsIgnoreCase("nfld")){
            state.setParaY(getM(P, 2, 0) - state.getParaX());
        }
    }
}
