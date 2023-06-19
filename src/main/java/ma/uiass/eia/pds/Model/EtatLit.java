package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

import java.io.Serializable;

public enum EtatLit implements Serializable {
    BONNNEETAT ("BONNNEETAT"),
    DEFECTUEUSE ("DEFECTUEUSE");
    private String nom;

    EtatLit(String nom) {
        this.nom = nom;
    }

}
