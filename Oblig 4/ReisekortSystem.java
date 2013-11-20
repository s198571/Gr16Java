public class ReisekortSystem
{
  public static final int ANTALL = 100;
  public static final int UTVIDELSE = 10;
  private Reisekort[] reisekortene;

  public ReisekortSystem()
  {
    reisekortene = new Reisekort[ANTALL];
    //< Oppretter arrayen med lengde lik ANTALL. >
  }

  public Reisekort finnReisekort(int nr)
  {
	  for(int i = 0; i < reisekortene.length; i++)
	  {
	  	if(reisekortene[i].getKortNr() == nr)
	  	return reisekortene[i];
	  }
	  return null;
    /*< Metoden skal returnere (en referanse/peker til) det reisekortet
      i arrayen som har kortNr lik den innkomne parameteren nr.
      Hvis kortet ikke finnes i arrayen, skal metoden returnere null.>*/
  }

  public void utvidArray()
  {
	  Reisekort[] kort = new Reisekort[reisekortene.length + UTVIDELSE];

	  for(int i = 0; i < reisekortene.length; i++)
	  	kort[i] = reisekortene[i];
	  reisekortene = kort;
    /*< Metoden skal utvide arrayen med så mange elementer som konstanten
      UTVIDELSE angir. Metoden vil bli kalt når det er behov for å utvide
      arrayen i forbindelse med innsetting av et nytt reisekort. >*/
  }

  public void settInnReisekort(Reisekort k)
  {
	  if( finnReisekort(k.getKortNr()) == null)

	  for(int i = 0; i < reisekortene.length; i++)
	  {
	  	if(reisekortene[i] == null)
	  	{
	  		reisekortene[i] = k;
	  		return;
		}
		if(i == reisekortene.length - 1)
			utvidArray();
	  }
    /*< Metoden mottar et nytt reisekort som parameter og skal sette dette
      inn på første ledige plass i arrayen, under forutsetning av at det
      ikke finnes et reisekort med samme nr i arrayen fra før.
      Hvis arrayen er full, skal den først utvides med så mange
      elementer som konstanten UTVIDELSE angir, og deretter skal kortet
      settes inn. >*/
  }

  public Klippekort ladOppKlippekort( int nr, int beløp )
  {
	Reisekort kort;
	kort = finnReisekort(nr);

	if(kort instanceof Klippekort)
	{
	  		((Klippekort)kort).ladOpp(beløp);
	  		return ((Klippekort)kort);
	}
	  	return null;
    /*< Hvis det finnes et klippekort med kortNr lik den innkomne parameteren nr,
      skal metoden øke saldoen på dette kortet med så mye som parameteren
      beløp angir, og deretter returnere (en referanse/peker til) klippekortet.
      Hvis det ikke finnes et slikt klippekort, skal metoden returnere null. >*/
  }
  public static String inntjeningsInfo()
  {
	  String utskrift = "";
	  int sumTotal = Klippekort.getSumAlleKlippekort() + Dagskort.getSumAlleDagskort() + Månedskort.getSumAlleMånedskort();
	  utskrift += "Det er solgt kort for kr. " + sumTotal + ".-/n";
	  utskrift += "Av disse er det solgt/n";
	  utskrift += Klippekort.getAntallSolgte() + " klippekort for tilsammen kr. " + Klippekort.getSumAlleKlippekort() + ".-/n";
      utskrift += Dagskort.getAntallSolgte() + " dagskort for tilsammen kr. " + Dagskort.getSumAlleDagskort() + ".-/n";
   	  utskrift += Månedskort.getAntallSolgte() + " klippekort for tilsammen kr. " + Månedskort.getSumAlleMånedskort() + ".-/n";
   	  return utskrift;

   /*< Metoden skal returnere en tekst som inneholder informasjon om hvor mange
      reisekort det er solgt av de forskjellige typene, hvor mye som er tjent inn
      på hver type, og hvor mye som er tjent inn totalt. >*/
  }
}  // end of class ReisekortSystem

/*
a) Programmer klassens konstruktør og metoden public Reisekort finnReisekort(int nr).

b) Programmer metoden public void utvidArray().

c) Programmer metoden public void settInnReisekort(Reisekort k).

d) Programmer metoden public Klippekort ladOppKlippekort( int nr, int beløp ).

e) Programmer metoden public static String inntjeningsInfo().*/