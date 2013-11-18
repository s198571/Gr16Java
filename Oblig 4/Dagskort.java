import java.util.Calendar;

public class Dagskort extends Reisekort
{
	public final static int DAGSPRIS = 75;

	//private datafelt
	private static int sumAlleDagskort = 0;
	private static int antallSolgte = 0;
	private int saldo = 0;

	public Dagskort()
	{
		super(DAGSPRIS);
		antallSolgte++;
		saldo = DAGSPRIS;
		sumAlleDagskort += DAGSPRIS;
	}

	public static int getSumAlleDagskort()
	{
		return sumAlleDagskort;
	}

	public static int getAntallSolgte()
	{
		return antallSolgte;
	}

	public boolean gyldig()// redefinert
	{
		if( super.gyldig())
			return true;
		else if( saldo == DAGSPRIS)
		{

			Calendar dato = Calendar.getInstance();

			dato.add( Calendar.HOUR_OF_DAY, 24 );

			setUtløpstidspunkt(dato);

			saldo -= DAGSPRIS;
			return true;
		}
			else;
			return false;
	}
}  // end of class Dagskort

