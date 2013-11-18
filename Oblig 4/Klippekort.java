import java.util.Calendar;

public class Klippekort extends Reisekort
{
  public static final int PRIS_PER_REISE = 28;
  private int saldo;    // bel�pet som til enhver tid er igjen p� klippekortet

  private static int antallSolgte = 0;      // Det totale antall solgte klippekort
  private static int sumAlleKlippekort = 0; // Den totale summen som er satt inn
                                            // p� alle klippekortene til sammen.
  public Klippekort(int b)
  {
	 super(PRIS_PER_REISE);
	 ladOpp( b );
	 antallSolgte++;
  }
  /*< Konstrukt�r som mottar det bel�pet som skal settes inn p� kortet
    ved opprettelsen av det. Foruten � s�rge for � initialisere klassens
    datafelt, skal den ogs� s�rge for � oppdatere antall solgte klippekort
    og ikke minst summen det er solgt klippekort for s� langt. >*/

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
	  		setUtl�pstidspunkt(dato);
	  		return true;
		  }
	  }
	  return false;
    /*< Metoden kalles hver gang man skal foreta en reise med klippekortet.
      Kortet er gyldig hvis det brukes innen utl�pstidspunktet. (Det er gyldig
      i en time etter at man har betalt.) Hvis kortet brukes etter
      utl�pstidspunktet, skal metoden sjekke om det er nok penger p� kortet
      til � foreta reisen. I s� fall er kortet ogs� gyldig og nytt
      utl�pstidspunkt m� settes i tillegg til at saldoen reduserer.
      Returverdien skal angi utfallet av valideringen.  >*/
  }

  public void ladOpp( int bel�p )
  {
	  saldo += bel�p;
	  sumAlleKlippekort += saldo;
    /*< Metoden over skal �ke saldoen p� kortet med det bel�pet som
      parameteren angir og oppdatere datafeltet sumAlleKlippekort.  >*/
  }

}  // end of class Klippekort