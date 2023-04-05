package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


public enum EtatLit {
    BONNNEETAT,
    DEFECTUEUSE,
    @JsonEnumDefaultValue UNKNOWN;


    EtatLit() {
    }

}
