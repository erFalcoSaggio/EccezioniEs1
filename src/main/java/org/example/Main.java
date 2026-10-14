package org.example;

import static java.lang.IO.println;

public class Main {
    public static void main(String[] args) throws SaldoInsufficienteException {
        ContoBancario conto = new ContoBancario(100.0);

        try {
            conto.preleva(150.0);
        } catch (SaldoInsufficienteException e) {
            println("Deficit: " + e.getDeficit());
        } finally {
            println("Operazione terminata.");
        }

        try {
            conto.preleva(-20.0);
        } catch (ImportoNonValidoException e) {
            println("Errore importo: " + e.getMessage());
        }

        conto.preleva(50.0);
        println("Operazione completata con successo. Saldo: " + conto.getSaldo());
    }
}
