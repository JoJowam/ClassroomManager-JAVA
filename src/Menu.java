/*A Classe Menu é responsavel pela interface do usuario, ela reune todos os metodos da classe
* Application e os gerencia de forma a trabalharem juntos para a coleta de dados. Com Menu, posso mostrar
* ao usuario suas informações e carrega-las atraves dos inputs dos mesmos.
* */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Menu extends JFrame {
    private Application _application = new Application();
    public Menu() {
        //Configurações da janela principal
        setTitle("SGSA - Sistema de Gerenciamento de Salas de Aula");
        Color backgroundColor = Color.decode("#1E0027");
        this.getContentPane().setBackground(backgroundColor);
        setSize(1280, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        //Texto da Tela
        JLabel text = new JLabel("<html><div style='text-align: center;'>SISTEMA DE GERENCIAMENTO<br>DE SALAS DE AULA</div></html>");
        text.setBounds(329, 103, 800, 100);
        text.setFont(new Font("Arial", Font.BOLD, 48));
        text.setForeground(Color.decode("#FFFFFF"));
        add(text);

        //Criação de Botões:
        JButton managerButton = new JButton("Entrar");
        managerButton.setBounds(490 , 446, 300 , 80);
        managerButton.setBackground(Color.decode("#FFCBDB"));
        add(managerButton);

        JButton aboutButton = new JButton("Sobre");
        aboutButton.setBounds(490 , 585, 300 , 80);
        aboutButton.setBackground(Color.decode("#FFCBDB"));
        add(aboutButton);

        //Implementando a Ação dos Botões:
        managerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Faz com que a tela anterior suma e chama a proxima tela.
                setVisible(false);
                new MainMenu().setVisible(true);
            }
        });
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new About().setVisible(true);
            }
        });
    }

    class About extends JFrame {
        public About() {
            //Configurações da janela Sobre
            setTitle("SGSA - Sistema de Gerenciamento de Salas de Aula");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>SISTEMA DE GERENCIAMENTO<br>DE SALAS DE AULA</div></html>");
            text.setBounds(329, 103, 800, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            add(text);

            String aboutText = "<html><div style='text-align: center;'>SISTEMA DE GERENCIAMENTO<br>DE SALAS DE AULA</div><br>" +
                    "<div style='text-align: justify; margin: 20px;'>" +
                    "Este projeto tem como objetivo criar um ambiente virtual para cadastro e gerenciamento de Salas, Cursos, Alunos e Professores, que são adicionados ao sistema através da entidade gestora. " +
                    "Com uma interface intuitiva e amigável, o usuário pode realizar tarefas como cadastro, busca, atualização e remoção de informações, além de visualizar detalhes e gerar relatórios sobre as entidades cadastradas. " +
                    "Tanto alunos quanto professores podem utilizar o sistema para buscar informações relacionadas a suas aulas.</div>" +
                    "<div style='text-align: right; margin-right: 20px;'>Desenvolvido por @Josue Vila Real, 2023.</div></html>";
            JLabel about = new JLabel(aboutText);
            about.setBounds(109, 306, 1062, 280);
            about.setForeground(Color.decode("#FFFFFF"));
            about.setFont(new Font("Arial", Font.BOLD, 16));
            add(about);

            //Criando o botão de Voltar.
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(490 , 585, 300 , 80);
            goBackButton.setBackground(Color.decode("#FFCBDB"));
            add(goBackButton);

            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new MainMenu().setVisible(true);
                }
            });
        }
    }
    class MainMenu extends JFrame{
        public MainMenu(){
            //Configurações da janela principal
            setTitle("SGSA - Sistema de Gerenciamento de Salas de Aula");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLayout(null);
            setResizable(false);

            //Texto da Tela
            JLabel text = new JLabel("<html><div style='text-align: center;'>SISTEMA DE GERENCIAMENTO<br>DE SALAS DE AULA</div></html>");
            text.setBounds(329, 103, 800, 100);
            text.setForeground(Color.decode("#FFFFFF"));
            text.setFont(new Font("Arial", Font.BOLD, 48));
            add(text);

            //Criando os botões com as opções pertinentes.
            JButton professorButton = new JButton("Professor");
            professorButton.setBounds(490 , 307, 300 , 80);
            professorButton.setBackground(Color.decode("#FFCBDB"));
            JButton managerButton = new JButton("Gestor");
            managerButton.setBounds(490 , 446, 300 , 80);
            managerButton.setBackground(Color.decode("#FFCBDB"));
            JButton studentButton = new JButton("Aluno");
            studentButton.setBounds(490 , 585, 300 , 80);
            studentButton.setBackground(Color.decode("#FFCBDB"));

            add(professorButton);
            add(managerButton);
            add(studentButton);

            // Manipulador de eventos para o botão Professor
            professorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Abre a tela do Professor
                    setVisible(false);
                    new ProfessorFrame().setVisible(true);
                }
            });

            //Manipulador de eventos para o botão Gestor
            managerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Abre a tela do Gestor
                    setVisible(false);
                    new ManagerFrame().setVisible(true);
                }
            });

            //Manipulador de eventos para o botão Aluno
            studentButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Abre a tela do Aluno
                    setVisible(false);
                    new AlunoFrame().setVisible(true);
                }
            });
        }
    }

    class ProfessorFrame extends JFrame{
        public ProfessorFrame() {
            //Configurações da janela do Professor.
            setTitle("SGSA - Tela do Professor");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            // exto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>MENU DE PROFESSORES</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setForeground(Color.decode("#FFFFFF"));
            text.setFont(new Font("Arial", Font.BOLD, 48));
            add(text);

            //Botões da tela do Professor.
            JButton infoButton = new JButton("Informações");
            infoButton.setBounds(490 , 321, 300 , 80);
            infoButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar à Tela Principal");
            goBackButton.setBounds(490 , 465, 300 , 80);
            goBackButton.setBackground(Color.decode("#FFCBDB"));
            add(infoButton);
            add(goBackButton);

            //Manipulador de eventos para o botão Informações.
            infoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Abre a tela de informações do Professor.
                    setVisible(false);
                    new ProfessorInfoFrame().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Voltar à Tela Principal.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new MainMenu().setVisible(true);
                }
            });
        }
    }
    class ProfessorInfoFrame extends JFrame{
        private JTable table;
        public ProfessorInfoFrame(){
            //Configurações da janela de informações do Professor.
            setTitle("SGSA - Informações");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Cria a tabela
            String[] columnNames = {"Nome", "ID", "Sala","Professor"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            table = new JTable(model);
            table.setBounds(20, 20, 1240, 600);
            table.setBackground(Color.decode("#FFFFFF"));
            add(table);

            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(561, 646, 225, 78);
            goBackButton.setBackground(Color.decode("#FFCBDB"));
            add(goBackButton);

            Object[] row1 = {"Nome", "ID", "Sala","Professor"};
            model.addRow(row1);
            // Adiciona as linhas à tabela
            for (Course course : _application.getCourses()) {
                Object[] row = {course.getName(), course.getId(), course.getClassroom(), course.getProfessor() == null ? "Sem Professor" : course.getProfessor().getName()};
                model.addRow(row);
            }

            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new MainMenu().setVisible(true);
                }
            });
        }
    }

    class AlunoFrame extends JFrame {
        public AlunoFrame() {
            //Configurações da janela do Aluno
            setTitle("SGSA - Tela do Aluno");
            setSize(1280, 800);
            setLayout(null);
            setResizable(false);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>MENU DE ALUNOS</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //Botões da tela do Aluno
            JButton infoButton = new JButton("Informações");
            infoButton.setBounds(490 , 321, 300 , 80);
            infoButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar à Tela Principal");
            goBackButton.setBounds(490 , 465, 300 , 80);
            goBackButton.setBackground(Color.decode("#FFCBDB"));
            add(infoButton);
            add(goBackButton);

            //Manipulador de eventos para o botão Informações.
            infoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Abre a tela de informações do Aluno.
                    setVisible(false);
                    new AlunoInfoFrame().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Voltar à Tela Principal.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new MainMenu().setVisible(true);
                }
            });
        }
    }
    class AlunoInfoFrame extends JFrame {

        private JTable table;

        public AlunoInfoFrame() {
            //Configurações da janela de informações do Aluno.
            setTitle("SGSA - Informações");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);


            //Cria a tabela
            String[] columnNames = {"Nome", "ID", "Professor", "Alunos matriculados"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            table = new JTable(model);
            table.setBounds(20, 20, 1240, 600);
            table.setBackground(Color.decode("#FFFFFF"));
            add(table);

            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(561, 646, 225, 78);
            goBackButton.setBackground(Color.decode("#FFCBDB"));
            add(goBackButton);

            Object[] row1 = {"Nome", "ID", "Professor", "Alunos matriculados"};
            model.addRow(row1);
            //Adiciona as linhas à tabela
            for (Course course : _application.getCourses()) {
                Object[] row = {course.getName(), course.getId(), course.getProfessor() == null ? "" : course.getProfessor().getName(), getStudentsNames(course.getStudents())};
                model.addRow(row);
            }

            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new MainMenu().setVisible(true);
                }
            });
        }

        private String getStudentsNames(List<Student> students) {
            // Retorna uma string com os nomes dos alunos separados por ponto e vírgula.
            StringBuilder sb = new StringBuilder();
            for (Student student : students) {
                sb.append(student.getName()).append("; ");
            }
            return sb.toString();
        }
    }


    class ManagerFrame extends JFrame{
        public ManagerFrame(){
            //Configurações da janela do Gestor.
            List<Manager> managers = new ArrayList<>();
            Manager _manager = new Manager("Gestor Geral", "999.999.999-99", "31 99999999", "admin", "admin");
            managers.add(_manager);

            setTitle("SGSA - Tela do Aluno");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>LOGIN:</div></html>S");
            text.setBounds(583, 172, 145, 60);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //Campos de Login e Senha
            JLabel userLabel = new JLabel("Usuário:");
            userLabel.setBounds(500, 351, 94, 24);
            userLabel.setFont(new Font("Arial", Font.BOLD, 22));
            userLabel.setForeground(Color.decode("#FFFFFF"));
            add(userLabel);

            JTextField userText = new JTextField();
            userText.setBounds(598, 351, 225, 20);
            add(userText);

            JLabel passwordLabel = new JLabel("Senha:");
            passwordLabel.setBounds(512, 403, 72, 24);
            passwordLabel.setFont(new Font("Arial", Font.BOLD, 22));
            passwordLabel.setForeground(Color.decode("#FFFFFF"));
            add(passwordLabel);

            JPasswordField passwordText = new JPasswordField();
            passwordText.setBounds(598, 402, 225, 20);
            add(passwordText);


            //Botões da tela do gestor
            JButton logInButton = new JButton("Entrar");
            logInButton.setBounds(673 , 465, 151 , 40);
            logInButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(497 , 465, 151 , 40);
            goBackButton.setBackground(Color.decode("#FFCBDB"));
            add(logInButton);
            add(goBackButton);

            // Manipulador de eventos para o botão Entrar.
            logInButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Pegando o nome de usuário e senha digitados nos campos de texto e senha.
                    String username = userText.getText();
                    String password = new String(passwordText.getPassword());

                    //Verifique se o nome de usuário e a senha são válidos.
                    if (_manager.tryLogin(managers, username, password)) {
                        // Abre a tela do Gestor
                        setVisible(false);
                        new ManagerOptionsFrame().setVisible(true);
                    } else {
                        // Exibe uma mensagem de erro.
                        JOptionPane.showMessageDialog(ManagerFrame.this,
                                "Usuário ou senha inválidos!",
                                "Login",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            // Manipulador de eventos para o botão Voltar à Tela Principal.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new MainMenu().setVisible(true);
                }
            });
        }
    }
    class ManagerOptionsFrame extends JFrame{
        public ManagerOptionsFrame(){
            //Configurações da janela do Gestor.
            setTitle("SGSA - Tela do Gestor");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>MENU DE GESTORES</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //Botões da tela do gestor
            JButton studentManagerButton = new JButton("Gerenciar Aluno");
            studentManagerButton.setBounds(287 , 372, 225 , 78);
            studentManagerButton.setBackground(Color.decode("#FFCBDB"));
            JButton professorManagerButton = new JButton("Gerenciar Professor");
            professorManagerButton.setBounds(561 , 372, 225 , 78);
            professorManagerButton.setBackground(Color.decode("#FFCBDB"));
            JButton courseManagerButton = new JButton("Gerenciar Curso");
            courseManagerButton.setBounds(835 , 372, 225 , 78);
            courseManagerButton.setBackground(Color.decode("#FFCBDB"));
            JButton roomManagerButton = new JButton("Cadastrar Sala");
            roomManagerButton.setBounds(287 , 508, 225 , 78);
            roomManagerButton.setBackground(Color.decode("#FFCBDB"));
            JButton reportManagerButton = new JButton("Gerar Relatório");
            reportManagerButton.setBounds(561 , 508, 225, 78);
            reportManagerButton.setBackground(Color.decode("#FFCBDB"));
            JButton fileManagerButton = new JButton("Carregar Arquivo");
            fileManagerButton.setBounds(834, 508, 225, 78);
            fileManagerButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(561 , 646, 225, 78);
            goBackButton.setBackground(Color.decode("#FFCBDB"));

            add(studentManagerButton);
            add(professorManagerButton);
            add(courseManagerButton);
            add(roomManagerButton);
            add(reportManagerButton);
            add(fileManagerButton);
            add(goBackButton);

            //Manipulador de eventos para o botão Gerenciar Aluno.
            studentManagerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Abre a tela de cadastro de aluno;
                    setVisible(false);
                    new ManagerStudent().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Gerenciar Professor.
            professorManagerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Abre a tela de cadastro de professor;
                    setVisible(false);
                    new ManagerProfessor().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Gerenciar Curso.
            courseManagerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Abre a tela de cadastro de curso;
                    setVisible(false);
                    new ManagerCourse().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Cadastrar Sala.
            roomManagerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new ClassroomRegister().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Gerar Relatório.
            reportManagerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Abre a tela de relatório;
                    setVisible(false);
                    new ManagerReport().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Carregar Arquivo.
            fileManagerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Abre a tela de carregamento de arquivo;
                    _application.loadFileReport();
                    JOptionPane.showMessageDialog(ManagerOptionsFrame.this,
                            "Arquivo carregado com sucesso!",
                            "Carregar Arquivo",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            });
            //Manipulador de eventos para o botão Voltar à Tela Principal.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new MainMenu().setVisible(true);
                }
            });
        }
    }

    //Operações com Professor.
    class ManagerProfessor extends JFrame{
        public ManagerProfessor(){
            //Configurações da janela do Professor.
            setTitle("SGSA - Tela do Gestor");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>GESTÃO DE PROFESSORES</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //Botões da tela do Professor
            JButton professorRegister = new JButton("Cadastrar");
            professorRegister.setBounds(373, 333, 225, 78);
            professorRegister.setBackground(Color.decode("#FFCBDB"));
            JButton professorSearchFor = new JButton("Consultar");
            professorSearchFor.setBounds(711, 333, 225, 78);
            professorSearchFor.setBackground(Color.decode("#FFCBDB"));
            JButton professorDelete = new JButton("Excluir");
            professorDelete.setBounds(373, 471, 225, 78);
            professorDelete.setBackground(Color.decode("#FFCBDB"));
            JButton professorUpdate = new JButton("Atualizar");
            professorUpdate.setBounds(711, 471, 225, 78);
            professorUpdate.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(561 , 646, 225, 78);
            goBackButton.setBackground(Color.decode("#FFCBDB"));

            add(professorRegister);
            add(professorSearchFor);
            add(professorDelete);
            add(professorUpdate);
            add(goBackButton);

            //Manipulador de eventos para o botão Cadastrar Professor.
            professorRegister.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Abre a tela de cadastro de Professores;
                    setVisible(false);
                    new ProfessorRegister().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Consultar Professor.
            professorSearchFor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Abre a tela de cadastro de curso;
                    setVisible(false);
                    new ProfessorFinder().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Excluir Professor.
            professorDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Abre a tela de exclusão de Professores.
                    setVisible(false);
                    new ProfessorDelete().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Atualizar Professor.
            professorUpdate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Abre a tela de atualização de Professores.
                    setVisible(false);
                    new ProfessorUpdate().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Voltar à Tela Principal.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new ManagerOptionsFrame().setVisible(true);
                }
            });

        }
    }
    class ProfessorRegister extends JFrame{
        Professor professor;
        Course course;
        public ProfessorRegister(){
            //Configurações da janela do Professor.
            setTitle("SGSA - Cadastro de Professores");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>CADASTRO DE PROFESSORES</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //Nome
            JLabel nameFieldLabel = new JLabel("Nome:");
            nameFieldLabel.setBounds(457, 312, 104, 24);
            nameFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            nameFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(nameFieldLabel);

            JTextField nameFieldText = new JTextField();
            nameFieldText.setBounds(535, 312, 329, 21);
            add(nameFieldText);

            //Telefone
            JLabel telephoneFieldLabel = new JLabel("Telefone:");
            telephoneFieldLabel.setBounds(419, 367, 104, 24);
            telephoneFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            telephoneFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(telephoneFieldLabel);

            JTextField telephoneFieldText = new JTextField();
            telephoneFieldText.setBounds(535, 366, 329, 21);
            add(telephoneFieldText);

            //CPF
            JLabel cpfFieldLabel = new JLabel("CPF:");
            cpfFieldLabel.setBounds(470, 426, 104, 24);
            cpfFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            cpfFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(cpfFieldLabel);

            JTextField cpfTextField = new  JTextField();
            cpfTextField.setBounds(535, 423, 329, 21);
            add(cpfTextField);

            //Botões da tela do gestor
            JButton registerButton = new JButton("Cadastrar");
            registerButton.setBounds(714, 563, 151 , 40);
            registerButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(523 , 563, 151 , 40);
            goBackButton.setBackground(Color.decode("#FFCBDB"));

            add(registerButton);
            add(goBackButton);

            //Manipulador de eventos para o botão Cadastrar.
            registerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtenha o nome de usuário e senha digitados nos campos de texto e senha.
                    String name = nameFieldText.getText();
                    System.out.println(name);
                    String tel = telephoneFieldText.getText();
                    System.out.println(tel);
                    String cpf = cpfTextField.getText();
                    System.out.println(cpf);

                    _application.setProfessors(name, cpf, tel);
                }
            });
            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new ManagerProfessor().setVisible(true);
                }
            });
        }
    }
    class ProfessorFinder extends JFrame{
        Professor professor;
        public ProfessorFinder(){
            //Configurações da janela do Professor
            setVisible(false);
            setTitle("SGSA - Pesquisa de Professores");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>PESQUISA DE PROFESSORES</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //Nome
            JLabel cpfFieldLabel = new JLabel("CPF:");
            cpfFieldLabel.setBounds(457, 312, 104, 24);
            cpfFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            cpfFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(cpfFieldLabel);

            JTextField cpfFieldText = new JTextField();
            cpfFieldText.setBounds(555, 312, 290, 21);
            add(cpfFieldText);

            // Botões da tela do pesquisador de alunos
            JButton searchButton = new JButton("Pesquisar");
            searchButton.setBounds(733, 662, 151 , 40);
            searchButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(418 , 662, 151 , 40);
            goBackButton.setBackground(Color.decode("#FFCBDB"));
            add(searchButton);
            add(goBackButton);

            JTextArea infoTextArea = new JTextArea();
            infoTextArea.setEditable(false);

            JScrollPane infoScrollPane = new JScrollPane(infoTextArea);
            infoScrollPane.setBounds(457, 346, 390, 207);
            add(infoScrollPane, BorderLayout.CENTER);

            //Manipulador de eventos para o pesquisar.
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtenha o nome de usuário e senha digitados nos campos de texto e senha.
                    String cpf = cpfFieldText.getText();
                    System.out.println(cpf);

                    professor = _application.findProfessor(cpf);

                    System.out.println(professor.getName());
                    System.out.println(professor.getTel());
                    System.out.println(professor.getCpf());
                    System.out.println(professor.getCourses());

                    infoTextArea.setText("Nome:\t" + professor.getName() + "\n" +
                            "Telefone:\t" + professor.getTel() + "\n" +
                            "CPF:\t" + professor.getCpf() + "\n");
                            for (Course course : professor.getCourses()) {
                                infoTextArea.append("Curso:\t" + course.getName() + "\n");
                            }
                }
            });
            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new ManagerProfessor().setVisible(true);
                }
            });
        }
    }
    class ProfessorUpdate extends JFrame{
        Professor professor;
        Course course;
        public ProfessorUpdate(){
            //Configurações da janela do Professor
            setTitle("SGSA - Atualização de Professores");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>ATUALIZAÇÃO DE PROFESSORES</div></html>S");
            text.setBounds(390, 123, 500, 150);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //ID
            JLabel cpfFieldLabel = new JLabel("CPF do Professor:");
            cpfFieldLabel.setBounds(423, 312, 200, 25);
            cpfFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            cpfFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(cpfFieldLabel);

            JTextField cpfFieldText = new JTextField();
            cpfFieldText.setBounds(639, 311, 225, 21);
            add(cpfFieldText);

            //Telefone
            JLabel telefoneFieldLabel = new JLabel("Alterar Telefone:");
            telefoneFieldLabel.setBounds(421, 358, 200, 24);
            telefoneFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            telefoneFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(telefoneFieldLabel);

            JTextField telefoneFieldText = new JTextField();
            telefoneFieldText.setBounds(639, 358, 225, 21);
            add(telefoneFieldText);

            JButton telefoneUpdateButton = new JButton("Atualizar Telefone");
            telefoneUpdateButton.setBounds(665, 434, 225, 78);
            telefoneUpdateButton.setBackground(Color.decode("#FFCBDB"));
            JButton addCourseButton = new JButton("Adicionar Curso");
            addCourseButton.setBounds(372, 579, 225, 78);
            addCourseButton.setBackground(Color.decode("#FFCBDB"));
            JButton deleteCourseButton = new JButton("Remover Curso");
            deleteCourseButton.setBounds(665, 579, 225, 78);
            deleteCourseButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(372,434, 225, 78);
            goBackButton.setBackground(Color.decode("#FFCBDB"));
            add(telefoneUpdateButton);
            add(addCourseButton);
            add(deleteCourseButton);
            add(goBackButton);

            //Manipulador de eventos para o botão Atualizar Telefone.
            telefoneUpdateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtenha o nome de usuário e senha digitados nos campos de texto e senha.
                    String cpf = cpfFieldText.getText();
                    String tel = telefoneFieldText.getText();
                    System.out.println(cpf);
                    System.out.println(tel);

                    professor = _application.findProfessor(cpf);
                    _application.updateProfessor(professor, tel);

                }
            });
            //Manipulador de eventos para o botão Adicionar Curso.
            addCourseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new ProfessorCourseAdd().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Remover Curso.
            deleteCourseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new ProfessorCourseRomove().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new ManagerProfessor().setVisible(true);
                }
            });
        }
    }
    class ProfessorCourseRomove extends JFrame{
        Professor professor;
        Course course;
        public ProfessorCourseRomove(){
            //Configurações da janela do Professor
            setVisible(false);
            setTitle("SGSA - Atualização de Professores");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>ATUALIZAR PROFESSORES</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            JLabel professorDeleteFieldLabel = new JLabel("CPF do Professor:");
            professorDeleteFieldLabel.setBounds(439, 353, 225, 24);
            professorDeleteFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            professorDeleteFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(professorDeleteFieldLabel);

            JTextField professorDeleteFieldText = new JTextField();
            professorDeleteFieldText.setBounds(654, 352, 225, 21);
            add(professorDeleteFieldText);


            JLabel courseDeleteFieldLabel = new JLabel("Remover o Curso (ID):");
            courseDeleteFieldLabel.setBounds(426, 400, 225, 24);
            courseDeleteFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            courseDeleteFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(courseDeleteFieldLabel);

            JTextField courseDeleteFieldText = new JTextField();
            courseDeleteFieldText.setBounds(654, 399, 225, 21);
            add(courseDeleteFieldText);

            //Botões da tela do pesquisador de alunos
            JButton removeButton = new JButton("Remover");
            removeButton.setBounds(733, 508, 224 , 78);
            removeButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(404 , 508, 224 , 78);
            goBackButton.setBackground(Color.decode("#FFCBDB"));
            add(removeButton);
            add(goBackButton);

            //Manipulador de eventos para o botão Remover.
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtenha o nome de usuário e senha digitados nos campos de texto e senha.
                    String courseDelete = courseDeleteFieldText.getText();
                    String cpf = professorDeleteFieldText.getText();
                    System.out.println(courseDelete);

                    course = _application.findCourse(courseDelete);
                    professor = _application.findProfessor(cpf);
                    _application.deleteInstanceFromCourse(course, professor);
                }
            });
            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new ProfessorUpdate().setVisible(true);
                }
            });
        }
    }
    class ProfessorCourseAdd extends JFrame{
        Professor professor;
        Course course;
        public ProfessorCourseAdd(){
            //Configurações da janela do Professor
            setVisible(false);
            setTitle("SGSA - Atualização de Professores");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>ATUALIZAR PROFESSORES</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            JLabel professorDeleteFieldLabel = new JLabel("CPF do Professor:");
            professorDeleteFieldLabel.setBounds(439, 353, 225, 24);
            professorDeleteFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            professorDeleteFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(professorDeleteFieldLabel);

            JTextField professorDeleteFieldText = new JTextField();
            professorDeleteFieldText.setBounds(654, 352, 225, 21);
            add(professorDeleteFieldText);

            JLabel courseAddFieldLabel = new JLabel("Adicionar o Curso (ID):");
            courseAddFieldLabel.setBounds(426, 400, 225, 24);
            courseAddFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            courseAddFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(courseAddFieldLabel);

            JTextField courseAddFieldText = new JTextField();
            courseAddFieldText.setBounds(654, 399, 225, 21);
            add(courseAddFieldText);

            //Botões da tela
            JButton addButton = new JButton("Adicionar");
            addButton.setBounds(733, 508, 224 , 78);
            addButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(404 , 508, 224 , 78);
            goBackButton.setBackground(Color.decode("#FFCBDB"));
            add(addButton);
            add(goBackButton);

            //Manipulador de eventos para o botão Adicionar.
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtenha o nome de usuário e senha digitados nos campos de texto e senha.
                    String courseAdd = courseAddFieldText.getText();
                    String cpf = professorDeleteFieldText.getText();
                    System.out.println(courseAddFieldLabel.getText());

                    professor = _application.findProfessor(cpf);
                    course = _application.findCourse(courseAdd);
                    _application.updateProfessor(professor, course);

                }
            });
            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new ProfessorUpdate().setVisible(true);
                }
            });
        }
    }
    class ProfessorDelete extends JFrame{
        Professor professor;
        public ProfessorDelete(){
            //Configurações da janela de Exclusão do Professor
            setTitle("SGSA - Exclusão de Professores");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>EXCLUSÃO DE PROFESSORES</div></html>S");
            text.setBounds(390, 123, 500, 130);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //Nome
            JLabel cpfFieldLabel = new JLabel("CPF:");
            cpfFieldLabel.setBounds(457, 312, 104, 24);
            cpfFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            cpfFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(cpfFieldLabel);

            JTextField cpfFieldText = new JTextField();
            cpfFieldText.setBounds(555, 312, 290, 21);
            add(cpfFieldText);

            //Botões da tela do Professor
            JButton deleteButton = new JButton("Excluir");
            deleteButton.setBounds(733, 662, 151 , 40);
            deleteButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(418 , 662, 151 , 40);
            goBackButton.setBackground(Color.decode("#FFCBDB"));
            add(deleteButton);
            add(goBackButton);

            //Manipulador de eventos para o botão Excluir.
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtenha o nome de usuário e senha digitados nos campos de texto e senha.
                    String cpf = cpfFieldText.getText();
                    System.out.println(cpf);
                    professor = _application.findProfessor(cpf);
                    _application.deleteInstance(professor);
                }
            });
            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new ManagerProfessor().setVisible(true);
                }
            });
        }
    }

    //Cadastro de Salas.
    class ClassroomRegister extends JFrame{
        public ClassroomRegister(){
            // Configurações da janela de Cadastro de Salas.
            setTitle("SGSA - Cadastro de Salas");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>CADASTRO DE SALAS</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //ID
            JLabel idFieldLabel = new JLabel("ID:");
            idFieldLabel.setBounds(457, 312, 104, 24);
            idFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            idFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(idFieldLabel);

            JTextField idFieldText = new JTextField();
            idFieldText.setBounds(535, 312, 329, 21);
            add(idFieldText);

            //Nome
            JLabel capacityFieldLabel = new JLabel("Capacidade:");
            capacityFieldLabel.setBounds(419, 367, 104, 24);
            capacityFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            capacityFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(capacityFieldLabel);

            JTextField capacityFieldText = new JTextField();
            capacityFieldText.setBounds(535, 366, 329, 21);
            add(capacityFieldText);

            JButton registerButton = new JButton("Cadastrar");
            registerButton.setBounds(714, 563, 151 , 40);
            registerButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(523 , 563, 151 , 40);
            goBackButton.setBackground(Color.decode("#FFCBDB"));

            add(registerButton);
            add(goBackButton);

            //Manipulador de eventos para o botão Cadastrar.
            registerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String id = idFieldText.getText();
                    int capacity = Integer.parseInt(capacityFieldText.getText());
                    _application.setClassrooms(id, capacity);
                }
            });
            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new ManagerOptionsFrame().setVisible(true);
                }
            });
        }
    }

    //Operações com Cursos.
    class ManagerCourse extends JFrame{
        public ManagerCourse(){
            //Configurações da janela do Gestor de Cursos.
            setTitle("SGSA - Tela do Gestor");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>GESTÃO DE CURSOS</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //Botões da tela do Curso
            JButton courseRegister = new JButton("Cadastrar");
            courseRegister.setBounds(373, 333, 225, 78);
            courseRegister.setBackground(Color.decode("#FFCBDB"));
            JButton courseSearchFor = new JButton("Consultar");
            courseSearchFor.setBounds(711, 333, 225, 78);
            courseSearchFor.setBackground(Color.decode("#FFCBDB"));
            JButton courseDelete = new JButton("Excluir");
            courseDelete.setBounds(373, 471, 225, 78);
            courseDelete.setBackground(Color.decode("#FFCBDB"));
            JButton courseUpdate = new JButton("Atualizar");
            courseUpdate.setBounds(711, 471, 225, 78);
            courseUpdate.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(561 , 646, 225, 78);
            goBackButton.setBackground(Color.decode("#FFCBDB"));

            add(courseRegister);
            add(courseSearchFor);
            add(courseDelete);
            add(courseUpdate);
            add(goBackButton);

            //Manipulador de eventos para o botão Cadastras
            courseRegister.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Abre a tela de cadastro de curso;
                    setVisible(false);
                    new CourseRegister().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Consultar
            courseSearchFor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Abre a tela de pesquisa de curso;
                    setVisible(false);
                    new CourseSearchFor().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Excluir
            courseDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Abre a tela de exclusão de curso;
                    setVisible(false);
                    new CourseDelete().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Atualizar
            courseUpdate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Abre a tela de atualização de curso;
                    setVisible(false);
                    new CourseUpdate().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Voltar
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new ManagerOptionsFrame().setVisible(true);
                }
            });
        }
    }
    class CourseUpdate extends JFrame{
        Course course;
        Student student;
        Professor professor;
        public CourseUpdate(){
            // Configurações da janela do Gestor de Cursos.
            setTitle("SGSA - Atualização de Cursos");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>ATUALIZAÇÃO DE CURSOS</div></html>S");
            text.setBounds(390, 123, 500, 110);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //ID
            JLabel idFieldLabel = new JLabel("ID:");
            idFieldLabel.setBounds(518, 263, 35, 24);
            idFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            idFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(idFieldLabel);

            JTextField idFieldText = new JTextField();
            idFieldText.setBounds(560, 263, 261, 21);
            add(idFieldText);

            //Telefone
            JLabel nameFieldLabel = new JLabel("Nome:");
            nameFieldLabel.setBounds(442, 331, 104, 24);
            nameFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            nameFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(nameFieldLabel);

            JTextField nameFieldText = new JTextField();
            nameFieldText.setBounds(560, 328, 261, 21);
            add(nameFieldText);

            //Remover Curso
            JLabel professorChangerFieldLabel = new JLabel("Alterar Professor (ID):");
            professorChangerFieldLabel.setBounds(335, 402, 227, 24);
            professorChangerFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            professorChangerFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(professorChangerFieldLabel);

            JTextField professorChangerFieldText = new JTextField();
            professorChangerFieldText.setBounds(560, 402, 261, 21);
            add(professorChangerFieldText);

            //Adicionar Curso
            JLabel studentDeleteFieldLabel = new JLabel("Remover Aluno (ID):");
            studentDeleteFieldLabel.setBounds(319, 475, 227, 24);
            studentDeleteFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            studentDeleteFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(studentDeleteFieldLabel);

            JTextField studentDeleteFieldText = new JTextField();
            studentDeleteFieldText.setBounds(560, 476, 261, 21);
            add(studentDeleteFieldText);

            // Botões da tela do gestor de alunos
            JButton nameUpdateButton = new JButton("Atualizar");
            nameUpdateButton.setBounds(835, 328, 85 , 21);
            nameUpdateButton.setBackground(Color.decode("#FFCBDB"));
            // Botões da tela do gestor de alunos
            JButton professorChangerButton = new JButton("Atualizar");
            professorChangerButton.setBounds(835, 401, 85 , 21);
            professorChangerButton.setBackground(Color.decode("#FFCBDB"));
            // Botões da tela do gestor de alunos
            JButton deleteStudentButton = new JButton("Atualizar");
            deleteStudentButton.setBounds(835, 476, 85 , 21);
            deleteStudentButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(527, 599, 225, 78);
            goBackButton.setBackground(Color.decode("#FFCBDB"));

            add(nameUpdateButton);
            add(professorChangerButton);
            add(deleteStudentButton);
            add(goBackButton);

            //Manipulador de eventos para o botão Atualizar nome.
            nameUpdateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtenha o nome de usuário e senha digitados nos campos de texto e senha.
                    String id = idFieldText.getText();
                    String name = nameFieldText.getText();
                    System.out.println(id);
                    System.out.println(name);

                    course = _application.findCourse(id);
                    _application.updateCourse(course, name);

                }
            });
            //Manipulador de eventos para o botão Atualizar professor.
            professorChangerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String courseId = idFieldText.getText();
                    String professorCpf = professorChangerFieldText.getText();

                    //Encotrar o curso e o professor e atualizar o curso.
                    professor = _application.findProfessor(professorCpf);
                    course = _application.findCourse(courseId);
                    _application.updateCourse(course, professor);
                }
            });
            deleteStudentButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String id = idFieldText.getText();
                    String studentId = studentDeleteFieldText.getText();

                    //Encotrar o curso e o professor e atualizar o curso.
                    course = _application.findCourse(id);
                    student = _application.findStudent(studentId);
                    _application.deleteInstanceFromCourse(course, student);
                }
            });
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new ManagerCourse().setVisible(true);
                }
            });
        }
    }
    class CourseSearchFor extends JFrame{
        Course course;
        public CourseSearchFor(){
            //Configurações da janela do gestor de cursos.
            setVisible(false);
            setTitle("SGSA - Pesquisa de Cursos");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>PESQUISA DE CURSOS</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //Nome
            JLabel idFieldLabel = new JLabel("ID:");
            idFieldLabel.setBounds(457, 312, 104, 24);
            idFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            idFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(idFieldLabel);

            JTextField idFieldText = new JTextField();
            idFieldText.setBounds(555, 312, 290, 21);
            add(idFieldText);

            //Botões da tela do gestor de Cursos.
            JButton searchButton = new JButton("Pesquisar");
            searchButton.setBounds(733, 662, 151 , 40);
            searchButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(418 , 662, 151 , 40);
            goBackButton.setBackground(Color.decode("#FFCBDB"));
            add(searchButton);
            add(goBackButton);

            JTextArea infoTextArea = new JTextArea();
            infoTextArea.setEditable(false);
            JScrollPane infoScrollPane = new JScrollPane(infoTextArea);
            infoScrollPane.setBounds(457, 346, 390, 207);
            add(infoScrollPane, BorderLayout.CENTER);


            //Manipulador de eventos para o botão Pesquisar.
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Obtendo o ID do curso.
                    String id = idFieldText.getText();
                    System.out.println(id);

                    course = _application.findCourse(id);

                    System.out.println(course.getId());
                    System.out.println(course.getName());

                    //Imprimindo as informações do curso.
                    infoTextArea.setText("ID:\t" + course.getId() + "\n" +
                            "Nome:\t" + course.getName() + "\n" +
                            "Dias:\t" + _application.getDaysString(course.getDays()) + "\n" +
                            "Sala:\t" + course.getClassroom().getId() + "\n");
                }

            });
            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new ManagerCourse().setVisible(true);
                }
            });
        }
    }
    class CourseRegister extends JFrame{
        Course course;
        public CourseRegister(){
            // Configurações da janela do gestor de cursos.
            setTitle("SGSA - Cadastro de Cursos");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>CADASTRO DE CURSOS</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //ID
            JLabel idFieldLabel = new JLabel("ID:");
            idFieldLabel.setBounds(457, 312, 104, 24);
            idFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            idFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(idFieldLabel);

            JTextField idFieldText = new JTextField();
            idFieldText.setBounds(535, 312, 329, 21);
            add(idFieldText);

            //Nome
            JLabel nameFieldLabel = new JLabel("Nome:");
            nameFieldLabel.setBounds(419, 367, 104, 24);
            nameFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            nameFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(nameFieldLabel);

            JTextField nameFieldText = new JTextField();
            nameFieldText.setBounds(535, 366, 329, 21);
            add(nameFieldText);

            //dias
            JLabel daysFieldLabel = new JLabel("Dias:");
            daysFieldLabel.setBounds(470, 426, 104, 24);
            daysFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            daysFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(daysFieldLabel);

            JTextField daysTextField = new  JTextField();
            daysTextField.setBounds(535, 423, 329, 21);
            add(daysTextField);

            // Botões da tela do gestor
            JButton registerButton = new JButton("Cadastrar");
            registerButton.setBounds(714, 563, 151 , 40);
            registerButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(523 , 563, 151 , 40);
            goBackButton.setBackground(Color.decode("#FFCBDB"));

            add(registerButton);
            add(goBackButton);

            //Manipulador de eventos para o botão Cadastrar.
            registerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String id = idFieldText.getText();
                    String name = nameFieldText.getText();
                    String daysString = daysTextField.getText();

                    //Converte a string de dias em um array de booleanos.
                    boolean[] days = _application.convertDaysStringToArray(daysString);
                    try {
                        //Cadastra o curso.
                        _application.setCourses(id, name, days);
                    } catch (Exception ex) {
                        System.out.println("Erro ao dar Set no Curso");
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(null, "O Curso: " + name + " foi cadastrado com sucesso!");
                }
            });
            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new ManagerCourse().setVisible(true);
                }
            });
        }
    }
    class CourseDelete extends JFrame{
        Course course;
        public CourseDelete(){
            // Configurações da janela do gestor de cursos.
            setTitle("SGSA - Exclusão de Cursos");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>EXCLUSÃO DE CURSOS</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //Nome
            JLabel idFieldLabel = new JLabel("ID:");
            idFieldLabel.setBounds(457, 312, 104, 24);
            idFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            idFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(idFieldLabel);

            JTextField idFieldText = new JTextField();
            idFieldText.setBounds(555, 312, 290, 21);
            add(idFieldText);

            //Botões da tela do gestor de cursos.
            JButton deleteButton = new JButton("Excluir");
            deleteButton.setBounds(733, 662, 151 , 40);
            deleteButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(418 , 662, 151 , 40);
            goBackButton.setBackground(Color.decode("#FFCBDB"));
            add(deleteButton);
            add(goBackButton);

            //Manipulador de eventos para o botão Excluir.
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtenha o nome de usuário e senha digitados nos campos de texto e senha.
                    String id = idFieldText.getText();
                    System.out.println(id);
                    course = _application.findCourse(id);
                    _application.deleteInstance(course);
                }
            });
            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new ManagerCourse().setVisible(true);
                }
            });
        }
    }

    //Operações com Alunos.
    class ManagerStudent extends JFrame {
        public ManagerStudent() {
            //Configurações da janela do Aluno
            setTitle("SGSA - Tela do Gestor");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>GESTÃO DE ALUNOS</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //Botões da tela do Aluno
            JButton studentRegister = new JButton("Cadastrar");
            studentRegister.setBounds(373, 333, 225, 78);
            studentRegister.setBackground(Color.decode("#FFCBDB"));
            JButton studentSearchFor = new JButton("Consultar");
            studentSearchFor.setBounds(711, 333, 225, 78);
            studentSearchFor.setBackground(Color.decode("#FFCBDB"));
            JButton studentDelete = new JButton("Excluir");
            studentDelete.setBounds(373, 485, 225, 78);
            studentDelete.setBackground(Color.decode("#FFCBDB"));
            JButton studentUpdate = new JButton("Atualizar");
            studentUpdate.setBounds(710, 485, 225, 78);
            studentUpdate.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(548, 637, 225, 78);
            goBackButton.setBackground(Color.decode("#FFCBDB"));

            add(studentRegister);
            add(studentSearchFor);
            add(studentDelete);
            add(studentUpdate);
            add(goBackButton);

            //Manipulador de eventos para o botão Cadastrar.
            studentRegister.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Abre a tela de cadastro de aluno;
                    setVisible(false);
                    new registerStudent().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Consultar.
            studentSearchFor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Abre a tela de cadastro de aluno;
                    setVisible(false);
                    new StudentFinder().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Excluir.
            studentDelete.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new deleteStudent().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Atualizar.
            studentUpdate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //Abre a tela de Atualização de aluno;
                    setVisible(false);
                    new UpdateStudent().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new ManagerOptionsFrame().setVisible(true);
                }
            });
        }
    }
    class deleteStudent extends JFrame{
        Student student;
        public deleteStudent(){
            //Configurações da janela do Aluno
            setTitle("SGSA - Exclusão de Alunos");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>EXCLUSÃO DE ALUNOS</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //Nome
            JLabel nameFieldLabel = new JLabel("Matricula:");
            nameFieldLabel.setBounds(457, 312, 104, 24);
            nameFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            nameFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(nameFieldLabel);

            JTextField nameFieldText = new JTextField();
            nameFieldText.setBounds(555, 312, 290, 21);
            add(nameFieldText);

            //Botões da tela do gestor de alunos
            JButton deleteButton = new JButton("Excluir");
            deleteButton.setBounds(733, 662, 151 , 40);
            deleteButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(418 , 662, 151 , 40);
            goBackButton.setBackground(Color.decode("#FFCBDB"));
            add(deleteButton);
            add(goBackButton);

            //Manipulador de eventos para o botão Excluir.
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtenha o nome de usuário e senha digitados nos campos de texto e senha.
                    String id = nameFieldText.getText();
                    System.out.println(id);
                    student = _application.findStudent(id);
                    _application.deleteInstance(student);
                }
            });
            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new ManagerStudent().setVisible(true);
                }
            });
        }
    }
    class StudentFinder extends JFrame{
        Student student;
        public StudentFinder(){
            // Configurações da janela do Aluno
            setVisible(false);
            setTitle("SGSA - Pesquisa de Alunos");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            // Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>PESQUISA DE ALUNOS</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //Nome
            JLabel idFieldLabel = new JLabel("Matricula:");
            idFieldLabel.setBounds(457, 312, 104, 24);
            idFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            idFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(idFieldLabel);

            JTextField idFieldText = new JTextField();
            idFieldText.setBounds(555, 312, 290, 21);
            add(idFieldText);

            JButton searchButton = new JButton("Pesquisar");
            searchButton.setBounds(733, 662, 151 , 40);
            searchButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(418 , 662, 151 , 40);
            goBackButton.setBackground(Color.decode("#FFCBDB"));
            add(searchButton);
            add(goBackButton);

            JTextArea infoTextArea = new JTextArea();
            infoTextArea.setEditable(false);
            JScrollPane infoScrollPane = new JScrollPane(infoTextArea);
            infoScrollPane.setBounds(457, 346, 390, 207);
            add(infoScrollPane, BorderLayout.CENTER);

            //Manipulador de eventos para o botão Pesquisar.
            searchButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtenha o nome de usuário e senha digitados nos campos de texto e senha.
                    String id = idFieldText.getText();
                    System.out.println(id);

                    student = _application.findStudent(id);

                    System.out.println(student.getName());
                    System.out.println(student.getTel());
                    System.out.println(student.getCpf());
                    System.out.println(student.getId());

                    infoTextArea.setText("Nome:\t" + student.getName() + "\n" +
                            "Telefone:\t" + student.getTel() + "\n" +
                            "CPF:\t" + student.getCpf() + "\n" +
                            "Matricula:\t" + student.getId() + "\n");
                            for (Course course : student.getCourses()) {
                                infoTextArea.append("Curso:\t" + course.getName() + "\n");
                            }
                }
            });
            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new ManagerStudent().setVisible(true);
                }
            });
        }
    }
    class registerStudent extends JFrame{
        Student student;
        public registerStudent(){
            // Configurações da janela do Aluno
            setTitle("SGSA - Cadastro de Alunos");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            // Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>CADASTRO DE ALUNOS</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //Nome
            JLabel nameFieldLabel = new JLabel("Nome:");
            nameFieldLabel.setBounds(457, 312, 104, 24);
            nameFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            nameFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(nameFieldLabel);

            JTextField nameFieldText = new JTextField();
            nameFieldText.setBounds(535, 312, 329, 21);
            add(nameFieldText);

            //Telefone
            JLabel telephoneFieldLabel = new JLabel("Telefone:");
            telephoneFieldLabel.setBounds(419, 367, 104, 24);
            telephoneFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            telephoneFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(telephoneFieldLabel);

            JTextField telephoneFieldText = new JTextField();
            telephoneFieldText.setBounds(535, 366, 329, 21);
            add(telephoneFieldText);

            //CPF
            JLabel cpfFieldLabel = new JLabel("CPF:");
            cpfFieldLabel.setBounds(470, 426, 104, 24);
            cpfFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            cpfFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(cpfFieldLabel);

            JTextField cpfTextField = new  JTextField();
            cpfTextField.setBounds(535, 423, 329, 21);
            add(cpfTextField);

            //Matricula
            JLabel idFieldLabel = new JLabel("Matricula:");
            idFieldLabel.setBounds(430, 475, 119, 24);
            idFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            idFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add( idFieldLabel);

            JTextField idTextField = new JTextField();
            idTextField.setBounds(535, 477, 329, 21);
            add(idTextField);

            // Botões da tela do gestor
            JButton registerButton = new JButton("Cadastrar");
            registerButton.setBounds(714, 563, 151 , 40);
            registerButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(523 , 563, 151 , 40);
            goBackButton.setBackground(Color.decode("#FFCBDB"));

            add(registerButton);
            add(goBackButton);

            //Manipulador de eventos para o botão Cadastrar.
            registerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtenha o nome de usuário e senha digitados nos campos de texto e senha.
                    String name = nameFieldText.getText();
                    System.out.println(name);
                    String tel = telephoneFieldText.getText();
                    System.out.println(tel);
                    String cpf = cpfTextField.getText();
                    System.out.println(cpf);
                    String id = idTextField.getText();
                    System.out.println(id);

                    _application.setStudents(name, cpf, tel, id);

                }
            });
            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new ManagerStudent().setVisible(true);
                }
            });
        }
    }
    class UpdateStudent extends JFrame{
        Student student;
        Course course;
        public UpdateStudent(){
            // Configurações da janela do Aluno
            setTitle("SGSA - Atualização de Alunos");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            // Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>ATUALIZAR ALUNOS</div></html>S");
            text.setBounds(390, 123, 500, 150);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //ID
            JLabel idFieldLabel = new JLabel("ID do Aluno:");
            idFieldLabel.setBounds(423, 312, 200, 25);
            idFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            idFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(idFieldLabel);

            JTextField idFieldText = new JTextField();
            idFieldText.setBounds(639, 311, 225, 21);
            add(idFieldText);

            //Telefone
            JLabel telefoneFieldLabel = new JLabel("Alterar Telefone:");
            telefoneFieldLabel.setBounds(421, 358, 200, 24);
            telefoneFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            telefoneFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(telefoneFieldLabel);

            JTextField telefoneFieldText = new JTextField();
            telefoneFieldText.setBounds(639, 358, 225, 21);
            add(telefoneFieldText);

            JButton telefoneUpdateButton = new JButton("Atualizar Telefone");
            telefoneUpdateButton.setBounds(665, 434, 225, 78);
            telefoneUpdateButton.setBackground(Color.decode("#FFCBDB"));
            JButton addCourseButton = new JButton("Adicionar Curso");
            addCourseButton.setBounds(372, 579, 225, 78);
            addCourseButton.setBackground(Color.decode("#FFCBDB"));
            JButton deleteCourseButton = new JButton("Remover Curso");
            deleteCourseButton.setBounds(665, 579, 225, 78);
            deleteCourseButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(372,434, 225, 78);
            goBackButton.setBackground(Color.decode("#FFCBDB"));
            add(telefoneUpdateButton);
            add(addCourseButton);
            add(deleteCourseButton);
            add(goBackButton);

            //Manipulador de eventos para o botão Atualizar Telefone.
            telefoneUpdateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtenha o nome de usuário e senha digitados nos campos de texto e senha.
                    String id = idFieldText.getText();
                    String tel = telefoneFieldText.getText();


                    student = _application.findStudent(id);
                    _application.updateStudent(student, tel);
                }
            });
            //Manipulador de eventos para o botão Adicionar Curso.
            addCourseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new StudentCourseAdd().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Remover Curso.
            deleteCourseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    new StudentCourseRemove().setVisible(true);
                }
            });
            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new ManagerStudent().setVisible(true);
                }
            });
        }
    }

    class StudentCourseRemove extends JFrame{
        Student student;
        Course course;
        public StudentCourseRemove(){
            //Configurações da janela do Aluno
            setVisible(false);
            setTitle("SGSA - Atualização de Alunos");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>ATUALIZAR ALUNOS</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            JLabel studentDeleteFieldLabel = new JLabel("ID do Aluno:");
            studentDeleteFieldLabel.setBounds(439, 353, 225, 24);
            studentDeleteFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            studentDeleteFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(studentDeleteFieldLabel);

            JTextField studentDeleteFieldText = new JTextField();
            studentDeleteFieldText.setBounds(654, 352, 225, 21);
            add(studentDeleteFieldText);


            JLabel courseDeleteFieldLabel = new JLabel("Remover o Curso (ID):");
            courseDeleteFieldLabel.setBounds(426, 400, 225, 24);
            courseDeleteFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            courseDeleteFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(courseDeleteFieldLabel);

            JTextField courseDeleteFieldText = new JTextField();
            courseDeleteFieldText.setBounds(654, 399, 225, 21);
            add(courseDeleteFieldText);


            //Botões da tela do Aluno
            JButton removeButton = new JButton("Remover");
            removeButton.setBounds(733, 508, 224 , 78);
            removeButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(404 , 508, 224 , 78);
            goBackButton.setBackground(Color.decode("#FFCBDB"));
            add(removeButton);
            add(goBackButton);

            //Manipulador de eventos para o botão Remover.
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtenha o nome de usuário e senha digitados nos campos de texto e senha.
                    String courseDelete = courseDeleteFieldText.getText();
                    String id = studentDeleteFieldText.getText();
                    System.out.println(courseDelete);

                    course = _application.findCourse(courseDelete);
                    student = _application.findStudent(id);
                    _application.deleteInstanceFromCourse(course, student);
                }
            });
            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new UpdateStudent().setVisible(true);
                }
            });
        }
    }

    class StudentCourseAdd extends JFrame{
        Student student;
        Course course;
        public StudentCourseAdd(){
            //Configurações da janela do Aluno
            setVisible(false);
            setTitle("SGSA - Atualização de Alunos");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>ATUALIZAR ALUNOS</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            JLabel studentAddFieldLabel = new JLabel("ID do Aluno:");
            studentAddFieldLabel.setBounds(439, 353, 225, 24);
            studentAddFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            studentAddFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(studentAddFieldLabel);

            JTextField studentAddFieldText = new JTextField();
            studentAddFieldText.setBounds(654, 352, 225, 21);
            add(studentAddFieldText);

            JLabel courseAddFieldLabel = new JLabel("Adicionar o Curso (ID):");
            courseAddFieldLabel.setBounds(426, 400, 225, 24);
            courseAddFieldLabel.setFont(new Font("Arial", Font.BOLD, 22));
            courseAddFieldLabel.setForeground(Color.decode("#FFFFFF"));
            add(courseAddFieldLabel);

            JTextField courseAddFieldText = new JTextField();
            courseAddFieldText.setBounds(654, 399, 225, 21);
            add(courseAddFieldText);

            //Botões da tela do Aluno
            JButton addButton = new JButton("Adicionar");
            addButton.setBounds(733, 508, 224 , 78);
            addButton.setBackground(Color.decode("#FFCBDB"));
            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(404 , 508, 224 , 78);
            goBackButton.setBackground(Color.decode("#FFCBDB"));
            add(addButton);
            add(goBackButton);

            //Manipulador de eventos para o botão Adicionar.
            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Obtenha o nome de usuário e senha digitados nos campos de texto e senha.
                    String courseAdd = courseAddFieldText.getText();
                    String id = studentAddFieldText.getText();
                    System.out.println(courseAddFieldLabel.getText());

                    student = _application.findStudent(id);
                    course = _application.findCourse(courseAdd);
                    _application.updateStudent(student, course);

                }
            });
            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new UpdateStudent().setVisible(true);
                }
            });

        }
    }

    //Gerar Relatorio e Carregar arquivos
    class ManagerReport extends JFrame{
        public ManagerReport(){
            // Configurações da janela do gestor de relatórios
            setTitle("SGSA - Gerenciamento de Relatórios");
            setSize(1280, 800);
            Color backgroundColor = Color.decode("#1E0027");
            this.getContentPane().setBackground(backgroundColor);
            setLayout(null);
            setResizable(false);

            //Texto da Tela.
            JLabel text = new JLabel("<html><div style='text-align: center;'>GERAR RELATÓRIOS</div></html>S");
            text.setBounds(390, 123, 500, 100);
            text.setFont(new Font("Arial", Font.BOLD, 48));
            text.setForeground(Color.decode("#FFFFFF"));
            add(text);

            //Botões da tela do gestor de relatórios
            JButton generateStudentReportButton = new JButton("Aluno (Tela)");
            generateStudentReportButton.setBounds(107, 331, 225 , 78);
            generateStudentReportButton.setBackground(Color.decode("#FFCBDB"));

            JButton generateProfessorReportButton = new JButton("Professor (Tela)");
            generateProfessorReportButton.setBounds(390, 331, 225 , 78);
            generateProfessorReportButton.setBackground(Color.decode("#FFCBDB"));

            JButton generateCourseReportButton = new JButton("Curso (Tela)");
            generateCourseReportButton.setBounds(107, 490, 225 , 78);
            generateCourseReportButton.setBackground(Color.decode("#FFCBDB"));

            JButton generateClassroomReportButton = new JButton("Sala (Tela)");
            generateClassroomReportButton.setBounds(390, 490, 225 , 78);
            generateClassroomReportButton.setBackground(Color.decode("#FFCBDB"));

            JButton generateFileReportButton = new JButton("Gerar Arquivo");
            generateFileReportButton.setBounds(390, 646, 225 , 78);
            generateFileReportButton.setBackground(Color.decode("#FFCBDB"));


            JButton goBackButton = new JButton("Voltar");
            goBackButton.setBounds(107 , 646, 225 , 78);
            goBackButton.setBackground(Color.decode("#FFCBDB"));

            add(generateStudentReportButton);
            add(generateProfessorReportButton);
            add(generateCourseReportButton);
            add(generateClassroomReportButton);
            add(generateFileReportButton);
            add(goBackButton);

            JTextArea infoTextArea = new JTextArea();
            infoTextArea.setEditable(false);
            JScrollPane infoScrollPane = new JScrollPane(infoTextArea);
            infoScrollPane.setBounds(700, 331, 519, 393);
            add(infoScrollPane, BorderLayout.CENTER);

            //Manipulador de eventos para o botão Gerar Relatorio de Estudantes.
            generateStudentReportButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    infoTextArea.setText(_application.generateStudentReport());
                }
            });
            //Manipulador de eventos para o botão Gerar Relatorio de Professores.
            generateProfessorReportButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    infoTextArea.setText(_application.generateProfessorReport());
                }
            });
            //Manipulador de eventos para o botão Gerar Relatorio de Cursos.
            generateCourseReportButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    infoTextArea.setText(_application.generateCourseReport());
                }
            });
            //Manipulador de eventos para o botão Gerar Relatorio de Salas.
            generateClassroomReportButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    infoTextArea.setText(_application.generateClassroomReport());
                }
            });
            //Manipulador de eventos para o botão Gerar Arquivo.
            generateFileReportButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    _application.generateFileReport("EntitysReport.txt");

                }
            });
            //Manipulador de eventos para o botão Voltar.
            goBackButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Fecha a janela atual e retorna à tela principal.
                    dispose();
                    new ManagerOptionsFrame().setVisible(true);
                }
            });
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
}
