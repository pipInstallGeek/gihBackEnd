package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

import java.io.Serializable;

public enum TypeChambre implements Serializable {
    SIMPLE,
    DOUBLE,
    SUITE,
    @JsonEnumDefaultValue UNKNOWN;


    TypeChambre() {
    }
}