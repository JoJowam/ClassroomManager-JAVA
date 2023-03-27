/*Nesta Classe estou criando a entidade Manager que funciona como Gestor em minha aplicação
* Uso essa classe para poder logar e gerenciar as outras entidades dentro de meu menu. Cada
* Manager tem os atributos de Person e os dados de Login e Senha.*/

import java.util.List;
import java.util.Objects;

public class Manager extends Person {
    private String login = "admin";
    private String password = "admin";

    public Manager(String name, String cpf, String tel, String login, String password) {
        super(name, cpf, tel);
        this.login = login;
        this.password = password;
    }

    public Manager(){}

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Boolean tryLogin(List<Manager> managers, String enteredLogin, String enteredPassword){
        //Verifica se o login e senha digitados estão corretos
        for (Manager manager : managers) {
            if (manager.getLogin().equals(enteredLogin) && manager.getPassword().equals(enteredPassword)) {
                return true;
            }
        }
        return false;
    }

    /*Abaixo uma "Representação" de como seria uma sobregarca do operador == como feito em C++
     * nele estou reescrevendo o método ja existente "equals".
     * */
    public boolean equals(Object obj) {
        if (obj instanceof Manager other) {
            return Objects.equals(cpf, other.cpf);
        }
        return false;
    }
}
