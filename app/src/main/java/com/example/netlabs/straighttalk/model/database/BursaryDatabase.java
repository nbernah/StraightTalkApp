package com.example.netlabs.straighttalk.model.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.netlabs.straighttalk.model.database.entities.Institutions;
import com.example.netlabs.straighttalk.model.database.entities.InstitutionsDAO;
import com.example.netlabs.straighttalk.model.database.entities.PersonalDetails;
import com.example.netlabs.straighttalk.model.database.entities.PersonalDetailsDAO;
import com.example.netlabs.straighttalk.model.database.entities.Secondary;
import com.example.netlabs.straighttalk.model.database.entities.SecondaryDAO;

@Database(entities = {Secondary.class, Institutions.class, PersonalDetails.class}, version = 4, exportSchema = false)
public abstract class BursaryDatabase extends RoomDatabase {

    private static BursaryDatabase INSTANCE;

    public static BursaryDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BursaryDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BursaryDatabase.class, "bursary_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract SecondaryDAO secondaryDAO();
    public abstract InstitutionsDAO institutionsDAO();
    public abstract PersonalDetailsDAO personalDetailsDAO();
}
