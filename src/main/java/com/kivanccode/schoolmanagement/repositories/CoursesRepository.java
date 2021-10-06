package com.kivanccode.schoolmanagement.repositories;

import com.kivanccode.schoolmanagement.models.Courses;
import com.kivanccode.schoolmanagement.models.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {
    @Modifying
    @Query("delete from Courses c where c.CourseName=:title")
    void deleteCourses(@Param("title") String title);

    @Query(value = "select * from Courses c where c.course_number=:id",nativeQuery = true)
    Courses getCourseById(int id);
}
