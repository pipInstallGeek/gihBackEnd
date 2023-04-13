package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum TypeChambre {
    SIMPLE,
    DOUBLE,
    SUITE,
    @JsonEnumDefaultValue UNKNOWN;


    TypeChambre() {
    }
}