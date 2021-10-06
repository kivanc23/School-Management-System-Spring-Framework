package com.kivanccode.schoolmanagement.repositories;

import com.kivanccode.schoolmanagement.models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer> {
    @Modifying
    @Query("delete from Students c where c.StudentName=:title")
    void deleteStudents(@Param("title") String title);
    @Modifying
    @Query("delete from Students c where c.StudentNumber=:id")
    void deleteStudentsId(@Param("id") Integer id);
}
