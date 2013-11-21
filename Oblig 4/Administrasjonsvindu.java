/*	Hallbjørn Srorruste, studentnr: s165519 , HINGDATA131AA
		Thomas Newman, studentnr: s198753, HINGDATA131AA
		Adrian Westlund, studentnr: s198571, INFORMATIK13H1IA

*/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Administrasjonsvindu extends JFrame implements ActionListener
{
	private JTextArea felt;
	private JButton knapp;

	public Administrasjonsvindu()
	{
		super("ADMINISTRASJON");
		felt = new JTextArea(10,30);
		knapp = new JButton("Salgsinformasjon");
		Container c = getContentPane();

		knapp.addActionListener(this);

		c.setLayout( new FlowLayout() );

		c.add(knapp);
		c.add(felt);

		setSize( 350, 250 );
    setVisible( true );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == knapp)
			felt.setText(ReisekortSystem.inntjeningsInfo());
	}
}