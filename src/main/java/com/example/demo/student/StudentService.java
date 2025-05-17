package com.example.demo.student;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> optionalStudent = studentRepository.findByEmail(student.getEmail());
        if(optionalStudent.isPresent()){
            throw new IllegalArgumentException("Student already exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalArgumentException("Student does not exist with this id: " + studentId);
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new IllegalStateException("Student does not exist with this id: " + studentId)
        );
        if(!name.isBlank() && !Objects.equals(name, student.getName())){
            student.setName(name);
        }
        if(!email.isBlank() && !Objects.equals(email, student.getEmail())){
            Optional<Student> optionalStudent = studentRepository.findByEmail(email);
            if(optionalStudent.isPresent()){
                throw new IllegalArgumentException("Student already exists");
            }
            student.setEmail(email);
        }
    }
}
