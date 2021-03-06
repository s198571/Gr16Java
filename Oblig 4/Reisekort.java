/*	Hallbj�rn Srorruste, studentnr: s165519 , HINGDATA131AA
		Thomas Newman, studentnr: s198753, HINGDATA131AA
		Adrian Westlund, studentnr: s198571, INFORMATIK13H1IA

*/

import java.util.Calendar;
import java.text.DateFormat;

public abstract class Reisekort
{
  private Calendar utl�pstidspunkt; // Blir tildelt verdi n�r kortet valideres
	private int kortNr;
	private int pris;
	private static int nyttNr = 1;

	public Reisekort(int p)
	{
		pris = p;
		kortNr = nyttNr++;
	}

	public void setUtl�pstidspunkt(Calendar t)
	{
		utl�pstidspunkt = t;
	}

	public int getKortNr()
	{
		return kortNr;
	}

	public int getPris()
	{
		return pris;
	}

	public Calendar getUtl�pstidspunkt()
	{
		return utl�pstidspunkt;
	}

  public String gyldigTil()
  {
     if ( utl�pstidspunkt == null )
       return null;

     DateFormat tf = DateFormat.getDateTimeInstance
                  ( DateFormat.LONG, DateFormat.MEDIUM );

     return tf.format(utl�pstidspunkt.getTime());
  }

  public boolean gyldig() // Metoden vil  bli redefinert av subklassene
  {
     Calendar n� = Calendar.getInstance();
     return n�.before( utl�pstidspunkt );
  }
}  // end of class Reisekort