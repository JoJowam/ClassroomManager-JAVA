/*Nesta classe eu crio a entidade Classrom e alguns métodos para manusea-la em minhas outras
* classes. Cada Classroom vai ter um ID, uma Capacidade e uma Lista de Cursos!*/

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Classroom {
    private final String id;
    private final int capacity;
    List<Course> courses = new ArrayList<>();

    public Classroom(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    //Getters
    public String getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
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
        if (obj instanceof Classroom other) {
            return Objects.equals(id, other.id);
        }
        return false;
    }

    /*Abaixo uma "Representação" de como seria uma sobregarca do operador << como feito em C++
    * nele estou reescrevendo o método ja existente "toString".
    */
    @Override
    public String toString() {
        return id + " " + capacity;
    }
}
