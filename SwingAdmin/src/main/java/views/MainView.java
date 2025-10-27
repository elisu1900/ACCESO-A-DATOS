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
	private JTextField txtRelease_year;
	private JTextField txtRating;
	private DefaultTableModel model;
	private JTable tblActors;
	private JButton btnFirst;
	private JButton btnBefore;
	private JButton btnAfter;
	private JButton btnLast;
	private JButton btnLimpiar;
	private JButton btnCrear;
	private JScrollPane scrollPane;

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
		panelHeader.setBackground(new Color(128, 128, 255));
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

		btnFirst = new JButton("FIRST\r\n");
		btnFirst.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panelButtons.add(btnFirst);

		btnBefore = new JButton("BEFORE\r\n");
		btnBefore.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panelButtons.add(btnBefore);

		btnAfter = new JButton("AFTER\r\n");
		btnAfter.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panelButtons.add(btnAfter);

		btnLast = new JButton("LAST\r\n");
		btnLast.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panelButtons.add(btnLast);

		JPanel panelData = new JPanel();
		panelData.setBackground(new Color(255, 214, 165));
		panelMain.add(panelData, BorderLayout.CENTER);
		GridBagLayout gbl_panelData = new GridBagLayout();
		gbl_panelData.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panelData.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelData.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelData.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		panelData.setLayout(gbl_panelData);

		JLabel lblId = new JLabel("ID\r\n");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		panelData.add(lblId, gbc_lblId);

		txtId = new JTextField();
		txtId.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.insets = new Insets(0, 0, 5, 5);
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 1;
		panelData.add(txtId, gbc_txtId);
		txtId.setColumns(10);

		JLabel lblTitle = new JLabel("TITULO\r\n");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.EAST;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 2;
		panelData.add(lblTitle, gbc_lblTitle);

		txtTitle = new JTextField();
		txtTitle.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_txtTitle = new GridBagConstraints();
		gbc_txtTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitle.insets = new Insets(0, 0, 5, 5);
		gbc_txtTitle.gridx = 1;
		gbc_txtTitle.gridy = 2;
		panelData.add(txtTitle, gbc_txtTitle);
		txtTitle.setColumns(10);

		JLabel lblRating = new JLabel("CLASIFICACION");
		lblRating.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblRating = new GridBagConstraints();
		gbc_lblRating.anchor = GridBagConstraints.EAST;
		gbc_lblRating.insets = new Insets(0, 0, 5, 5);
		gbc_lblRating.gridx = 2;
		gbc_lblRating.gridy = 2;
		panelData.add(lblRating, gbc_lblRating);

		txtRating = new JTextField();
		txtRating.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_txtRating = new GridBagConstraints();
		gbc_txtRating.insets = new Insets(0, 0, 5, 5);
		gbc_txtRating.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRating.gridx = 3;
		gbc_txtRating.gridy = 2;
		panelData.add(txtRating, gbc_txtRating);
		txtRating.setColumns(10);

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

		JPanel panelTable = new JPanel();
		panelTable.setBackground(new Color(255, 180, 162));
		GridBagConstraints gbc_panelTable = new GridBagConstraints();
		gbc_panelTable.gridwidth = 3;
		gbc_panelTable.gridheight = 6;
		gbc_panelTable.fill = GridBagConstraints.BOTH;
		gbc_panelTable.gridx = 2;
		gbc_panelTable.gridy = 7;
		panelData.add(panelTable, gbc_panelTable);
		panelTable.setLayout(new BorderLayout(0, 0));

		// Crear la tabla PRIMERO
		String[] columnNames = { "Id", "First Name", "Last Name" };
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
		scrollPane = new JScrollPane(tblActors);
		panelTable.add(scrollPane, BorderLayout.CENTER);

		btnLimpiar = new JButton("LIMPIAR\r\n");
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.insets = new Insets(0, 0, 5, 5);
		gbc_btnLimpiar.gridx = 0;
		gbc_btnLimpiar.gridy = 11;
		panelData.add(btnLimpiar, gbc_btnLimpiar);

		btnCrear = new JButton("CREAR");
		btnCrear.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnCrear = new GridBagConstraints();
		gbc_btnCrear.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrear.gridx = 1;
		gbc_btnCrear.gridy = 11;
		panelData.add(btnCrear, gbc_btnCrear);

	}

	public JTextField getTxtId() {
		return txtId;
	}

	public JTextField getTxtTitle() {
		return txtTitle;
	}

	public JTextField getTxtRelease_year() {
		return txtRelease_year;
	}

	public JTextField getTxtRating() {
		return txtRating;
	}

	public JButton getBtnFirst() {
		return btnFirst;
	}

	public JButton getBtnBefore() {
		return btnBefore;
	}

	public JButton getBtnAfter() {
		return btnAfter;
	}

	public JButton getBtnLast() {
		return btnLast;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public JButton getBtnCrear() {
		return btnCrear;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public DefaultTableModel getModel() {
		return model;
	}
}