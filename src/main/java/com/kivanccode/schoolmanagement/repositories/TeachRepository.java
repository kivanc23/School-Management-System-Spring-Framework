package com.kivanccode.schoolmanagement.repositories;

import com.kivanccode.schoolmanagement.models.Teach;
import com.kivanccode.schoolmanagement.models.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachRepository extends JpaRepository<Teach, Integer> {

    @Query(value = "select course_number from Teach c where c.course_number=:id",nativeQuery = true)
    int getTeachCourseNumber(int id);
    @Query(value = "select teacher_number from Teach c where c.teacher_number=:id",nativeQuery = true)
    int getTeachTeacherNumber(int id);
    @Modifying
    @Query(value = "delete from teach where id=:id",nativeQuery = true)
    void deleteTeachId(@Param("id") Integer id);
}
