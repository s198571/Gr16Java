/*	Hallbj�rn Srorruste, studentnr: s165519 , HINGDATA131AA
		Thomas Newman, studentnr: s198753, HINGDATA131AA
		Adrian Westlund, studentnr: s198571, INFORMATIK13H1IA

*/

import java.util.Calendar;

public class M�nedskort extends Reisekort
{
  public final static int M�NEDSPRIS = 1040;
  private int saldo;    // bel�pet som til enhver tid er igjen p� klippekortet
	private static int antallSolgte = 0;
	private static int sumAlleM�nedskort = 0; // Den totale summen som er satt inn
                                            // p� alle m�nedskortene til sammen.

  public M�nedskort()
  {
		super(M�NEDSPRIS);
		antallSolgte++;
		sumAlleM�nedskort += M�NEDSPRIS;
		saldo = M�NEDSPRIS;
	}

  public static int getSumAlleM�nedskort()
  {
		return sumAlleM�nedskort;
	}

  public static int getAntallSolgte()
  {
		return antallSolgte;
	}

  public boolean gyldig()
  {
		if(super.gyldig())
			return true;
		else if(saldo == M�NEDSPRIS)
		{
			Calendar dato = Calendar.getInstance();

			dato.add( Calendar.HOUR_OF_DAY, (24*30) );

			setUtl�pstidspunkt(dato);

			saldo -= M�NEDSPRIS;

			return true;
		}
		else
			return false;

		/*	< Metoden kalles hver gang man skal foreta en reise med klippekortet.
      Kortet er gyldig hvis det brukes innen utl�pstidspunktet. (Det er gyldig
      i en time etter at man har betalt.) Hvis kortet brukes etter
      utl�pstidspunktet, skal metoden sjekke om det er nok penger p� kortet
      til � foreta reisen. I s� fall er kortet ogs� gyldig og nytt
      utl�pstidspunkt m� settes i tillegg til at saldoen reduserer.
      Returverdien skal angi utfallet av valideringen.  >}  // redefinert*/
	}

}  // end of class M�nedskort