import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class Kontrollvindu extends JFrame
{
  private JTextField kortIdFelt;
  private JTextArea display;
  private JButton kontroll;
  private ReisekortSystem kortsystem;

  public Kontrollvindu(ReisekortSystem r)
  {
    //< kaller superklassens konstruktør >
	super( "Billettkontroll" );

    kortsystem = r;

	kontroll= new JButton("Billett-Kontroll");
	kortIdFelt = new JTextField( 5 );
	kortIdFelt.setBackground( Color.YELLOW );

    //< oppretter lytteobjekt og knytter knappen til det. >

    Lytter lytter = new Lytter();

    kontroll.addActionListener(lytter);

	Container c = getContentPane();



	//< sette opp brukergrensesnittet >
	c.setLayout( new FlowLayout() );

	c.add( new JLabel("Reisekortnr: "));
	c.add(kortIdFelt);
	c.add(kontroll);
	c.add(display);

	setSize( 200, 300 );
	setVisible( true );
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

  }

  public void kontrollerReisekort()
  {
	  String nr = kortIdFelt.getText();
	  String tekst = "";


	  Reisekort kort = finnReisekort(Integer.parseInt(nr));
	  	if( kort != null)
	  	{
			if(kort.gyldig())
			{
				if( kort instanceof Klippekort)
				{
					tekst += "Betalt kr. " + kort.getPris() + ".-\n";
					tekst += "Saldo kr. " + kort.getSaldo() + ".-\n";
					tekst += "Gyldig til " + kort.gyldigtil() + ".-\n";
				}

				else
				{
					tekst += "Gyldig til " + kort.gyldigtil() + ".-\n";
				}
			}
			else
			{
				text += "Ugyldig Reisekort!\n";
				if( kort instanceof Klippekort )
				text += "Saldo kr. " + kort.getSaldo() + ".-\n";
			}
		}
		else
		{
			text += "Kortet er ukjent!";
		}

		display.append( tekst );






     /* Hvis kortet er ugyldig, skal dette skrives i tekstområdet.
      For klippekort skal i tillegg saldoen skrives ut.*/

      //Hvis kortet er ukjent, skal dette skrives i tekstområdet.>
  }

    //< privat lytteklasse >
    private class Lytter implements ActionListener
    {
		public void ActionPerformed( ActionEvent e )
		{
			if( e.getSource() == kontroll)
				kontrollerReisekort();

		}
	}

}  // end of class Kontrollvindu
