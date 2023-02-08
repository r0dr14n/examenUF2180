package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Centro;
import modelo.Departamento;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ButtonGroup;

public class DialogoAnadirDepartamento extends JDialog {
	private JTextField txtCodCentro;
	private Controlador controlador;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField txtDpto;
	private JTextField txtCentro;
	private JTextField txtNombre;
	private JRadioButton rdbtnPropiedad;
	private JRadioButton rdbtnFunciones;
	private JSpinner spinner;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			DialogoAnadirDepartamento dialog = new DialogoAnadirDepartamento();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public DialogoAnadirDepartamento() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[434px]", "[33px][][][][][][][]"));
		
			JLabel lblNewLabel = new JLabel("Código Departamento:");
			getContentPane().add(lblNewLabel, "flowx,cell 0 0");
		
		
			JLabel lblNewLabel_1 = new JLabel("Código Centro:");
			getContentPane().add(lblNewLabel_1, "flowx,cell 0 1");
		
		
			JLabel lblNewLabel_2 = new JLabel("Tipo Dirección:");
			getContentPane().add(lblNewLabel_2, "flowx,cell 0 2");
		
		
			JLabel lblNewLabel_3 = new JLabel("Presupuesto:");
			getContentPane().add(lblNewLabel_3, "flowx,cell 0 3");
		
		
			JLabel lblNewLabel_4 = new JLabel("Nombre:");
			getContentPane().add(lblNewLabel_4, "flowx,cell 0 5");
		
		
			
		
		
			JButton cancelButton = new JButton("Cancel");
			getContentPane().add(cancelButton, "cell 0 7,alignx right,aligny center");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			cancelButton.setActionCommand("Cancel");
		
		
			txtDpto = new JTextField();
			getContentPane().add(txtDpto, "cell 0 0");
			txtDpto.setColumns(10);
		
		
			txtCentro = new JTextField();
			getContentPane().add(txtCentro, "cell 0 1");
			txtCentro.setColumns(10);
		
		
			rdbtnPropiedad = new JRadioButton("Propiedad");
			buttonGroup.add(rdbtnPropiedad);
			rdbtnPropiedad.setSelected(true);
			getContentPane().add(rdbtnPropiedad, "cell 0 2");
		
		
			rdbtnFunciones = new JRadioButton("Funciones");
			buttonGroup.add(rdbtnFunciones);
			getContentPane().add(rdbtnFunciones, "cell 0 2");
		
		
		    spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(5, 1, 100, 1));
			getContentPane().add(spinner, "cell 0 3");
		
		
			JLabel lblNewLabel_5 = new JLabel("(en miles de euros)");
			getContentPane().add(lblNewLabel_5, "cell 0 3");
		
		
			txtNombre = new JTextField();
			getContentPane().add(txtNombre, "cell 0 5");
			txtNombre.setColumns(10);
			
			JButton okButton = new JButton("OK");
			getContentPane().add(okButton, "flowx,cell 0 7");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					recogerDatos();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
	
	
	protected void recogerDatos() {
		try {
			int cod_departamento = Integer.parseInt(txtDpto.getText());
			int cod_centro = Integer.parseInt(txtCentro.getText());
			
			String tipo_dir="";
			if (rdbtnPropiedad.isSelected()) {
				tipo_dir="P";
			} else if (rdbtnFunciones.isSelected()) {
				tipo_dir="F";
			}
			
			int presupuesto = (int) spinner.getValue();
			
			int cod_dpto_jefe = 0;
			String nombre = txtNombre.getText();
			
			Departamento departamento = new Departamento(cod_departamento, cod_centro,
					tipo_dir, presupuesto, cod_dpto_jefe, nombre);
			
			controlador.insertaDepartamento(departamento);
			
		} catch (Exception ede) {
			ede.printStackTrace();
		}
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
	}

}
