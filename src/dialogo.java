import javax.swing.JDialog;
import javax.swing.JLabel;

public class dialogo extends JDialog {
	private JLabel revi,revis,norevi,norevis;
		public dialogo(int revisados,int norevisados){
			setModal(false);
			setLayout(null);
			setResizable(false);
			setTitle("Detalle de bultos");
			
			revi=new JLabel("Total de bultos revisados: ");
			revi.setBounds(10,10,200,20);
			add(revi);
			revis=new JLabel(String.valueOf(revisados));
			revis.setBounds(210,10,20,20);
			add(revis);
			
			norevi=new JLabel("Total de bultos no revisados: ");
			norevi.setBounds(10,40,200,20);
			add(norevi);
			norevis=new JLabel(String.valueOf(norevisados));
			norevis.setBounds(210,40,20,20);
			add(norevis);
			
			
		}
}
