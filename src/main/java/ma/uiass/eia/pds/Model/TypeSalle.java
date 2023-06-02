package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

import java.io.Serializable;

public enum TypeSalle implements Serializable {
    @JsonEnumDefaultValue
    UNKNOWN,

    CONSULTATION,
    RADIOLOGIE,
    REANIMATION,
    STOCK,
    OPERATION;

    TypeSalle() {
    }
}
