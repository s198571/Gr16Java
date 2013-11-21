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

	display = new JTextArea(10,30);
	display.setBackground( Color.YELLOW );

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

	setSize( 350, 250 );
	setVisible( true );
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

  }

  public void kontrollerReisekort()
  {
	  String nr = kortIdFelt.getText();
	  String tekst = "";


	  Reisekort kort = kortsystem.finnReisekort(Integer.parseInt(nr));
	  	if( kort != null)
	  	{
			if(kort.gyldig())
			{
				if( kort instanceof Klippekort)
				{
					tekst += "Betalt kr. " + kort.getPris() + ".-\n";
					tekst += "Saldo kr. " + ((Klippekort)kort).getSaldo() + ".-\n";
					tekst += "Gyldig til " + kort.gyldigTil() + ".-\n";
				}

				else
				{
					tekst += "Gyldig til " + kort.gyldigTil() + ".-\n";
				}
			}
			else
			{
				tekst += "Ugyldig Reisekort!\n";
				if( kort instanceof Klippekort )
				tekst += "Saldo kr. " + ((Klippekort)kort).getSaldo() + ".-\n";
			}
		}
		else
		{
			tekst += "Kortet er ukjent!";
		}

		display.append( tekst );






     /* Hvis kortet er ugyldig, skal dette skrives i tekstområdet.
      For klippekort skal i tillegg saldoen skrives ut.*/

      //Hvis kortet er ukjent, skal dette skrives i tekstområdet.>
  }

    //< privat lytteklasse >
    private class Lytter implements ActionListener
    {
		public void actionPerformed( ActionEvent e )
		{
			if( e.getSource() == kontroll)
				kontrollerReisekort();

		}
	}

}  // end of class Kontrollvindu
