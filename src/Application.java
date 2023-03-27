/*Aplication é a classe principal de meu programa, anteriormente chamada System, Application
* fica responsavel por juntar em um só lugar os métodos CRUD, onde com o auxilio dos mesmos
* me possibilita adicionar e controlar os dados dos inputs dos usuarios em minha interface grafica*/

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Application {
    /*Abaixo crio a coleção List, onde vão ser armazenados os dados de meus usuarios
    * e é atraves dela que vou fazer a manipulação de inputs e outputs*/
    private List<Manager> managers = new ArrayList<>();
    private List<Classroom> classrooms = new ArrayList<>();
    private List<Professor> professors = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public Application(){

    }

    public boolean[] getDivergentDays(Course newCourse) {
        //Método que retorna um array de booleanos com cinco posições, representando cada dia da semana
        //afim de verificar se o novo curso tem dias em comum com os cursos já existentes.
        boolean[] divergentDays = new boolean[5];
        for (int i = 0; i < 5; i++) {
            for (Course course : courses) {
                if (course.getDays()[i] && newCourse.getDays()[i]) {
                    divergentDays[i] = true;
                    break;
                }
            }
        }
        return divergentDays;
    }


    public boolean[] convertDaysStringToArray(String daysString) {
        //Método que converte uma string representando os dias da semana em um array de booleanos.

        boolean[] daysArray = new boolean[] {false, false, false, false, false};

        //Converte a string em caixa alta para evitar erros de comparação.
        String daysUpper = daysString.toUpperCase();

        //Verifica se a string contém cada dia da semana e marca a posição correspondente no array como verdadeiro.
        if (daysUpper.contains("SEGUNDA")) {
            daysArray[0] = true;
        }
        if (daysUpper.contains("TERÇA")) {
            daysArray[1] = true;
        }
        if (daysUpper.contains("QUARTA")) {
            daysArray[2] = true;
        }
        if (daysUpper.contains("QUINTA")) {
            daysArray[3] = true;
        }
        if (daysUpper.contains("SEXTA")) {
            daysArray[4] = true;
        }

        return daysArray;
    }

    public String getDaysString(boolean[] days) {
        //Método que converte um array de booleanos representando os dias da semana em uma string.

        String daysString = "";
        if (days[0]) {
            daysString += "Segunda-feira, ";
        }
        if (days[1]) {
            daysString += "Terça-feira, ";
        }
        if (days[2]) {
            daysString += "Quarta-feira, ";
        }
        if (days[3]) {
            daysString += "Quinta-feira, ";
        }
        if (days[4]) {
            daysString += "Sexta-feira, ";
        }
        //Removendo a vírgula e o espaço no final da string.
        if (!daysString.equals("")) {
            daysString = daysString.substring(0, daysString.length() - 2);
        }
        return daysString;
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public Manager setManagers(String name, String cpf, String tel, String login, String password) {

        Manager newManager = new Manager(name, cpf, tel, login, password);

        for (Manager manager : managers) {
            if (!managers.contains(newManager)) {
                managers.add(newManager);
            }
        }

        return newManager;
    }

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(String id, int capacity) {
        Classroom newClassroom = new Classroom(id, capacity);

        //Verifica se a sala já existe.
        if (!classrooms.contains(newClassroom)) {
            classrooms.add(newClassroom);
            JOptionPane.showMessageDialog(null, "Sala: " + id + " foi cadastrada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Sala já existente!");
        }
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(String name, String cpf, String tel) {

        Professor newProfessor = new Professor(name, cpf, tel);
        //Verifica se o professor já existe.
        if (!professors.contains(newProfessor)) {

            professors.add(newProfessor);
            JOptionPane.showMessageDialog(null, "O Professor: " + name + " foi cadastrado com sucesso!");
        } else {
            System.out.println("Entrou no else");
            JOptionPane.showMessageDialog(null, "O Professor: " + name +" já existe!");
        }
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Course setCourses(String id, String name, boolean[] days) throws Exception {
        Course newCourse = new Course(id, name, days);

        //Verifica se o curso já existe.
        for (Course course : courses) {
            if (course.equals(newCourse)) {
                JOptionPane.showMessageDialog(null, "Curso ja existente");
                throw new Exception("Curso ja existente");
            }
        }

        boolean[] divergentDays = getDivergentDays(newCourse);

        //Verifica se o curso tem dias em comum com os cursos já existentes.
        Predicate<Classroom> availableClassroom = classroom -> {
            for (int i = 0; i < divergentDays.length; i++) {
                if (divergentDays[i]) {
                    for (Course course : classroom.getCourses()) {
                        if (course.getDays()[i]) {

                            return false;
                        }
                    }
                }
            }
            return true;
        };

        //Verifica se existe alguma sala disponível.
        Optional<Classroom> classroomOptional = classrooms.stream().filter(availableClassroom).findFirst();
        if (!classroomOptional.isPresent()) {
            JOptionPane.showMessageDialog(null, "Nenhuma sala disponivel");
            throw new Exception("Nenhuma sala disponivel");
        }
        Classroom classroom = classroomOptional.get();

        //Adiciona o curso a lista de cursos e a sala a lista de salas.
        courses.add(newCourse);
        newCourse.setClassroom(classroom);
        classroom.addCourse(newCourse);
        return newCourse;
    }


    public void setStudents(String name, String cpf, String tel, String id) {
        Student newStudent = new Student(name, cpf, tel, id);
        //Verifica se o aluno já existe.
        if (!students.contains(newStudent)) {
            students.add(newStudent);
            JOptionPane.showMessageDialog(null, " O Aluno: " + name + " foi cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "O Aluno: " + name +" já existente!");
        }
    }

    public Student findStudent(String id) {
        boolean found = false;
        Student result = null;

        //Percorre por Students em busca de algum aluno que bata com o ID fornecido.
        for (Student student : students) {
            if (student.getId().equals(id)) {
                result = student;
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado");
            throw new RuntimeException("Aluno não encontrado");
        }
        return result;
    }


    public Professor findProfessor(String cpf) {
        boolean found = false;
        Professor result = null;

        //Percorre por Professors em busca de algum professor que bata com o CPF fornecido.
        for (Professor professor  : professors) {
            if (professor.getCpf().equals(cpf)) {
                result = professor;
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Professor não encontrado");
            throw new RuntimeException("Professor não encontrado");
        }
        return result;
    }

    public Course findCourse(String id) {
        boolean found = false;
        Course result = null;

        //Percorre por Courses em busca de algum curso que bata com o ID fornecido.
        for (Course course : courses) {
            if (course.getId().equals(id)) {
                result = course;
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Curso não encontrado");
            throw new RuntimeException("Curso não encontrado");
        }
        return result;
    }

    public Classroom findClassroom(String id) {
        boolean found = false;
        Classroom result = null;

        //Percorre por Classrooms em busca de alguma sala que bata com o ID fornecido.
        for (Classroom classroom : classrooms) {
            if (classroom.getId().equals(id)) {
                result = classroom;
                found = true;
                break;
            }
        }
        if (!found) {
            JOptionPane.showMessageDialog(null, "Sala não encontrada");
            throw new RuntimeException("Sala não encontrada");
        }
        return result;
    }

    public void updateProfessor(Professor professor, String tel){
        //Recebe um Telefone e atualiza o telefone do professor.
        professor.setTel(tel);
        JOptionPane.showMessageDialog(null, "Telefone do professor: " + professor.getName() + " foi atualizado com sucesso para: " + tel);
    }

    public void updateProfessor(Professor professor, Course newCourse){
        boolean isDivergent = false;

        //Percorre por todos os cursos do professor e verifica se o novo curso tem dias em comum com algum curso já existente.
        for (Course course : professor.getCourses()) {
            for (int i = 0; i < 5; i++) {
                if (course.getDays()[i] && newCourse.getDays()[i]) {
                    isDivergent = true;
                    break;
                }
            }

        }

        //Verifica se o professor já leciona o curso, se já tem 3 cursos e se o novo curso tem dias em comum com algum curso já existente.
        if (professor.getCourses().contains(newCourse)) {
            JOptionPane.showMessageDialog(null, "Professor ja leciona o curso: " + newCourse.getName() + "");
        }else if (professor.getCourses().size() >= 3) {
            JOptionPane.showMessageDialog(null, "Professor ja tem 3 cursos");
        }else if (isDivergent) {
            JOptionPane.showMessageDialog(null, "Professor ja leciona em outro curso nesse horario");
        }else {
            professor.addCourse(newCourse);
            newCourse.setProfessor(professor);
            JOptionPane.showMessageDialog(null, "O Professor: " + professor.getName() + " foi cadastrado no curso: " + newCourse.getName() + " com sucesso!");
        }
    }

    public void updateStudent(Student student, String tel){
        //Recebe um Telefone e atualiza o telefone do aluno.
        student.setTel(tel);
        JOptionPane.showMessageDialog(null, "Telefone do aluno: " + student.getName() + " foi atualizado com sucesso para: " + tel);
    }

    public void updateStudent(Student student, Course newCourse) {
            boolean isDivergent = false;

            //Percorre por todos os cursos do aluno e verifica se o novo curso tem dias em comum com algum curso já existente.
            for (Course course : student.getCourses()) {
                for (int i = 0; i < 5; i++) {
                    if (course.getDays()[i] && newCourse.getDays()[i]) {
                        isDivergent = true;
                        break;
                    }
                }

            }

            //Verifica se o aluno já está cadastrado no curso, se a sala já está lotada e se o novo curso tem dias em comum com algum curso já existente.
            if (isDivergent) {
                JOptionPane.showMessageDialog(null, "Aluno ja tem aula nesse dia");
            }else if (newCourse.getStudents().size() >= newCourse.getClassroom().getCapacity()) {
                JOptionPane.showMessageDialog(null, "Sala lotada");
            } else if (newCourse.getStudents().contains(student)) {
                JOptionPane.showMessageDialog(null, "Aluno ja cadastrado nesse curso");
            }else {
                student.addCourse(newCourse);
                newCourse.addStudent(student);
                JOptionPane.showMessageDialog(null, "O Aluno: " + student.getName() + " foi cadastrado no curso: " + newCourse.getName() + " com sucesso!");
            }
    }

    public void updateCourse(Course course, String name){
        //Recebe um nome e atualiza o nome do curso.
        course.setName(name);
        JOptionPane.showMessageDialog(null, "O nome do curso: " + course.getId() + " foi atualizado com sucesso para: " + name);
    }

    public void updateCourse(Course course, Professor professor){
        //Recebe um professor e um curso e atualiza o professor desse curso.
        updateProfessor(professor, course);
        JOptionPane.showMessageDialog(null, "O Professor: " + professor.getName() + " foi cadastrado no curso: " + course.getName() + " com sucesso!");

    }

    public void updateCourse(Course course, Student student){
        //Recebe um aluno e um curso e atualiza o aluno desse curso.
        updateStudent(student, course);
        JOptionPane.showMessageDialog(null, "O Aluno: " + student.getName() + " foi cadastrado no curso: " + course.getName() + " com sucesso!");
    }

    public void deleteInstance(Professor professor){

        //Percorre pelos cursos do professor e remove o professor de cada curso.
        for (Course course : professor.getCourses()) {
            course.setProfessor(null);
        }

        //Remove o professor da lista de professores.
        professors.remove(professor);
        JOptionPane.showMessageDialog(null, "O Professor: " + professor.getName() + " foi removido com sucesso!");
    }

    public void deleteInstance(Student student){

        //Percorre pelos cursos do aluno e remove o aluno de cada curso.
        for (Course course : student.getCourses()) {
            course.removeStudent(student);
        }

        //Remove o aluno da lista de alunos.
        students.remove(student);
        JOptionPane.showMessageDialog(null, "O Aluno: " + student.getName() + " foi removido com sucesso!");
    }



    public void deleteInstance(Course course){

        //Remove o Curso de uma sala.
        course.getClassroom().removeCourse(course);

        //Remove o courso do professor.
        if (course.getProfessor() != null){
            course.getProfessor().removeCourse(course);
        }

        //Remove o course dos alunos.
       for (Student student : course.getStudents()) {
            student.removeCourse(course);
        }

        //Remove o curso da lista de cursos.
        courses.remove(course);
        JOptionPane.showMessageDialog(null, "O Curso: " + course.getName() + " foi removido com sucesso!");
    }

    public void deleteInstanceFromCourse(Course course, Student student){

        //Remove o aluno do curso.
        course.removeStudent(student);
        student.removeCourse(course);
        JOptionPane.showMessageDialog(null, "O Aluno: " + student.getName() + " foi removido do curso: " + course.getName() + " com sucesso!");
    }

    public void deleteInstanceFromCourse(Course course, Professor professor){

        //Remove o professor do curso.
        course.setProfessor(null);
        professor.removeCourse(course);
        JOptionPane.showMessageDialog(null, "O Professor: " + professor.getName() + " foi removido do curso: " + course.getName() + " com sucesso!");
    }

    public String generateStudentReport() {

        //Gera um relatório com todos os alunos cadastrados atraves de concatenação de String
        //Uso ele posteriormente para informar um relatorio na tela e gerar um arquivo do mesmo.
        StringBuilder report = new StringBuilder();
        for (Student student : getStudents()) {
            report.append("\n");
            report.append("Aluno:\n");
            report.append("Nome: ").append(student.getName()).append("\n");
            report.append("ID: ").append(student.getId()).append("\n");
            report.append("CPF: ").append(student.getCpf()).append("\n");
            report.append("Telefone: ").append(student.getTel()).append("\n");
            report.append("Matriculado(a) nos cursos: \n");
            for (Course course : student.getCourses()) {
                report.append(" - ").append(course.getName()).append("\n");
            }
            report.append("\n======================================\n");
        }
        return report.toString();
    }

    public String generateProfessorReport() {

        //Gera um relatório com todos os professores cadastrados atraves de concatenação de String
        //Uso ele posteriormente para informar um relatorio na tela e gerar um arquivo do mesmo.
        StringBuilder report = new StringBuilder();
        for (Professor professor : getProfessors()) {
            report.append("\n");
            report.append("Professor:\n");
            report.append("Nome: ").append(professor.getName()).append("\n");
            report.append("CPF: ").append(professor.getCpf()).append("\n");
            report.append("Telefone: ").append(professor.getTel()).append("\n");
            report.append("Leciona nos cursos: \n");
            for (Course course : professor.getCourses()) {
                report.append(" - ").append(course.getName()).append("\n");
            }
            report.append("\n======================================\n");
        }
        return report.toString();
    }

    public String generateCourseReport() {

        //Gera um relatório com todos os cursos cadastrados atraves de concatenação de String
        //Uso ele posteriormente para informar um relatorio na tela e gerar um arquivo do mesmo.
        StringBuilder report = new StringBuilder();
        for (Course course : getCourses()) {
            report.append("\n");
            report.append("Curso:\n");
            report.append("Nome: ").append(course.getName()).append("\n");
            report.append("ID: ").append(course.getId()).append("\n");
            Professor professor = course.getProfessor();
            if (professor != null) {
                report.append("Professor: ").append(professor.getName()).append("\n");
            } else {
                report.append("Professor: Sem Professor\n");
            }
            report.append("Alunos matriculados: \n");
            for (Student student : course.getStudents()) {
                report.append(" - ").append(student.getName()).append("\n");
            }
            report.append("\n======================================\n");
        }
        return report.toString();
    }


    public String generateClassroomReport() {

        //Gera um relatório com todas as salas cadastradas atraves de concatenação de String
        //Uso ele posteriormente para informar um relatorio na tela e gerar um arquivo do mesmo.
        StringBuilder report = new StringBuilder();
        for (Classroom classroom : getClassrooms()) {
            report.append("\n");
            report.append("Sala:\n");
            report.append("ID: ").append(classroom.getId()).append("\n");
            report.append("Cursos lecionados: \n");
            for (Course course : classroom.getCourses()) {
                report.append(" - ").append(course.getName()).append("\n");
            }
            report.append("\n======================================\n");
        }
        return report.toString();
    }

    public void loadFileReport() {

        //Nesse método eu leio o arquivo report.txt e crio as instancias de acordo com o que está no arquivo.
        Course course;
        Student student;
        Professor professor;
        Classroom classroom;

        String filename = "src/report.txt";
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while ((line = reader.readLine()) != null) {

                if (line.contains("classroom")) {
                    //Lendo o arquivo e criando instancias de classroom.
                    String id = reader.readLine();
                    String capacidade = reader.readLine();

                    int capacidadeInt = Integer.parseInt(capacidade);
                    setClassrooms(id, capacidadeInt);

                    JOptionPane.showMessageDialog(null, "A Sala: " + id + " foi adicionada com sucesso!");
                }

                if (line.contains("course")) {
                    //Lendo o arquivo e criando instancias de course.
                    String id = reader.readLine();
                    String nome = reader.readLine();
                    String daysString = reader.readLine();

                    boolean[] days = convertDaysStringToArray(daysString);
                    setCourses(id, nome, days);;

                    JOptionPane.showMessageDialog(null, "O Curso: " + nome + " foi adicionado com sucesso!");
                }
                if (line.contains("student")) {
                    //Lendo o arquivo e criando instancias de student.
                    String nome = reader.readLine();
                    String cpf = reader.readLine();
                    String telefone = reader.readLine();
                    String matricula = reader.readLine();
                    String cursosId = reader.readLine();

                    setStudents(nome, cpf, telefone, matricula);
                    student = findStudent(matricula);
                    course = findCourse(cursosId);

                    student.addCourse(course);
                    course.addStudent(student);
                    JOptionPane.showMessageDialog(null, "O Aluno: " + student.getName() + " foi adicionado com sucesso ao curso " + course.getId());
                }
                if (line.contains("professor")) {
                    //Lendo o arquivo e criando instancias de professor.
                    String nome = reader.readLine();
                    String cpf = reader.readLine();
                    String telefone = reader.readLine();
                    String curseId = reader.readLine();

                    setProfessors(nome, cpf, telefone);
                    professor = findProfessor(cpf);
                    course = findCourse(curseId);

                    professor.addCourse(course);
                    course.setProfessor(professor);
                    JOptionPane.showMessageDialog(null, "O Professor: " + professor.getName() + " foi adicionado com sucesso ao curso " + course.getId());
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo " + filename + ": " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void generateFileReport(String filename) {
        //Nesse método eu gero um arquivo com todos os relatórios gerados.
        String allReports = generateStudentReport() + generateProfessorReport() + generateCourseReport() + generateClassroomReport();
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(allReports);
            writer.close();
            System.out.println("Relatórios salvos em " + filename);
            JOptionPane.showMessageDialog(null, "Relatórios salvos em " + filename);
        } catch (IOException e) {
            System.out.println("Erro ao salvar relatórios em " + filename + ": " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao salvar relatórios em " + filename + ": " + e.getMessage());
        }
    }
}
