/*A classe Person é a classe Pai de minhas outras 3 entidades, Manager, Professor e Student.
* É atraves dela que coleto e determino as informações de cada pessoa. */

public class Person {
    protected String name;
    protected String cpf;
    protected String tel;

    public Person(String name, String cpf, String tel) {
        this.name = name;
        this.cpf = cpf;
        this.tel = tel;
    }

    public Person(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
