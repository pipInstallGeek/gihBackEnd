package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum Fournisseur {
    @JsonEnumDefaultValue UNKNOWN ,

    MedlineIndustries,
    CardinalHealth,
    McKessonCorporation,
    OwensAndMinor;

    Fournisseur(){}
}
