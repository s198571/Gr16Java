/*	Hallbjørn Srorruste, studentnr: s165519 , HINGDATA131AA
		Thomas Newman, studentnr: s198753, HINGDATA131AA
		Adrian Westlund, studentnr: s198571, INFORMATIK13H1IA

*/

import java.util.Calendar;

public class Månedskort extends Reisekort
{
  public final static int MÅNEDSPRIS = 1040;
  private int saldo;    // beløpet som til enhver tid er igjen på klippekortet
	private static int antallSolgte = 0;
	private static int sumAlleMånedskort = 0; // Den totale summen som er satt inn
                                            // på alle månedskortene til sammen.

  public Månedskort()
  {
		super(MÅNEDSPRIS);
		antallSolgte++;
		sumAlleMånedskort += MÅNEDSPRIS;
		saldo = MÅNEDSPRIS;
	}

  public static int getSumAlleMånedskort()
  {
		return sumAlleMånedskort;
	}

  public static int getAntallSolgte()
  {
		return antallSolgte;
	}

  public boolean gyldig()
  {
		if(super.gyldig())
			return true;
		else if(saldo == MÅNEDSPRIS)
		{
			Calendar dato = Calendar.getInstance();

			dato.add( Calendar.HOUR_OF_DAY, (24*30) );

			setUtløpstidspunkt(dato);

			saldo -= MÅNEDSPRIS;

			return true;
		}
		else
			return false;

		/*	< Metoden kalles hver gang man skal foreta en reise med klippekortet.
      Kortet er gyldig hvis det brukes innen utløpstidspunktet. (Det er gyldig
      i en time etter at man har betalt.) Hvis kortet brukes etter
      utløpstidspunktet, skal metoden sjekke om det er nok penger på kortet
      til å foreta reisen. I så fall er kortet også gyldig og nytt
      utløpstidspunkt må settes i tillegg til at saldoen reduserer.
      Returverdien skal angi utfallet av valideringen.  >}  // redefinert*/
	}

}  // end of class Månedskort