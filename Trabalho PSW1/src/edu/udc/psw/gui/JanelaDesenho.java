package edu.udc.psw.gui;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import edu.udc.psw.modelo.Circulo;
import edu.udc.psw.modelo.Linha;
import edu.udc.psw.modelo.Retangulo;
import edu.udc.psw.modelo.Triangulo;
import edu.udc.psw.modelo.Ponto2D;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.awt.event.ActionEvent;

public class JanelaDesenho extends JFrame {
	private static final long serialVersionUID = 1L;
	private PainelDesenho contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaDesenho frame = new JanelaDesenho();
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
	public JanelaDesenho() {
		setTitle("Janela de desenho");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new PainelDesenho();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFiguras = new JMenu("Figuras");
		menuBar.add(mnFiguras);
		
		JMenuItem mntmPonto = new JMenuItem("Ponto");
		mntmPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ponto2D ponto = new Ponto2D();
				
				contentPane.setFormaGeometrica(ponto);
			}
		});
		mnFiguras.add(mntmPonto);
		
		JMenuItem mntmLinha = new JMenuItem("Linha");
		mntmLinha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Linha linha = new Linha();
				
				contentPane.setFormaGeometrica(linha);
			}
		});
		mnFiguras.add(mntmLinha);
		
		JMenuItem mntmRetangulo = new JMenuItem("Retangulo");
		mntmRetangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Retangulo retangulo = new Retangulo();
				contentPane.setFormaGeometrica(retangulo);
			}
		});
		mnFiguras.add(mntmRetangulo);
		
		JMenuItem mntmCirculo = new JMenuItem("Circulo");
		mntmRetangulo.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Circulo circulo = new Circulo();
			contentPane.setFormaGeometrica(circulo);
		}
	});
		mnFiguras.add(mntmCirculo);
		
		JMenuItem mntmTriangulo = new JMenuItem("Triangulo");
		mntmTriangulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Triangulo triangulo = new Triangulo();
				contentPane.setFormaGeometrica(triangulo);
			}});
		mnFiguras.add(mntmTriangulo);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmSalvar = new JMenuItem("Salvar");
		mntmAbrir.addActionListener(new ActionListener() {
		
			@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser f = new JFileChooser();
			f.setFileSectionMode(FILES_ONLY);
			int res = f.showSaveDialog(null);
			if(res==JFileChooser.CANCEL_OPTION)
				return;
			
			File f = fc.getSelectedFile();
			
			if (!f.exists()) {
                f.createNewFile();
            }
			
			// Prepara para escrever no arquivo
            FileWriter f = new FileWriter(f.getAbsoluteFile());
            BufferedWriter f = new BufferedWriter(f);
            
            // Escreve e fecha arquivo
            bw.write(content);
            bw.close();
	}});
		mnArquivo.add(mntmSalvar);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir ");
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser f = new JFileChooser();
			f.setFileSectionMode(FILES_ONLY);
			int res = f.OpenSaveDialog(null);
			if(res==JFileChooser.CANCEL_OPTION)
				return;
			
		File f = fc.getSelectedFile();
		
		FileReader ler = new FileReader("Dados");
        BufferedReader reader = new BufferedReader(ler);  
        String linha;
        while( (linha = reader.readLine()) != null ){
            System.out.println(linha);
        }
		mnArquivo.add(mntmAbrir);
		}});	
}
}		
