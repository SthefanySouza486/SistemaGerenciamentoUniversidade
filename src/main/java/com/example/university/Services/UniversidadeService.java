package com.example.university.Services;

public interface UniversidadeService {
    void assignProfessorToCourse(Long professorId, Long cursoId);
    void removeProfessorFromCourse(Long professorId, Long cursoId);
}
