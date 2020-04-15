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
        Tema tema = new Tema("300","tema nr 300", 9,9);
        this.service.addTema(tema);
        assertEquals(tema.getDescriere(),this.temaRepo.findOne("300").getDescriere());

    }

    @Test
    public void testAddValidGrade() throws ValidationException {
        LocalDate inputDate = LocalDate.of(2020,4,29);
        Nota nota = new Nota("100","23","300", 10,inputDate);
      //  this.service.addNota(nota,"super");
      //  assertEquals(nota.getIdStudent(),this.notaRepository.findOne("100").getIdStudent());
    }

    @Test
    public void testAll() throws ValidationException {
       this.testAddValidAssignment();
       this.testAddValidGrade();
       this.testAddValidStudent();
       //assertEquals(studentRepository.size(),3);
       //assertEquals(this.temaRepo.(),4);
      // assertEquals(notaRepository.size(),1);
    }
}
