package main.validation;

import main.domain.Student;

public class StudentValidator implements Validator<Student> {

    /**
     * Valideaza un student
     * @param entity - studentul pe care il valideaza
     * @throws ValidationException - daca studentul nu e valid
     */
    @Override
    public void validate(Student entity) throws ValidationException {
        if(entity.getID().equals("")){
            throw new ValidationException("Id incorect!");
        }
        if(entity.getID() == null){
            throw new ValidationException("Id incorect!");
        }
        if(entity.getID().equals("0")){
            throw new ValidationException("Id incorect!");
        }
        if(!entity.getID().matches("(0|[1-9]\\d*)")){
            throw new ValidationException("Id incorect!");
        }
        if(entity.getNume().equals("")){
            throw new ValidationException("Nume incorect!");
        }
        if(!entity.getNume().matches("^[\\p{L} .'-]+$")){
            throw new ValidationException("Nume incorect!");
        }
        if(entity.getGrupa() <= 0) {
            throw new ValidationException("Grupa incorecta!");
        }
        if(entity.getEmail() == null){
            throw new ValidationException("Email incorect!");
        }
        if(entity.getNume() == null){
            throw new ValidationException("Nume incorect!");
        }
        if(entity.getEmail().equals("")){
            throw new ValidationException("Email incorect!");
        }
        if(!entity.getEmail().contains("@")){
            throw new ValidationException("Email incorect!");
        }
        if(!entity.getEmail().contains(".")){
            throw new ValidationException("Email incorect!");
        }
    }
}
