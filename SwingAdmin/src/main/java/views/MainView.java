package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTable;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtTitle;
	private JTextField txtDescription;
	private JTextField txtRelease_year;
	private JTextField txtLanguage_id;
	private JTextField txtOriginal_lenguage_id;
	private JTextField txtRental_rate;
	private JTextField txtLentgth;
	private JTextField txtReplacement_cost;
	private JTextField txtRating;
	private JTextField txtSpecial_features;
	private JTextField txtLast_update;
	private DefaultTableModel model;
	private JTable tblActors;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(900, 600);
		setMinimumSize(new java.awt.Dimension(800, 500));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(255, 255, 255));
		contentPane.add(panelHeader, BorderLayout.NORTH);
		
		JLabel lbltitle = new JLabel("FILM SEARCHER\r\n");
		lbltitle.setFont(new Font("Tahoma", Font.PLAIN, 28));
		panelHeader.add(lbltitle);
		
		JPanel panelMain = new JPanel();
		panelMain.setBackground(new Color(255, 255, 255));
		contentPane.add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(new BorderLayout(0, 0));
		
		JPanel panelButtons = new JPanel();
		panelButtons.setBackground(new Color(168, 218, 220));
		panelMain.add(panelButtons, BorderLayout.NORTH);
		panelButtons.setLayout(new GridLayout(1, 0, 30, 5));
		
		JButton btnFirst = new JButton("FIRST\r\n");
		btnFirst.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panelButtons.add(btnFirst);
		
		JButton btnBefore = new JButton("BEFORE\r\n");
		btnBefore.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panelButtons.add(btnBefore);
		
		JButton btnAfter = new JButton("AFTER\r\n");
		btnAfter.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panelButtons.add(btnAfter);
		
		JButton btnLast = new JButton("LAST\r\n");
		btnLast.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panelButtons.add(btnLast);
		
		JPanel panelData = new JPanel();
		panelData.setBackground(new Color(255, 214, 165));
		panelMain.add(panelData, BorderLayout.CENTER);
		GridBagLayout gbl_panelData = new GridBagLayout();
		gbl_panelData.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panelData.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelData.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelData.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelData.setLayout(gbl_panelData);
		
		JLabel lblId = new JLabel("ID\r\n");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		panelData.add(lblId, gbc_lblId);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.insets = new Insets(0, 0, 5, 5);
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 0;
		panelData.add(txtId, gbc_txtId);
		txtId.setColumns(10);
		
		JLabel lblRating = new JLabel("CLASIFICACION");
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblRating = new GridBagConstraints();
		gbc_lblRating.anchor = GridBagConstraints.EAST;
		gbc_lblRating.insets = new Insets(0, 0, 5, 5);
		gbc_lblRating.gridx = 2;
		gbc_lblRating.gridy = 0;
		panelData.add(lblRating, gbc_lblRating);
		
		txtRating = new JTextField();
		txtRating.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_txtRating = new GridBagConstraints();
		gbc_txtRating.insets = new Insets(0, 0, 5, 0);
		gbc_txtRating.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRating.gridx = 3;
		gbc_txtRating.gridy = 0;
		panelData.add(txtRating, gbc_txtRating);
		txtRating.setColumns(10);
		
		JLabel lblTitle = new JLabel("TITULO\r\n");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.EAST;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 1;
		panelData.add(lblTitle, gbc_lblTitle);
		
		txtTitle = new JTextField();
		txtTitle.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_txtTitle = new GridBagConstraints();
		gbc_txtTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitle.insets = new Insets(0, 0, 5, 5);
		gbc_txtTitle.gridx = 1;
		gbc_txtTitle.gridy = 1;
		panelData.add(txtTitle, gbc_txtTitle);
		txtTitle.setColumns(10);
		
		JLabel lblSpecial_features = new JLabel("CARACTERISTICAS\r\n");
		lblSpecial_features.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblSpecial_features = new GridBagConstraints();
		gbc_lblSpecial_features.anchor = GridBagConstraints.EAST;
		gbc_lblSpecial_features.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpecial_features.gridx = 2;
		gbc_lblSpecial_features.gridy = 1;
		panelData.add(lblSpecial_features, gbc_lblSpecial_features);
		
		txtSpecial_features = new JTextField();
		txtSpecial_features.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_txtSpecial_features = new GridBagConstraints();
		gbc_txtSpecial_features.insets = new Insets(0, 0, 5, 0);
		gbc_txtSpecial_features.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSpecial_features.gridx = 3;
		gbc_txtSpecial_features.gridy = 1;
		panelData.add(txtSpecial_features, gbc_txtSpecial_features);
		txtSpecial_features.setColumns(10);
		
		JLabel lblDescription = new JLabel("DESCRIPCION");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.EAST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 2;
		panelData.add(lblDescription, gbc_lblDescription);
		
		txtDescription = new JTextField();
		txtDescription.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_txtDescription = new GridBagConstraints();
		gbc_txtDescription.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDescription.insets = new Insets(0, 0, 5, 5);
		gbc_txtDescription.gridx = 1;
		gbc_txtDescription.gridy = 2;
		panelData.add(txtDescription, gbc_txtDescription);
		txtDescription.setColumns(10);
		
		JLabel lblLast_update = new JLabel("ULTIMA ACTUALIZACION");
		lblLast_update.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblLast_update = new GridBagConstraints();
		gbc_lblLast_update.anchor = GridBagConstraints.EAST;
		gbc_lblLast_update.insets = new Insets(0, 0, 5, 5);
		gbc_lblLast_update.gridx = 2;
		gbc_lblLast_update.gridy = 2;
		panelData.add(lblLast_update, gbc_lblLast_update);
		
		txtLast_update = new JTextField();
		txtLast_update.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_txtLast_update = new GridBagConstraints();
		gbc_txtLast_update.insets = new Insets(0, 0, 5, 0);
		gbc_txtLast_update.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLast_update.gridx = 3;
		gbc_txtLast_update.gridy = 2;
		panelData.add(txtLast_update, gbc_txtLast_update);
		txtLast_update.setColumns(10);
		
		JLabel lblrelease_year = new JLabel("AÑO DE LANZAMIENTO");
		lblrelease_year.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblrelease_year = new GridBagConstraints();
		gbc_lblrelease_year.anchor = GridBagConstraints.EAST;
		gbc_lblrelease_year.insets = new Insets(0, 0, 5, 5);
		gbc_lblrelease_year.gridx = 0;
		gbc_lblrelease_year.gridy = 3;
		panelData.add(lblrelease_year, gbc_lblrelease_year);
		
		txtRelease_year = new JTextField();
		txtRelease_year.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_txtRelease_year = new GridBagConstraints();
		gbc_txtRelease_year.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRelease_year.insets = new Insets(0, 0, 5, 5);
		gbc_txtRelease_year.gridx = 1;
		gbc_txtRelease_year.gridy = 3;
		panelData.add(txtRelease_year, gbc_txtRelease_year);
		txtRelease_year.setColumns(10);
		
		JLabel lblLanguage_id = new JLabel("ID LENGUAGE\r\n");
		lblLanguage_id.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblLanguage_id = new GridBagConstraints();
		gbc_lblLanguage_id.anchor = GridBagConstraints.EAST;
		gbc_lblLanguage_id.insets = new Insets(0, 0, 5, 5);
		gbc_lblLanguage_id.gridx = 0;
		gbc_lblLanguage_id.gridy = 4;
		panelData.add(lblLanguage_id, gbc_lblLanguage_id);
		
		txtLanguage_id = new JTextField();
		txtLanguage_id.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_txtLanguage_id = new GridBagConstraints();
		gbc_txtLanguage_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLanguage_id.insets = new Insets(0, 0, 5, 5);
		gbc_txtLanguage_id.gridx = 1;
		gbc_txtLanguage_id.gridy = 4;
		panelData.add(txtLanguage_id, gbc_txtLanguage_id);
		txtLanguage_id.setColumns(10);
		
		JLabel lblOriginal_lenguage_id = new JLabel("LENGUAGE ORIGINAL");
		lblOriginal_lenguage_id.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblOriginal_lenguage_id = new GridBagConstraints();
		gbc_lblOriginal_lenguage_id.anchor = GridBagConstraints.EAST;
		gbc_lblOriginal_lenguage_id.insets = new Insets(0, 0, 5, 5);
		gbc_lblOriginal_lenguage_id.gridx = 0;
		gbc_lblOriginal_lenguage_id.gridy = 5;
		panelData.add(lblOriginal_lenguage_id, gbc_lblOriginal_lenguage_id);
		
		txtOriginal_lenguage_id = new JTextField();
		txtOriginal_lenguage_id.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_txtOriginal_lenguage_id = new GridBagConstraints();
		gbc_txtOriginal_lenguage_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOriginal_lenguage_id.insets = new Insets(0, 0, 5, 5);
		gbc_txtOriginal_lenguage_id.gridx = 1;
		gbc_txtOriginal_lenguage_id.gridy = 5;
		panelData.add(txtOriginal_lenguage_id, gbc_txtOriginal_lenguage_id);
		txtOriginal_lenguage_id.setColumns(10);
		
		JLabel lblRental_rate = new JLabel("PRECIO ALQUILER\r\n");
		lblRental_rate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblRental_rate = new GridBagConstraints();
		gbc_lblRental_rate.anchor = GridBagConstraints.EAST;
		gbc_lblRental_rate.insets = new Insets(0, 0, 5, 5);
		gbc_lblRental_rate.gridx = 0;
		gbc_lblRental_rate.gridy = 6;
		panelData.add(lblRental_rate, gbc_lblRental_rate);
		
		txtRental_rate = new JTextField();
		txtRental_rate.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_txtRental_rate = new GridBagConstraints();
		gbc_txtRental_rate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRental_rate.insets = new Insets(0, 0, 5, 5);
		gbc_txtRental_rate.gridx = 1;
		gbc_txtRental_rate.gridy = 6;
		panelData.add(txtRental_rate, gbc_txtRental_rate);
		txtRental_rate.setColumns(10);
		
		JLabel lblLength = new JLabel("DURACION\r\n");
		lblLength.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblLength = new GridBagConstraints();
		gbc_lblLength.anchor = GridBagConstraints.EAST;
		gbc_lblLength.insets = new Insets(0, 0, 5, 5);
		gbc_lblLength.gridx = 0;
		gbc_lblLength.gridy = 7;
		panelData.add(lblLength, gbc_lblLength);
		
		txtLentgth = new JTextField();
		txtLentgth.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_txtLentgth = new GridBagConstraints();
		gbc_txtLentgth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLentgth.insets = new Insets(0, 0, 5, 5);
		gbc_txtLentgth.gridx = 1;
		gbc_txtLentgth.gridy = 7;
		panelData.add(txtLentgth, gbc_txtLentgth);
		txtLentgth.setColumns(10);
		
		JLabel lblReplacement_cost = new JLabel("COSTO DE REMPLAZO");
		lblReplacement_cost.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblReplacement_cost = new GridBagConstraints();
		gbc_lblReplacement_cost.anchor = GridBagConstraints.EAST;
		gbc_lblReplacement_cost.insets = new Insets(0, 0, 5, 5);
		gbc_lblReplacement_cost.gridx = 0;
		gbc_lblReplacement_cost.gridy = 8;
		panelData.add(lblReplacement_cost, gbc_lblReplacement_cost);
		
		txtReplacement_cost = new JTextField();
		txtReplacement_cost.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_txtReplacement_cost = new GridBagConstraints();
		gbc_txtReplacement_cost.insets = new Insets(0, 0, 5, 5);
		gbc_txtReplacement_cost.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtReplacement_cost.gridx = 1;
		gbc_txtReplacement_cost.gridy = 8;
		panelData.add(txtReplacement_cost, gbc_txtReplacement_cost);
		txtReplacement_cost.setColumns(10);
		
		JPanel panelTable = new JPanel();
		panelTable.setBackground(new Color(255, 180, 162));
		GridBagConstraints gbc_panelTable = new GridBagConstraints();
		gbc_panelTable.insets = new Insets(0, 0, 5, 0);
		gbc_panelTable.gridwidth = 3;
		gbc_panelTable.gridheight = 6;
		gbc_panelTable.fill = GridBagConstraints.BOTH;
		gbc_panelTable.gridx = 2;
		gbc_panelTable.gridy = 7;
		panelData.add(panelTable, gbc_panelTable);
		panelTable.setLayout(new BorderLayout(0, 0));
		
		// Crear la tabla PRIMERO
		String[] columnNames = { "Id", "First Name", "Last Name"};
		model = new DefaultTableModel(columnNames, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tblActors = new JTable(model);
		tblActors.setRowHeight(25);
		tblActors.getTableHeader().setBackground(Color.decode("#D4B5E8")); 
		tblActors.getTableHeader().setForeground(Color.WHITE);
		
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		tblActors.setRowSorter(sorter);
		
		// DESPUÉS añadirla al panel
		JScrollPane scrollPane = new JScrollPane(tblActors);
		panelTable.add(scrollPane, BorderLayout.CENTER);
		
	}
}