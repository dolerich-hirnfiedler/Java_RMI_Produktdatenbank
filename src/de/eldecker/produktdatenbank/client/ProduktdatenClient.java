package de.eldecker.produktdatenbank.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import de.eldecker.produktdatenbank.model.ProduktRecord;
import de.eldecker.produktdatenbank.server.ProduktDatenbank;

public class ProduktdatenClient {

	public static void main(String[] args) throws RemoteException,
			NotBoundException {

		System.out.println();

		final String HOST = "127.0.0.1";
		final int PORT = 1_099;
		final Registry registry = LocateRegistry.getRegistry(HOST, PORT);
		final String serviceName = "ProduktDatenbankService";
		ProduktDatenbank produktDbStub = (ProduktDatenbank) registry.lookup(serviceName);
		System.out.println("Remote ProduktDatenbank oject found in registry.");

		int produktNummerToSearch = 222;
		System.out.println("\nSuchen nach Produktnummer: " + produktNummerToSearch);
		ProduktRecord produkt = produktDbStub.holeProdukt(produktNummerToSearch);
		if (produkt != null) {
			System.out.println("Produkt gefunden: " + produkt.toString());
		} else {
			System.out.println("Produkt mit Nummer " + produktNummerToSearch + " nicht gefunden");
		}

		System.out.println();

	}

}
