package tn.esprit.autoloc.domain;

public enum StatutReservation {
    EN_ATTENTE {
        @Override
        public boolean autoriseTransitionVers(StatutReservation prochain) {
            return prochain == CONFIRMEE || prochain == ANNULEE;
        }
    },
    CONFIRMEE {
        @Override
        public boolean autoriseTransitionVers(StatutReservation prochain) {
            return prochain == TERMINEE || prochain == ANNULEE;
        }
    },
    ANNULEE {
        @Override
        public boolean autoriseTransitionVers(StatutReservation prochain) {
            return false;
        }
    },
    TERMINEE {
        @Override
        public boolean autoriseTransitionVers(StatutReservation prochain) {
            return false;
        }
    };

    public abstract boolean autoriseTransitionVers(StatutReservation prochain);
}