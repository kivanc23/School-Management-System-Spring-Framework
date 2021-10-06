package com.kivanccode.schoolmanagement.repositories;

import com.kivanccode.schoolmanagement.models.Students;
import com.kivanccode.schoolmanagement.models.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachersRepository extends JpaRepository<Teachers, Integer> {

    @Modifying
    @Query("delete from Teachers c where c.TeacherNumber=:id")
    void deleteTeachersId(@Param("id") Integer id);

    @Query(value = "select * from Teachers c where c.teacher_number=:id",nativeQuery = true)
    Teachers getTeacherById(int id);

}