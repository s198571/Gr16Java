/*	Hallbjørn Srorruste, studentnr: s165519 , HINGDATA131AA
		Thomas Newman, studentnr: s198753, HINGDATA131AA
		Adrian Westlund, studentnr: s198571, INFORMATIK13H1IA

*/

import java.util.Calendar;
import java.text.DateFormat;

public abstract class Reisekort
{
  private Calendar utløpstidspunkt; // Blir tildelt verdi når kortet valideres
	private int kortNr;
	private int pris;
	private static int nyttNr = 1;

	public Reisekort(int p)
	{
		pris = p;
		kortNr = nyttNr++;
	}

	public void setUtløpstidspunkt(Calendar t)
	{
		utløpstidspunkt = t;
	}

	public int getKortNr()
	{
		return kortNr;
	}

	public int getPris()
	{
		return pris;
	}

	public Calendar getUtløpstidspunkt()
	{
		return utløpstidspunkt;
	}

  public String gyldigTil()
  {
     if ( utløpstidspunkt == null )
       return null;

     DateFormat tf = DateFormat.getDateTimeInstance
                  ( DateFormat.LONG, DateFormat.MEDIUM );

     return tf.format(utløpstidspunkt.getTime());
  }

  public boolean gyldig() // Metoden vil  bli redefinert av subklassene
  {
     Calendar nå = Calendar.getInstance();
     return nå.before( utløpstidspunkt );
  }
}  // end of class Reisekort