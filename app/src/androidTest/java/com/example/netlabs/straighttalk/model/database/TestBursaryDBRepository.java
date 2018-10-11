package com.example.netlabs.straighttalk.model.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.netlabs.straighttalk.model.database.entities.School;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class TestBursaryDBRepository {

    private static BursaryDBRepository dbRepo;

    @BeforeClass
    public static void setUp() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        dbRepo = BursaryDBRepository.getRepository((Application) appContext);
    }

    @Test
    public void testInsertingASchool() {
        School smack = new School();
        smack.setSchoolName("SMACK");
        smack.setLevel("secondary");

        School sunsas = new School();
        sunsas.setSchoolName("SUNSAS");
        sunsas.setLevel("secondary");

        if (dbRepo != null) {
            dbRepo.insertSchool(smack, sunsas);
            List<School> shulez = dbRepo.getAllSchools().getValue();
            if (shulez != null)
                assertTrue("Schools are not two. They were not inserted well.",
                    shulez.size() == 2);
        }
    }

    @AfterClass
    public static void tearDown() {
        if (dbRepo != null) {
            LiveData<List<School>> shulez = dbRepo.getAllSchools();
            List<School> schoolList = shulez.getValue();
            if (schoolList != null)
                for (School shule : schoolList)
                    dbRepo.deleteSchool(shule.getId());
        }
    }
}
