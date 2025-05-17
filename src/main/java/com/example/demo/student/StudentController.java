package com.example.demo.student;

public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }


    @PostMapping
    public void addNewStudent(@RequestBody Student student){
        System.out.println(student);
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @PathVariable Long studentId
    ){
        studentService.updateStudent(studentId, name, email);
    }
}
