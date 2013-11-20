import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.Event.*;

public class Kontrollvindu implements ActionListener e
{
  private JTextField kortIdFelt;
  private JTextArea display;
  private JButton kontroll;
  private ReisekortSystem kortsystem;

  public Kontrollvindu(ReisekortSystem r)
  {
    //< kaller superklassens konstrukt�r >
	super( "ReisekortSystem" )

    kortsystem = r;

    //< oppretter lytteobjekt og knytter knappen til det. >
    kontroll.addActionListener
    //< setter opp brukergrensesnittet >
  }

  public void kontrollerReisekort()
  {
    /*< Metoden m� lese inn kortets nummer og sjekke om det finnes
      blandt de registrerte kortene. Hvis det finnes og det er gyldig,
      skal f�lgende gj�re:*/

      /*- Hvis det er et klippekort, skal prisen for en reise trekkes fra
      saldoen p� kortet. Deretter skal det skrives ut i tekstomr�de hva
      reisen koster, hva som er saldoen etter at reisen er betalt og hvor
      lenge billetten varer.*/

      /*- Hvis det er et dagskort eller et m�nedskort skal det kun skrives ut
      hvor lenge billetten varer.*/

     /* Hvis kortet er ugyldig, skal dette skrives i tekstomr�det.
      For klippekort skal i tillegg saldoen skrives ut.*/

      //Hvis kortet er ukjent, skal dette skrives i tekstomr�det.>
  }

    //< privat lytteklasse >
    private void addActionListener( this )

}  // end of class Kontrollvindu
