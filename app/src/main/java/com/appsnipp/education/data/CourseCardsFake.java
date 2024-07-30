/*
 * Copyright (c) 2024. rogergcc
 */

package com.appsnipp.education.data;

import com.appsnipp.education.R;
import com.appsnipp.education.ui.model.CourseCard;

import java.util.Arrays;
import java.util.List;

/**
 * Created on mayo.
 * year 2024 .
 */
public class CourseCardsFake {

    private static CourseCardsFake instance;

    private CourseCardsFake() {
    }

    public static synchronized CourseCardsFake getInstance() {
        if (instance == null) {
            instance = new CourseCardsFake();
        }
        return instance;
    }

    public List<CourseCard> getCourseCards() {
        return Arrays.asList(
                new CourseCard(1, "Desing Thinking X", "19 courses", R.drawable.education_1),
                new CourseCard(2, "Software Development", "14 courses", R.drawable.education_2),
                new CourseCard(3, "Marketing", "24 courses", R.drawable.education_5),
                new CourseCard(4, "Security Expert", "18 courses", R.drawable.education_4)
        );
    }

    public List<CourseCard> getSearchCoursesCards() {
        return Arrays.asList(
                new CourseCard(1, "Design Thinking", "19 courses", R.drawable.course_design_thinking),
                new CourseCard(2, "App Development", "14 courses", R.drawable.course_design_coding),
                new CourseCard(3, "Marketing", "24 courses", R.drawable.course_design_marketing),
                new CourseCard(4, "Security Expert", "18 courses", R.drawable.course_design_securityexpert),
                new CourseCard(5, "Pentest App Android", "21 courses", R.drawable.course_design_whatisthisshit),
                new CourseCard(6, "Big Data", "10 courses", R.drawable.course_coding)
        );
    }
}