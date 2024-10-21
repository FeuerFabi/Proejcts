interface LoginInterface {

    String[] displayText = {
            "email: ",  // 0
            "email (Keine Whitespaces und muss '@' haben): ", // 1
            "Falsche Email!", // 2
            "passwort: ", // 3
            "Falsches Passwort!", // 4
            "Bitte registrieren!", // 5
            "Bitte anmelden!", // 6
            "Du bist nun angemeldet!" // 7
    };

    void registrierung();
    void anmelden();
}
