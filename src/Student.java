/*Minha Classe Student serve para armazenar os dados de meus alunos. Ela Herda os atributos base da classe Person
* e adiciona para cada aluno uma lista de cursos em que estão matriculados.*/
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student extends  Person{
    private final String id;
    List<Course> courses = new ArrayList<>();

    public Student(String name, String cpf, String tel, String id) {
        super(name, cpf, tel);
        this.id = id;
    }

    public String getId() {
            return id;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public void studentTest(){
        System.out.println("Student Test");
    }
    /*Abaixo uma "Representação" de como seria uma sobregarca do operador == como feito em C++
     * nele estou reescrevendo o método ja existente "equals".
     * */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student other) {
            return Objects.equals(id, other.id);
        }
        return false;
    }

    /*Abaixo uma "Representação" de como seria uma sobregarca do operador << como feito em C++
     * nele estou reescrevendo o método ja existente "toString".
     */
    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "CPF: " + cpf + "\n" +
                "Telephone: " + tel + "\n" +
                "Matriculate: " + id;
    }
}
