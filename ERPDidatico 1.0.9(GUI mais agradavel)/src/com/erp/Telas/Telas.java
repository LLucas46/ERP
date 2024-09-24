package com.erp.Telas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.CardLayout;

import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Telas {

    private JFrame frame;
    private JPasswordField Areadesenha;
    private JTextField Areadeusuario;
    private JPanel panelContainer;
    private CardLayout cardLayout;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField camponomecadastro;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_3;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Telas window = new Telas();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Telas() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 555, 384);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Criando o CardLayout e o painel container
        cardLayout = new CardLayout();
        panelContainer = new JPanel(cardLayout);
        panelContainer.setBounds(0, 0, 539, 345);
        frame.getContentPane().add(panelContainer);
        
        JPanel panelidioma = new JPanel();
        panelidioma.setBackground(Color.LIGHT_GRAY);
        panelContainer.add(panelidioma, "panelidioma");
        panelidioma.setBounds(0, 0, 10, 10);
        panelidioma.setLayout(null);
        ImageIcon icone1 = new ImageIcon("erp/img/Brasil.jpg");
        ImageIcon icone2 = new ImageIcon("");
    
        JLabel labelImagem1 = new JLabel(icone1);
        labelImagem1.setBounds(196, 109, 143, 14); // Posição e tamanho da imagem 1

        JLabel labelImagem2 = new JLabel(icone2);
        labelImagem2.setBounds(196, 109, 143, 14); // Posição e tamanho da imagem 2

        // Adicionando os JLabels (imagens) ao panel
        panelidioma.add(labelImagem1);
        panelidioma.add(labelImagem2);

        // Exibindo a janela
        frame.setVisible(true);
        
        JLabel lblNewLabel_3 = new JLabel("Escolha seu idioma");
        lblNewLabel_3.setFont(new Font("Arial Black", Font.BOLD, 12));
        lblNewLabel_3.setBounds(196, 109, 143, 14);
        panelidioma.add(lblNewLabel_3);
        
        JLabel lblNewLabel_3_1 = new JLabel("Choose Language");
        lblNewLabel_3_1.setFont(new Font("Arial Black", Font.BOLD, 12));
        lblNewLabel_3_1.setBounds(196, 131, 143, 14);
        panelidioma.add(lblNewLabel_3_1);
        
        JLabel lblNewLabel_4 = new JLabel("New label");
        lblNewLabel_4.setBounds(64, 195, 46, 14);
        panelidioma.add(lblNewLabel_4);
        
        
        JPanel panelinicial = new JPanel();
        panelContainer.add(panelinicial,"TelaInicial");
        panelinicial.setBackground(Color.LIGHT_GRAY);
        panelinicial.setLayout(null);
        
        // Painel de Login
        JPanel panelLogin = new JPanel();
        panelLogin.setBackground(Color.LIGHT_GRAY);
        panelLogin.setLayout(null);
        
        Areadeusuario = new JTextField();
        Areadeusuario.setBounds(177, 130, 199, 22);
        panelLogin.add(Areadeusuario);
        Areadeusuario.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Senha");
        lblNewLabel_1.setBounds(177, 163, 46, 14);
        panelLogin.add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("Usuario");
        lblNewLabel.setBounds(177, 89, 46, 30);
        panelLogin.add(lblNewLabel);

        Areadesenha = new JPasswordField();
        Areadesenha.setBounds(177, 188, 199, 23);
        panelLogin.add(Areadesenha);

        JButton Botaologinadmin = new JButton("Entrar como Admin");
        Botaologinadmin.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if(e.getKeyCode() == e.VK_ENTER) {
        			 if (verificalogin(Areadeusuario.getText(), new String(Areadesenha.getPassword()))) {
                         JOptionPane.showMessageDialog(null, "Bem-vindo Administrador", "Login bem sucedido", JOptionPane.PLAIN_MESSAGE);
                         // Mudar para a tela de Admin
                         cardLayout.show(panelContainer, "TelaAdmin");
                     } else {
                         JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos, tente novamente", "Erro", JOptionPane.WARNING_MESSAGE);
                     }
        		};
        	}
        });
        
        Botaologinadmin.setBounds(177, 245, 199, 23);
        panelLogin.add(Botaologinadmin);
        
        JButton Botaovoltar = new JButton("Sair");
        Botaovoltar.setBounds(10, 304, 100, 30);
        panelLogin.add(Botaovoltar);

        // Painel de Admin (nova tela)
        JPanel panelAdmin = new JPanel();
        panelAdmin.setBackground(Color.LIGHT_GRAY);
        panelAdmin.setLayout(null);

        JButton btnSair = new JButton("Sair");
        btnSair.setBounds(10, 304, 100, 30);
        panelAdmin.add(btnSair);

        // Adicionar os painéis ao CardLayout
        
        
        JButton BotaoFuncionario = new JButton("Entrar como funcionario");
        BotaoFuncionario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer, "TelaFuncionario");
        	}
        });
        BotaoFuncionario.setBounds(172, 174, 215, 23);
        panelinicial.add(BotaoFuncionario);
        
        JButton IrParaLoginAdmin = new JButton("Entrar como Adminstrador");
        IrParaLoginAdmin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer,"TelaLogin" );
        	}
        });
        IrParaLoginAdmin.setBounds(172, 114, 215, 23);
        panelinicial.add(IrParaLoginAdmin);
        
        JLabel rikomulogo_1 = new JLabel("Rikomu");
        rikomulogo_1.setHorizontalAlignment(SwingConstants.CENTER);
        rikomulogo_1.setForeground(Color.BLACK);
        rikomulogo_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
        rikomulogo_1.setBackground(Color.DARK_GRAY);
        rikomulogo_1.setBounds(158, 25, 245, 54);
        panelinicial.add(rikomulogo_1);
        
        JButton btnajudainicial = new JButton("Ajuda");
        btnajudainicial.setBounds(10, 311, 89, 23);
        panelinicial.add(btnajudainicial);
        panelContainer.add(panelLogin, "TelaLogin");
        
        JLabel rikomulogo = new JLabel("Rikomu");
        rikomulogo.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
        rikomulogo.setBackground(Color.DARK_GRAY);
        rikomulogo.setForeground(new Color(0, 0, 0));
        rikomulogo.setHorizontalAlignment(SwingConstants.CENTER);
        rikomulogo.setBounds(154, 24, 245, 54);
        panelLogin.add(rikomulogo);
        panelContainer.add(panelAdmin, "TelaAdmin");
        
        JButton btnprodutos = new JButton("Produtos");
        btnprodutos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer,"panelprodutos");
        	}
        });
        btnprodutos.setBounds(150, 87, 257, 23);
        panelAdmin.add(btnprodutos);
        
        JButton btnclientes = new JButton("Clientes");
        btnclientes.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer, "panelclientes");
        	}
        });
        btnclientes.setBounds(150, 121, 257, 23);
        panelAdmin.add(btnclientes);
        
        JButton btnatendimento = new JButton("Atendimento");
        btnatendimento.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer, "panelatendimento");
        	}
        });
        btnatendimento.setBounds(150, 155, 257, 23);
        panelAdmin.add(btnatendimento);
        
        JButton btnfinancas = new JButton("Finanças");
        btnfinancas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	cardLayout.show(panelContainer, "panelfinancas");
        	}
        });
        btnfinancas.setBounds(150, 189, 257, 23);
        panelAdmin.add(btnfinancas);
        
        JButton btnajuda = new JButton("Ajuda");
        btnajuda.setBounds(120, 304, 100, 30);
        panelAdmin.add(btnajuda);
        
        JLabel rikomulogo_2 = new JLabel("Rikomu");
        rikomulogo_2.setHorizontalAlignment(SwingConstants.CENTER);
        rikomulogo_2.setForeground(Color.BLACK);
        rikomulogo_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
        rikomulogo_2.setBackground(Color.DARK_GRAY);
        rikomulogo_2.setBounds(131, 11, 302, 54);
        panelAdmin.add(rikomulogo_2);
        
        JPanel TelaFuncionario = new JPanel();
        TelaFuncionario.setBackground(Color.LIGHT_GRAY);
        panelContainer.add(TelaFuncionario, "TelaFuncionario");
        TelaFuncionario.setLayout(null);
        
        JButton btnCadastrarPessoa = new JButton("Cadastrar Cliente");
        btnCadastrarPessoa.setBounds(162, 110, 223, 23);
        TelaFuncionario.add(btnCadastrarPessoa);
        
        JButton btnDeletarPessoa = new JButton("Deletar Pessoa");
        btnDeletarPessoa.setBounds(162, 144, 223, 23);
        TelaFuncionario.add(btnDeletarPessoa);
        
        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer, "TelaInicial");
        	}
        });
        btnVoltar.setBounds(237, 212, 78, 23);
        TelaFuncionario.add(btnVoltar);
        
        JButton btnCompraClienteFinal = new JButton("Compra Cliente Final");
        btnCompraClienteFinal.setBounds(162, 178, 223, 23);
        TelaFuncionario.add(btnCompraClienteFinal);
        
        JButton btnajuda_1 = new JButton("Ajuda");
        btnajuda_1.setBounds(429, 304, 100, 30);
        TelaFuncionario.add(btnajuda_1);
        
        JLabel rikomulogo_2_1 = new JLabel("Rikomu");
        rikomulogo_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        rikomulogo_2_1.setForeground(Color.BLACK);
        rikomulogo_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
        rikomulogo_2_1.setBackground(Color.DARK_GRAY);
        rikomulogo_2_1.setBounds(125, 28, 302, 54);
        TelaFuncionario.add(rikomulogo_2_1);
        
        JPanel panelprodutos = new JPanel();
        panelprodutos.setBackground(Color.LIGHT_GRAY);
        panelContainer.add(panelprodutos, "panelprodutos");
        panelprodutos.setLayout(null);
        
        JButton btnsairprodutos = new JButton("Sair");
        btnsairprodutos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer, "TelaAdmin" );
        	}
        });
        btnsairprodutos.setBounds(233, 182, 89, 23);
        panelprodutos.add(btnsairprodutos);
        
        JButton btnlistarprodutos = new JButton("Listar produtos");
        btnlistarprodutos.setBounds(106, 148, 347, 23);
        panelprodutos.add(btnlistarprodutos);
        
        JButton btnaddproduto = new JButton("Adicionar produto");
        btnaddproduto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer, "paneladdprodutos");
        	}
        });
        btnaddproduto.setBounds(106, 117, 347, 23);
        panelprodutos.add(btnaddproduto);
        
        JLabel rikomulogo_3 = new JLabel("Rikomu");
        rikomulogo_3.setHorizontalAlignment(SwingConstants.CENTER);
        rikomulogo_3.setForeground(Color.BLACK);
        rikomulogo_3.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
        rikomulogo_3.setBackground(Color.DARK_GRAY);
        rikomulogo_3.setBounds(156, 29, 245, 54);
        panelprodutos.add(rikomulogo_3);
        
        JButton btnajuda_2 = new JButton("Ajuda");
        btnajuda_2.setBounds(429, 304, 100, 30);
        panelprodutos.add(btnajuda_2);
        
        
        JPanel panelclientes = new JPanel();
        panelclientes.setBackground(Color.LIGHT_GRAY);
        panelContainer.add(panelclientes, "panelclientes");
        
        JButton btnsairclientes = new JButton("Sair");
        btnsairclientes.setBounds(223, 218, 89, 23);
        btnsairclientes.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer, "TelaAdmin" );
        	}
        });
        panelclientes.setLayout(null);
        panelclientes.add(btnsairclientes);
        
        JButton btnlistarclientes = new JButton("Listar Clientes");
        btnlistarclientes.setBounds(117, 184, 309, 23);
        panelclientes.add(btnlistarclientes);
        
        JButton btncadastrar = new JButton("Cadastrar Clientes");
        btncadastrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer, "panelcadastro");
        	}
        });
        btncadastrar.setBounds(117, 119, 309, 23);
        panelclientes.add(btncadastrar);
        
        JButton btndeletacliente = new JButton("Deletar clientes");
        btndeletacliente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer, "paneldeletacliente");
        	}
        });
        btndeletacliente.setBounds(117, 150, 309, 23);
        panelclientes.add(btndeletacliente);
        
        JLabel rikomulogo_4 = new JLabel("Rikomu");
        rikomulogo_4.setHorizontalAlignment(SwingConstants.CENTER);
        rikomulogo_4.setForeground(Color.BLACK);
        rikomulogo_4.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
        rikomulogo_4.setBackground(Color.DARK_GRAY);
        rikomulogo_4.setBounds(148, 34, 245, 54);
        panelclientes.add(rikomulogo_4);
        
        JButton btnajuda_3 = new JButton("Ajuda");
        btnajuda_3.setBounds(429, 304, 100, 30);
        panelclientes.add(btnajuda_3);
        
        JPanel panelatendimento = new JPanel();
        panelatendimento.setBackground(Color.LIGHT_GRAY);
        panelContainer.add(panelatendimento, "panelatendimento");
        
        JButton btnsairatendimento = new JButton("Sair");
        btnsairatendimento.setBounds(219, 181, 89, 23);
        btnsairatendimento.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer, "TelaAdmin" );
        	}
        });
        panelatendimento.setLayout(null);
        panelatendimento.add(btnsairatendimento);
        
        JButton btnpagamento = new JButton("Pagamento ");
        btnpagamento.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer, "paneleftpagamento");
        	}
        });
        btnpagamento.setBounds(168, 147, 199, 23);
        panelatendimento.add(btnpagamento);
        
        JButton btncarrinho = new JButton("Carrinho");
        btncarrinho.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer, "panelcarrinho");
        	}
        });
        btncarrinho.setBounds(168, 113, 199, 23);
        panelatendimento.add(btncarrinho);
        
        JButton btnpendente = new JButton("pendente");
        btnpendente.setBounds(168, 79, 199, 23);
        panelatendimento.add(btnpendente);
        
        JLabel rikomulogo_5 = new JLabel("Rikomu");
        rikomulogo_5.setHorizontalAlignment(SwingConstants.CENTER);
        rikomulogo_5.setForeground(Color.BLACK);
        rikomulogo_5.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
        rikomulogo_5.setBackground(Color.DARK_GRAY);
        rikomulogo_5.setBounds(149, 11, 245, 54);
        panelatendimento.add(rikomulogo_5);
        
        JButton btnajuda_4 = new JButton("Ajuda");
        btnajuda_4.setBounds(429, 304, 100, 30);
        panelatendimento.add(btnajuda_4);
        
        JPanel panelfinancas = new JPanel();
        panelfinancas.setBackground(Color.LIGHT_GRAY);
        panelContainer.add(panelfinancas, "panelfinancas");
        
        JButton btnsairfinancas = new JButton("Sair");
        btnsairfinancas.setBounds(220, 168, 89, 23);
        btnsairfinancas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer, "TelaAdmin" );
        	}
        });
        panelfinancas.setLayout(null);
        panelfinancas.add(btnsairfinancas);
        
        JButton btntitulo = new JButton("Pagamento de titulos");
        btntitulo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer, "panelpagatitulofinancas");
        	}
        });
        btntitulo.setBounds(133, 134, 273, 23);
        panelfinancas.add(btntitulo);
        
        JButton btntitutosaberto = new JButton("Titulos em Aberto");
        btntitutosaberto.setBounds(133, 99, 273, 23);
        panelfinancas.add(btntitutosaberto);
        
        JLabel rikomulogo_6 = new JLabel("Rikomu");
        rikomulogo_6.setHorizontalAlignment(SwingConstants.CENTER);
        rikomulogo_6.setForeground(Color.BLACK);
        rikomulogo_6.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
        rikomulogo_6.setBackground(Color.DARK_GRAY);
        rikomulogo_6.setBounds(149, 21, 245, 54);
        panelfinancas.add(rikomulogo_6);
        
        JButton btnajuda_5 = new JButton("Ajuda");
        btnajuda_5.setBounds(429, 304, 100, 30);
        panelfinancas.add(btnajuda_5);
        
        JPanel paneladdprodutos = new JPanel();
        paneladdprodutos.setBackground(Color.LIGHT_GRAY);
        panelContainer.add(paneladdprodutos, "paneladdprodutos");
        paneladdprodutos.setLayout(null);
        
        JButton btnvoltaraddproduto = new JButton("Voltar");
        btnvoltaraddproduto.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        	cardLayout.show(panelContainer, "panelprodutos");
        	
        	}
        });
        btnvoltaraddproduto.setBounds(10, 311, 89, 23);
        paneladdprodutos.add(btnvoltaraddproduto);
        
        JButton btnAddproduto = new JButton("Adicionar");
        btnAddproduto.setBounds(220, 221, 89, 23);
        paneladdprodutos.add(btnAddproduto);
        
        textField = new JTextField();
        textField.setBounds(117, 174, 298, 20);
        paneladdprodutos.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(117, 131, 298, 20);
        paneladdprodutos.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(117, 88, 298, 20);
        paneladdprodutos.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblvalor = new JLabel("Valor");
        lblvalor.setHorizontalAlignment(SwingConstants.RIGHT);
        lblvalor.setBounds(61, 177, 46, 14);
        paneladdprodutos.add(lblvalor);
        
        JLabel lblnome = new JLabel("Nome");
        lblnome.setHorizontalAlignment(SwingConstants.RIGHT);
        lblnome.setBounds(61, 134, 46, 14);
        paneladdprodutos.add(lblnome);
        
        JLabel lblid = new JLabel("ID");
        lblid.setHorizontalAlignment(SwingConstants.RIGHT);
        lblid.setBounds(61, 91, 46, 14);
        paneladdprodutos.add(lblid);
        
        JLabel rikomulogo_2_2 = new JLabel("Rikomu");
        rikomulogo_2_2.setHorizontalAlignment(SwingConstants.CENTER);
        rikomulogo_2_2.setForeground(Color.BLACK);
        rikomulogo_2_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
        rikomulogo_2_2.setBackground(Color.DARK_GRAY);
        rikomulogo_2_2.setBounds(117, 11, 302, 54);
        paneladdprodutos.add(rikomulogo_2_2);
        
        JPanel panelcadastro = new JPanel();
        panelcadastro.setBackground(Color.LIGHT_GRAY);
        panelContainer.add(panelcadastro, "panelcadastro");
        panelcadastro.setLayout(null);
        
        JLabel rikomulogo_4_1 = new JLabel("Rikomu");
        rikomulogo_4_1.setHorizontalAlignment(SwingConstants.CENTER);
        rikomulogo_4_1.setForeground(Color.BLACK);
        rikomulogo_4_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
        rikomulogo_4_1.setBackground(Color.DARK_GRAY);
        rikomulogo_4_1.setBounds(143, 24, 245, 54);
        panelcadastro.add(rikomulogo_4_1);
        
        camponomecadastro = new JTextField();
        camponomecadastro.setBounds(112, 98, 300, 20);
        panelcadastro.add(camponomecadastro);
        camponomecadastro.setColumns(10);
        
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(112, 129, 300, 20);
        panelcadastro.add(textField_4);
        
        textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(112, 160, 300, 20);
        panelcadastro.add(textField_5);
        
        textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(112, 191, 300, 20);
        panelcadastro.add(textField_6);
        
        JLabel lblNome = new JLabel("Nome");
        lblNome.setHorizontalAlignment(SwingConstants.CENTER);
        lblNome.setBounds(56, 101, 46, 14);
        panelcadastro.add(lblNome);
        
        JLabel lblcpf = new JLabel("CPF");
        lblcpf.setHorizontalAlignment(SwingConstants.CENTER);
        lblcpf.setBounds(56, 132, 46, 14);
        panelcadastro.add(lblcpf);
        
        JLabel lbltelefone = new JLabel("Telefone");
        lbltelefone.setHorizontalAlignment(SwingConstants.CENTER);
        lbltelefone.setBounds(56, 163, 46, 14);
        panelcadastro.add(lbltelefone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setHorizontalAlignment(SwingConstants.CENTER);
        lblemail.setBounds(56, 194, 46, 14);
        panelcadastro.add(lblemail);
        
        JButton btncadastro = new JButton("Cadastrar");
        btncadastro.setBounds(220, 222, 89, 23);
        panelcadastro.add(btncadastro);
        
        JButton btnvoltarcadastro = new JButton("Voltar");
        btnvoltarcadastro.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer, "panelclientes");
        	}
        });
        btnvoltarcadastro.setBounds(10, 311, 89, 23);
        panelcadastro.add(btnvoltarcadastro);
        
        JButton btnajudacadastro = new JButton("Ajuda");
        btnajudacadastro.setBounds(112, 311, 89, 23);
        panelcadastro.add(btnajudacadastro);
        
        JPanel paneldeletacliente = new JPanel();
        paneldeletacliente.setBackground(Color.LIGHT_GRAY);
        panelContainer.add(paneldeletacliente, "paneldeletacliente");
        paneldeletacliente.setLayout(null);
        
        textField_3 = new JTextField();
        textField_3.setBounds(211, 135, 131, 20);
        paneldeletacliente.add(textField_3);
        textField_3.setColumns(10);
        
        JButton btndeletar = new JButton("Deletar");
        btndeletar.setBounds(241, 166, 67, 23);
        paneldeletacliente.add(btndeletar);
        
        JButton btnvoltardeleta = new JButton("Voltar");
        btnvoltardeleta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer, "panelclientes");
        	}
        });
        btnvoltardeleta.setBounds(10, 311, 61, 23);
        paneldeletacliente.add(btnvoltardeleta);
        
        JButton btnajudaeleta = new JButton("Ajuda");
        btnajudaeleta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnajudaeleta.setBounds(81, 311, 61, 23);
        paneldeletacliente.add(btnajudaeleta);
        
        JLabel lblcpfdeleta = new JLabel("CPF:");
        lblcpfdeleta.setFont(new Font("Arial Black", Font.BOLD, 12));
        lblcpfdeleta.setForeground(Color.BLACK);
        lblcpfdeleta.setBackground(Color.WHITE);
        lblcpfdeleta.setHorizontalAlignment(SwingConstants.RIGHT);
        lblcpfdeleta.setBounds(169, 135, 32, 18);
        paneldeletacliente.add(lblcpfdeleta);
        
        JLabel rikomulogo_4_2 = new JLabel("Rikomu");
        rikomulogo_4_2.setHorizontalAlignment(SwingConstants.CENTER);
        rikomulogo_4_2.setForeground(Color.BLACK);
        rikomulogo_4_2.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
        rikomulogo_4_2.setBackground(Color.DARK_GRAY);
        rikomulogo_4_2.setBounds(217, 11, 110, 47);
        paneldeletacliente.add(rikomulogo_4_2);
        
        JPanel panelcarrinho = new JPanel();
        panelcarrinho.setBackground(Color.LIGHT_GRAY);
        panelContainer.add(panelcarrinho, "panelcarrinho");
        panelcarrinho.setLayout(null);
        
        JButton btnvoltarcarrinho = new JButton("Voltar");
        btnvoltarcarrinho.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	cardLayout.show(panelContainer, "panelatendimento");
        	}
        });
        btnvoltarcarrinho.setBounds(10, 311, 89, 23);
        panelcarrinho.add(btnvoltarcarrinho);
        
        JButton btnajudacarrinho = new JButton("Ajuda");
        btnajudacarrinho.setBounds(109, 311, 89, 23);
        panelcarrinho.add(btnajudacarrinho);
        
        textField_7 = new JTextField();
        textField_7.setBounds(195, 127, 163, 20);
        panelcarrinho.add(textField_7);
        textField_7.setColumns(10);
        
        JButton btnprocurarcliente = new JButton("Procurar cliente");
        btnprocurarcliente.setBounds(221, 158, 111, 23);
        panelcarrinho.add(btnprocurarcliente);
        
        JLabel labelcpfcarrinho = new JLabel("CPF:");
        labelcpfcarrinho.setHorizontalAlignment(SwingConstants.RIGHT);
        labelcpfcarrinho.setFont(new Font("Arial Black", Font.BOLD, 12));
        labelcpfcarrinho.setBounds(144, 130, 46, 14);
        panelcarrinho.add(labelcpfcarrinho);
        
        JLabel rikomulogo_4_2_1 = new JLabel("Rikomu");
        rikomulogo_4_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        rikomulogo_4_2_1.setForeground(Color.BLACK);
        rikomulogo_4_2_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
        rikomulogo_4_2_1.setBackground(Color.DARK_GRAY);
        rikomulogo_4_2_1.setBounds(220, 11, 110, 47);
        panelcarrinho.add(rikomulogo_4_2_1);
        
        JPanel paneleftpagamento = new JPanel();
        paneleftpagamento.setBackground(Color.LIGHT_GRAY);
        panelContainer.add(paneleftpagamento, "paneleftpagamento");
        paneleftpagamento.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("ID do Titulo");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 12));
        lblNewLabel_2.setBounds(109, 134, 89, 14);
        paneleftpagamento.add(lblNewLabel_2);
        
        textField_8 = new JTextField();
        textField_8.setBounds(208, 131, 131, 20);
        paneleftpagamento.add(textField_8);
        textField_8.setColumns(10);
        
        JButton btnpagartitulo = new JButton("Pagar");
        btnpagartitulo.setBounds(228, 162, 89, 23);
        paneleftpagamento.add(btnpagartitulo);
        
        JButton btnvoltareftpag = new JButton("Voltar");
        btnvoltareftpag.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer, "panelatendimento");
        	}
        });
        btnvoltareftpag.setBounds(10, 311, 89, 23);
        paneleftpagamento.add(btnvoltareftpag);
        
        JButton btnajudaeftpag = new JButton("Ajuda");
        btnajudaeftpag.setBounds(109, 311, 89, 23);
        paneleftpagamento.add(btnajudaeftpag);
        
        JLabel rikomulogo_7 = new JLabel("Rikomu");
        rikomulogo_7.setHorizontalAlignment(SwingConstants.CENTER);
        rikomulogo_7.setForeground(Color.BLACK);
        rikomulogo_7.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
        rikomulogo_7.setBackground(Color.DARK_GRAY);
        rikomulogo_7.setBounds(152, 11, 245, 54);
        paneleftpagamento.add(rikomulogo_7);
        
        JPanel panelpagatitulofinancas = new JPanel();
        panelpagatitulofinancas.setBackground(Color.LIGHT_GRAY);
        panelContainer.add(panelpagatitulofinancas, "panelpagatitulofinancas");
        panelpagatitulofinancas.setLayout(null);
        
        textField_9 = new JTextField();
        textField_9.setColumns(10);
        textField_9.setBounds(208, 131, 131, 20);
        panelpagatitulofinancas.add(textField_9);
        
        JButton btnpagartitulofinancas = new JButton("Pagar");
        btnpagartitulofinancas.setBounds(228, 162, 89, 23);
        panelpagatitulofinancas.add(btnpagartitulofinancas);
        
        JLabel lblNewLabel_2_1 = new JLabel("ID do Titulo");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_1.setFont(new Font("Arial Black", Font.BOLD, 12));
        lblNewLabel_2_1.setBounds(109, 134, 89, 14);
        panelpagatitulofinancas.add(lblNewLabel_2_1);
        
        JButton btnvoltarepagatitulo = new JButton("Voltar");
        btnvoltarepagatitulo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		cardLayout.show(panelContainer,"panelfinancas");
        	}
        });
        btnvoltarepagatitulo.setBounds(10, 311, 89, 23);
        panelpagatitulofinancas.add(btnvoltarepagatitulo);
        
        JButton btnajudaeftpag_1 = new JButton("Ajuda");
        btnajudaeftpag_1.setBounds(109, 311, 89, 23);
        panelpagatitulofinancas.add(btnajudaeftpag_1);
        
        JLabel rikomulogo_7_1 = new JLabel("Rikomu");
        rikomulogo_7_1.setHorizontalAlignment(SwingConstants.CENTER);
        rikomulogo_7_1.setForeground(Color.BLACK);
        rikomulogo_7_1.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
        rikomulogo_7_1.setBackground(Color.DARK_GRAY);
        rikomulogo_7_1.setBounds(152, 11, 245, 54);
        panelpagatitulofinancas.add(rikomulogo_7_1);
        
        
        

        // Ação do botão de login
        Botaologinadmin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                if (verificalogin(Areadeusuario.getText(), new String(Areadesenha.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Bem-vindo Administrador", "Login bem sucedido", JOptionPane.PLAIN_MESSAGE);
                    // Mudar para a tela de Admin
                    cardLayout.show(panelContainer, "TelaAdmin");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos, tente novamente", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Ação do botão sair (voltar ao login)
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int confirma = JOptionPane.showConfirmDialog(panelContainer, "Voce tem certeza que quer sair da conta de administrador?", null, JOptionPane.YES_NO_OPTION);
            	if (confirma == JOptionPane.YES_NO_OPTION ) {
            		cardLayout.show(panelContainer, "TelaLogin");
            	}else {
            		
            	}
            	
                
            }
        });
     // Ação do botão sair (voltar a tela inicial)
        Botaovoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
           cardLayout.show(panelContainer, "TelaInicial");
            
                
            }
        
            
        });
        //botao produtos
        
    }

    public boolean verificalogin(String usuario, String senha) {
        return usuario.equals("") && senha.equals("");
    }
}
