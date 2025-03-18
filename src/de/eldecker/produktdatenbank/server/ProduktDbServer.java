package de.eldecker.produktdatenbank.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Klasse mit Startmethode für Server (inkl. RMI-Registry).
 */
public class ProduktDbServer {

	/** Default-Port-Nummer für RMI-Registry ist 1099. */
	private static final int PORT_RMI_REGISTRY = 1_099;

	/**
	 * Port, unter dem das <i>Remote Objekt</i> bereitgestellt wird; wenn {@code 0},
	 * dann wird zur Laufzeit ein freier Port gewählt.
	 */
	private static final int PORT_OBJECT = 50_000;

	/**
	 * Einstiegsmethode.
	 * 
	 * @param args Kommandozeilenargumente, werden nicht ausgewertet.
	 * 
	 * @throws RemoteException       Fehler bei RMI-Übertragung
	 * 
	 * @throws AlreadyBoundException Fehler wenn Port für RMI-Registry schon belegt
	 */
	public static void main(String[] args) throws RemoteException,
			AlreadyBoundException {

		System.out.println();

		final Registry registry = LocateRegistry.createRegistry(PORT_RMI_REGISTRY);
		System.out.println("RMI-Registry an Port-Nr. " + PORT_RMI_REGISTRY + " gestartet.");

		ProduktDatenbankImpl db = new ProduktDatenbankImpl();

		// Export the remote object
		ProduktDatenbank stub = (ProduktDatenbank) UnicastRemoteObject.exportObject(db, PORT_OBJECT);

		// Bind the remote object to the registry
		String serviceName = "ProduktDatenbankService";
		registry.bind(serviceName, stub);
		System.out.println("Remote object bound in registry with neame: " + serviceName);


		System.out.println("\nProduktdatenbank wartet auf Anfragen ...");

	}

}
