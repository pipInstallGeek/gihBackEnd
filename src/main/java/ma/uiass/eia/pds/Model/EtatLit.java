package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

import java.io.Serializable;

public enum EtatLit implements Serializable {
    BONNNEETAT,
    DEFECTUEUSE,
    @JsonEnumDefaultValue UNKNOWN;


    EtatLit() {
    }

}
