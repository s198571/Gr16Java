/*	Hallbjørn Srorruste, studentnr: s165519 , HINGDATA131AA
		Thomas Newman, studentnr: s198753, HINGDATA131AA
		Adrian Westlund, studentnr: s198571, INFORMATIK13H1IA

*/

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