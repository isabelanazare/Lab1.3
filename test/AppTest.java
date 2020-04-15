import main.domain.Student;
import main.domain.Tema;
import main.domain.Nota;
import main.repository.*;
import main.service.*;
import main.validation.*;
import main.validation.*;
import org.junit.Before;
import org.junit.Test;

import java.util.AbstractMap;
import java.util.Map;

public class AppTest {
    /*
    private StudentValidator studentValidator;
    private StudentRepo studentRepository;
    private NotaValidator notaValidator;
    private NoteRepo notaRepository;
    private TemeValidator temaValidator;
    private TemeRepo temaRepository;
    private ServiceStudent serviceStudent;
    private ServiceTeme serviceTeme;
    private ServiceNote serviceNote;
    */
    @Before
    public void setup() {
        /*
        this.studentValidator = new StudentValidator();
        this.temaValidator = new TemeValidator();
        this.notaValidator = new NotaValidator();
        this.temaRepository = new TemeRepo(temaValidator, "D:\\uni\\vvss\\Lab45\\teme.xml");
        this.studentRepository = new StudentRepo(studentValidator, "D:\\uni\\vvss\\Lab45\\studenti.xml");
        this.notaRepository = new NoteRepo(notaValidator);
        this.serviceNote = new ServiceNote(notaRepository);
        this.serviceStudent = new ServiceStudent(studentRepository);
        this.serviceTeme = new ServiceTeme(temaRepository);

         */
    }

    @Test
    public void testAddValidStudent() throws ValidationException {
        /*
        Student student = new Student("3","Maria",931,"maria@gmail.com","Ana");
        assertEquals(student.getNume(),  this.serviceStudent.find("3").getNume());

         */
    }

    @Test
    public void testAddValidAssignment() throws ValidationException {/*
        Teme tema = new Teme(4,"tema nr 4", 5,7);
        this.serviceTeme.add(tema);
        assertEquals(tema,this.temaRepository.findOne(4));
        */
    }

    @Test
    public void testAddValidGrade() throws ValidationException {
        /*
        Map.Entry<String, Integer> nid = new AbstractMap.SimpleEntry<>("300", 2);
        Student student = this.serviceStudent.find("1");
        Teme tema = this.serviceTeme.find(2);
        Nota nota = new Nota(nid, student, tema, 10, 5);
        this.serviceNote.add(nota, "great");
        assertEquals(nota,this.notaRepository.findOne(nid));
         */
    }

    @Test
    public void testAll() throws ValidationException {
        /*
       this.testAddValidAssignment();
      this.testAddValidGrade();
       this.testAddValidStudent();
       assertEquals(studentRepository.size(),3);
       assertEquals(temaRepository.size(),4);
       assertEquals(notaRepository.size(),1);

         */
    }
}
