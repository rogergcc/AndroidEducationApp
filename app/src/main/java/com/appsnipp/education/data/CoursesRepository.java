/*
 * Copyright (c) 2024. rogergcc
 */

package com.appsnipp.education.data;

import com.appsnipp.education.ui.model.MatchCourse;

import java.util.Collections;
import java.util.List;

/**
 * Created on mayo.
 * year 2024 .
 */
public class CoursesRepository {
    public List<MatchCourse> matchedCourses() {
        try {
            return MatchesCoursesFake.getInstance().matchedCourses();
        } catch (Exception ex) {
            // Maneja la excepción aquí
            return Collections.emptyList();
        }
    }
}
