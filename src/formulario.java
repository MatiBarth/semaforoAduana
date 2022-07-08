/* 
 En una aduana hay una máquina que sortea las personas cuyo equipaje serán revisados.
La persona selecciona la cantidad de bultos (hay dos botones uno que incrementa en uno y
otro que lo fija en cero).
Luego presiona el botón sortear y aparece al lado de este botón una JLabel de color rojo o
azul. (En caso de ser rojo se revisa su equipaje, en caso de ser azul, no se revisa)
Para el sorteo generar un valor aleatorio entre 1 y 3. Si se genera un 1 se revisa, si se genera
un 2 o 3 no se revisa.
Luego de sortear fijar en cero cantidad de bultos.
Disponer un menú con una opción para mostrar un dialogo indicando la cantidad de bultos
revisados y no revisados
 */
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class formulario extends JFrame implements ActionListener {
	private JButton subir,cero,sortear;
	private JLabel elegido,color;
	private int bultos,revisados,norevisados;
	private JMenuBar menubar;
	private JMenu menu;
	private JMenuItem menuitem;

	public formulario(){
		
		setLayout(null);
		revisados=0;
		norevisados=0;
		subir=new JButton("ʌ");
		subir.setBounds(70,20,60,40);
		subir.addActionListener(this);
		add(subir);
		cero=new JButton("cero");
		cero.setBounds(70,70,60,40);
		cero.addActionListener(this);
		add(cero);
		sortear=new JButton("Sortear");
		sortear.setBounds(10,120,120,30);
		sortear.addActionListener(this);
		add(sortear);
		
		elegido=new JLabel("0");
		elegido.setBounds(30,50,50,30);
		add(elegido);
		elegido.setFont(new Font("Aria",Font.BOLD,20));
		color=new JLabel("");
		color.setBounds(190,30,120,90);
		add(color);
		
		menubar=new JMenuBar();
		setJMenuBar(menubar);
		menu=new JMenu("Opciones");
		menubar.add(menu);
		menuitem=new JMenuItem("Ver totales");
		menuitem.addActionListener(this);
		menu.add(menuitem);
	}
	
	public void actionPerformed (ActionEvent e){
		bultos=Integer.parseInt(elegido.getText());

		if(e.getSource()==subir){
			bultos++;
		}
		
		if(e.getSource()==cero){
			bultos=0;
			color.setBackground(new Color(238,238,238));
			setTitle("");
		}
		
		elegido.setText(String.valueOf(bultos));
		if (e.getSource()==sortear){
			if (bultos==0){
				setTitle("Seleccionar cantidad de bultos");
			}
			else {
				color.setOpaque(true);
				setTitle("");
				int nrosorteado=1+(int)(Math.random()*3);
				if(nrosorteado==1){
					color.setBackground(new Color(91,178,78));
					norevisados+=bultos;
					setTitle("Pase, no debe controlarse");
				}
				if (nrosorteado==2||nrosorteado==3){
					color.setBackground(new Color(255,0,0));
					revisados+=bultos;
					setTitle("Debe controlarse");
				}
			}
		}
		if(e.getSource()==menuitem){
			dialogo dialog=new dialogo(revisados,norevisados);
			dialog.setBounds(0,0,250,100);
			dialog.setVisible(true);
		}
	}

	
	public static void main(String[]arg){
		formulario frame=new formulario();
		frame.setBounds(0,0,400,250);
		frame.setVisible(true);
	}
}
