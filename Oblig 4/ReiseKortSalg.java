import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class ReiseKortSalg extends JFrame
{
  private static final int KLIPP = 1, DAG = 2, MÅNED = 3;
  private JTextField kortNrFelt, betalingsFelt, beløpsFelt;
  private JButton klipp, dag, mnd, ladeknapp;
  private JTextArea info;
  private Lytter lytter;
  private ReisekortSystem kortsystem;

  public ReiseKortSalg(ReisekortSystem k)
  {
    super("KORTSALG");
    kortsystem = k;
    lytter =  new Lytter();
    //< oppretter skjermkomponenene >
    kortNrFelt = new JTextField( 5 );
    betalingsFelt = new JTextField( 5 );
    beløpsFelt = new JTextField( 5 );
    klipp= new JButton("Klippekort");
    dag = new JButton("Dagskort");
    mnd = new JButton ("Månedskort");
    ladeknapp = new JButton("Opplading av klippekort");

    info = new JTextArea( 20, 5 );

    klipp.addActionListener(lytter);
    dag.addActionListener(lytter);
    mnd.addActionListener(lytter);
    ladeknapp.addActionListener( lytter );

    //< setter opp brukergrensesnittet. >
    Container c = getContentPane();
    c.setLayout( new FlowLayout() );
    setSize( 25, 15 );
    setVisible( true );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    c.add(info);
    c.add(klipp);
    c.add(dag);
    c.add(mnd);
    c.add( new JLabel("Beløp: "));
    c.add( beløpsFelt);
    c.add( ladeknapp );
    c.add( new JLabel("Reisekortnr: "));
    c.add(kortNrFelt);
    c.add( new JLabel("Betal kr: "));
    c.add( betalingsFelt );

  }

  public void nyttReisekort(int type)
  {
	  Reisekort kort;


	  if( type == 1)
	  	kort = new Klippekort(Integer.parseInt(beløpsFelt.getText() ));


	  if( type == 2)
	  	kort = new Dagskort();

	  if( type == 3)
	  	kort = new Månedskort();

	  kortNrFelt.setText( kort.getKortNr() );
	  betalingsFelt.setText( kort.getPris() );
	  kortsystem.settInnReisekort(kort);


    /*< Metoden skal foreta et salg av et reisekort av typen parameteren type angir.
      (Se konstantene i skissen av klassen over.) Når kortet er opprettet og satt
      inn i datasystemet, skal metoden skrive ut kortets nummer i tekstfeltet
      kortNrFelt og prisen som skal betales i tekstfeltet betalingsFelt. >*/
  }

  public void ladOppKlippekort()
  {
	  int nr = Integer.parseInt( kortNrFelt.getText() );
	  int beløp = Integer.parseInt( beløpsFelt.getText() );



	  Klippekort kort = kortsystem.ladOppKlippekort( nr, beløp );
	  if( kort != null)
	  {
		  JOptionPane.showMessageDialog( null, "Sald: " + kort.getSaldo() );
		  betalingsFelt.setText( beløpsFelt.getText() );
		}

	else
		betalingsFelt.setText("Error!");
    /*< Metoden skal lade opp klippekortet med det beløpet som brukeren skriver
      inn, under forutsetning av at kortnummerer som oppgis tilhører et
      klippekort i datasystemet. I så fall  skal den nye saldoen skrives ut
      i et dialogvindu (JOptionPane.showMessageDialog(..)), og prisen som skal
      betales skrives i betalingsfeltet. Hvis kortnummeret er feil skal det
      skrives "error" i betalingsfeltet. >*/
  }

  //< privat lytteklasse >
  private class Lytter implements ActionListener
      {
  		public void actionPerformed( ActionEvent e )
  		{
  			if( e.getSource() == klipp )
  				nyttReisekort(KLIPP);
  			if ( e.getSource() == dag )
  				nyttReisekort(DAG);
  			if ( e.getSource() == mnd )
  				nyttReisekort(MÅNED);
  			if ( e.getSource() == ladeknapp )
  				ladOppKlippekort();

  		}
  	}


} // end of class Reisekortsalg

