package com.example.lib_man_sys.repository;

import com.example.lib_man_sys.Enum.Gender;
import com.example.lib_man_sys.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

//    @Query(value = "select * from student where gender = 'MALE'")
//    List<Student> findByGender(Gender gender);

    List<Student> findByGender(Gender gender);

//    Student findByGendrAndEmail(Gender gender, String email);

    @Modifying
    @Transactional
    @Query(value = "update student set age = :newAge where reg_no = :regNo", nativeQuery = true)
    void updateAge(@Param("regNo") int regNo, @Param("newAge") int newAge);
}
