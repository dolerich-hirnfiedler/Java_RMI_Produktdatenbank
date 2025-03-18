package de.eldecker.produktdatenbank.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import de.eldecker.produktdatenbank.model.ProduktRecord;

/**
 * ProduktDatenbank
 */
public interface ProduktDatenbank extends Remote {

	/**
	 * Produkt anhand {@code produktnummer} in "Datenbank" suchen.
	 *
	 * @param produktnummer Produktnummer (positive Zahl)
	 *
	 * @return Produkt wenn gefunden, sonst {@code null}
	 */
	public ProduktRecord holeProdukt(int produktnummer) throws RemoteException;

}
