package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import auxiliar.Dut;
import net.sf.jasperreports.engine.JRException;
import relatorio.Relatorio;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;
	private JTextField txtComprador;
	private JTextField txtRg;
	private JTextField txtCpf;
	private JTextField txtEndereco;
	private JTextField txtLocalData;
	
	private List<Dut> lista = new ArrayList<Dut>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceUsuario frame = new InterfaceUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfaceUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 369, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblValor = new JLabel("Valor R$:");
		lblValor.setBounds(208, 14, 46, 14);
		contentPane.add(lblValor);
		
		txtValor = new JTextField();
		txtValor.setBounds(253, 11, 86, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		txtComprador = new JTextField();
		txtComprador.setBounds(10, 50, 329, 20);
		contentPane.add(txtComprador);
		txtComprador.setColumns(10);
		
		txtRg = new JTextField();
		txtRg.setBounds(10, 81, 86, 20);
		contentPane.add(txtRg);
		txtRg.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(223, 81, 116, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(10, 127, 329, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtLocalData = new JTextField();
		txtLocalData.setBounds(10, 176, 329, 20);
		contentPane.add(txtLocalData);
		txtLocalData.setColumns(10);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Dut dut = new Dut();
				
				dut.setValor(txtValor.getText());
				dut.setNomeComprador(txtComprador.getText());
				dut.setRg(txtRg.getText());
				dut.setCpf(txtCpf.getText());
				dut.setEndereco(txtEndereco.getText());
				dut.setLocalData(txtLocalData.getText());
				
				lista.add(dut);
				
				Relatorio imprime = new Relatorio();
				
				try {
					imprime.geraRelatorio(lista);
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnImprimir.setBounds(250, 219, 89, 23);
		contentPane.add(btnImprimir);
	}
}
