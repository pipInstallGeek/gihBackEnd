package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;

public enum TypeChambre implements Serializable {
    SIMPLE,
    DOUBLE,
    SUITE,
   @JsonEnumDefaultValue
    UNKNOWN;


    TypeChambre() {
    }
}