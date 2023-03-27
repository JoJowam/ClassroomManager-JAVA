/* A Classe professor serve para coletar e armazer as informações de meus professores
* ela herda os atributos base de Person e adiciona a cada professor uma lista de cursos.*/
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Professor extends Person {
    private List<Course> courses = new ArrayList<>();

    public Professor(String name, String cpf, String tel) {
        super(name, cpf, tel);
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

    /*Abaixo uma "Representação" de como seria uma sobregarca do operador == como feito em C++
     * nele estou reescrevendo o método ja existente "equals".
     * */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Professor other) {
            return Objects.equals(cpf, other.cpf);
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
                "Telephone: " + tel;
    }

}
