/*
 * Copyright (c) 2024. rogergcc
 */

package com.appsnipp.education.data;

import com.appsnipp.education.R;
import com.appsnipp.education.ui.model.MatchCourse;

import java.util.Arrays;
import java.util.List;


public class MatchesCoursesFake {

    private static MatchesCoursesFake instance;

    private MatchesCoursesFake() {
    }

    public static synchronized MatchesCoursesFake getInstance() {
        if (instance == null) {
            instance = new MatchesCoursesFake();
        }
        return instance;
    }


    public List<MatchCourse> matchedCourses() {
        return Arrays.asList(
                new MatchCourse(1, "Digital Marketing", "12 courses available", R.drawable.education_2),
                new MatchCourse(2, "Business", "50 courses available", R.drawable.education_3),
                new MatchCourse(3, "Development", "265 courses available", R.drawable.education_4),
                new MatchCourse(4, "Security", "18 courses available", R.drawable.education_1),
                new MatchCourse(5, "Ethical Hacking", "36 courses available", R.drawable.education_5),
                new MatchCourse(6, "Mobile", "145 courses available", R.drawable.education_6)
        );
    }


}
