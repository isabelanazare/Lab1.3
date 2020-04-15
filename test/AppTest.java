import main.domain.Student;
import main.domain.Tema;
import main.domain.Nota;
import main.repository.*;
import main.service.*;
import main.validation.*;
import main.validation.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AppTest {
    private StudentValidator studentValidator;
    private StudentXMLRepo studentRepository;
    private NotaValidator notaValidator;
    private NotaXMLRepo notaRepository;
    private TemaValidator temaValidator;
    private TemaXMLRepo temaRepo;
    private Service service;

    @Before
    public void setup() {
        this.studentValidator = new StudentValidator();
        this.temaValidator = new TemaValidator();
        this.studentValidator = new StudentValidator();
        this.temaValidator = new TemaValidator();
        this.notaRepository = new NotaXMLRepo("Note.xml");
        this.temaRepo = new TemaXMLRepo("Teme.xml");
        this.studentRepository = new StudentXMLRepo("Studenti.xml");
        this.notaValidator = new NotaValidator(this.studentRepository, this.temaRepo);
        this.service = new Service(studentRepository,studentValidator,temaRepo,temaValidator,notaRepository,notaValidator);
    }

    @Test
    public void testAddValidStudent() throws ValidationException {

        Student student = new Student("200","Maria",931,"maria@gmail.com");
        this.service.addStudent(student);
        assertEquals(student.getNume(),  this.service.findStudent("200").getNume());
    }

    @Test
    public void testAddValidAssignment() throws ValidationException {
        Tema tema = new Tema("400","tema", 14,9);
        this.service.addTema(tema);
        assertEquals(tema.getDescriere(),this.temaRepo.findOne("400").getDescriere());

    }

    @Test
    public void testAddValidGrade() throws ValidationException {
        LocalDate inputDate = LocalDate.of(2020,6,13);
        Nota nota = new Nota("100","23","400", 10,inputDate);
        this.service.addNota(nota,"super");
       assertEquals(nota.getIdStudent(),this.notaRepository.findOne("100").getIdStudent());
    }

    @Test
    public void testAll() throws ValidationException {
       this.testAddValidAssignment();
       this.testAddValidGrade();
       this.testAddValidStudent();
       assertEquals(studentRepository.size(),10);
       assertEquals(this.temaRepo.size(),11);
       assertEquals(notaRepository.size(),2);
    }
}
