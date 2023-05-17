package ma.uiass.eia.pds.Model;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum StateName {
        F("Fonctionnel"),
        NFCD("Non Fonctionnel Courte Durée"),
        NFLD("Non Fonctionnel Longue Durée");

        private final String name;

        StateName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

}

