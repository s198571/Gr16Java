

public class RuterPluss
{
	public static void main(String[]args)
	{
		ReisekortSystem system = new ReisekortSystem();
		ReiseKortSalg salg = new ReiseKortSalg(system);
		Kontrollvindu kontroll = new Kontrollvindu(system);
		Administrasjonsvindu admin = new Administrasjonsvindu();

	}
}