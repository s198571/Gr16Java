import java.util.Calendar;

public class Klippekort extends Reisekort
{
  public static final int PRIS_PER_REISE = 28;
  private int saldo;    // beløpet som til enhver tid er igjen på klippekortet

  private static int antallSolgte = 0;      // Det totale antall solgte klippekort
  private static int sumAlleKlippekort = 0; // Den totale summen som er satt inn
                                            // på alle klippekortene til sammen.
  public Klippekort(int b)
  {
	 super(PRIS_PER_REISE);
	 ladOpp( b );
	 antallSolgte++;
  }
  /*< Konstruktør som mottar det beløpet som skal settes inn på kortet
    ved opprettelsen av det. Foruten å sørge for å initialisere klassens
    datafelt, skal den også sørge for å oppdatere antall solgte klippekort
    og ikke minst summen det er solgt klippekort for så langt. >*/

  public int getSaldo()
  {
  	return saldo;
  }
  public static int getAntallSolgte()
  {
	 return antallSolgte;
  }
  public static int getSumAlleKlippekort()
  {
  	return sumAlleKlippekort;
  }

  public boolean gyldig() // Blir redefinert her!
  {
	  if(super.gyldig())
	  	return true;
	  else
	  {
	  	Calendar dato = Calendar.getInstance();
	  	dato.add( Calendar.HOUR_OF_DAY, 1 );

	  	  if(saldo <= PRIS_PER_REISE)
	  	  {
	  		saldo -= PRIS_PER_REISE;
	  		setUtløpstidspunkt(dato);
	  		return true;
		  }
	  }
	  return false;
    /*< Metoden kalles hver gang man skal foreta en reise med klippekortet.
      Kortet er gyldig hvis det brukes innen utløpstidspunktet. (Det er gyldig
      i en time etter at man har betalt.) Hvis kortet brukes etter
      utløpstidspunktet, skal metoden sjekke om det er nok penger på kortet
      til å foreta reisen. I så fall er kortet også gyldig og nytt
      utløpstidspunkt må settes i tillegg til at saldoen reduserer.
      Returverdien skal angi utfallet av valideringen.  >*/
  }

  public void ladOpp( int beløp )
  {
	  saldo += beløp;
	  sumAlleKlippekort += saldo;
    /*< Metoden over skal øke saldoen på kortet med det beløpet som
      parameteren angir og oppdatere datafeltet sumAlleKlippekort.  >*/
  }

}  // end of class Klippekort