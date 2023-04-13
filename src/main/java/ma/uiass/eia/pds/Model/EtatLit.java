package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum EtatLit {
    BONNNEETAT,
    DEFECTUEUSE,
    @JsonEnumDefaultValue UNKNOWN;


    EtatLit() {
    }

}
