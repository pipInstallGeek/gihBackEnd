package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

import java.io.Serializable;

public enum EtatLit implements Serializable {
    @JsonEnumDefaultValue
    UNKNOWN,
    BONNNEETAT,
    DEFECTUEUSE;



    EtatLit() {
    }


}
