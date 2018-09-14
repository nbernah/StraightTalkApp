package com.example.netlabs.straighttalk.model.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.netlabs.straighttalk.model.database.DAOs.CourseDAO;
import com.example.netlabs.straighttalk.model.database.DAOs.HostelDAO;
import com.example.netlabs.straighttalk.model.database.DAOs.SchoolDAO;
import com.example.netlabs.straighttalk.model.database.DAOs.StudentDAO;
import com.example.netlabs.straighttalk.model.database.entities.Course;
import com.example.netlabs.straighttalk.model.database.entities.Hostel;
import com.example.netlabs.straighttalk.model.database.entities.Institution;
import com.example.netlabs.straighttalk.model.database.DAOs.InstitutionDAO;
import com.example.netlabs.straighttalk.model.database.entities.School;
import com.example.netlabs.straighttalk.model.database.entities.Student;
import com.example.netlabs.straighttalk.model.database.entities.Secondary;
import com.example.netlabs.straighttalk.model.database.DAOs.SecondaryDAO;

@Database(
        entities = {
                Secondary.class,
                Institution.class,
                Student.class,
                School.class,
                Course.class,
                Hostel.class
        },
        version = 6,
        exportSchema = false
)
public abstract class BursaryDatabase extends RoomDatabase {

    private static BursaryDatabase INSTANCE;

    public static BursaryDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BursaryDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BursaryDatabase.class, DBConstants.DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract SecondaryDAO secondaryDAO();
    public abstract InstitutionDAO institutionsDAO();
    public abstract StudentDAO studentDAO();
    public abstract SchoolDAO schoolDAO();
    public abstract CourseDAO courseDAO();
    public abstract HostelDAO hostelDAO();
}
