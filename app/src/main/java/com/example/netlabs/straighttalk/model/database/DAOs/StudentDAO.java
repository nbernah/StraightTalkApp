package com.example.netlabs.straighttalk.model.database.DAOs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.netlabs.straighttalk.model.database.entities.Student;

import java.util.List;

@Dao
public interface StudentDAO {
    @Insert
    void insertStudent(Student student);

    @Update
    void updateStudent(Student student);

    @Query("SELECT * FROM student")
    LiveData<List<Student>> getAllStudents();

    @Query("SELECT * FROM student WHERE id = :id")
    Student getStudent(int id);

    @Query("DELETE FROM student WHERE id = :id")
    void deleteStudent(int id);
}
