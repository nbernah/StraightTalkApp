package com.example.netlabs.straighttalk.model.database.DAOs;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.netlabs.straighttalk.model.database.DBConstants;
import com.example.netlabs.straighttalk.model.database.entities.Course;

import java.util.List;

@Dao
public interface CourseDAO {
    @Insert
    void insertCourse(Course course);

    @Update
    void updateCourse(Course course);

    @Query("SELECT * FROM " + DBConstants.COURSE_TABLE_NAME)
    LiveData<List<Course>> getAllCourses();

    @Query("SELECT * FROM " + DBConstants.COURSE_TABLE_NAME + " WHERE id = :id")
    Course getCourse(int id);

    @Query("DELETE FROM " + DBConstants.COURSE_TABLE_NAME + " WHERE id = :id")
    void deleteCourse(int id);
}
