package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum TypeSalle {
    @JsonEnumDefaultValue UNKNOWN,

    CONSULTATION,
    RADIOLOGIE,
    REANIMATION,
    OPERATION;

    TypeSalle() {
    }
}
