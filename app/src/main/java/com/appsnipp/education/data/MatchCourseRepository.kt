/*
 * Copyright (c) 2024. rogergcc
 */

package com.appsnipp.education.data


/**
 * Created on mayo.
 * year 2024 .
 */
import com.appsnipp.education.R
import com.appsnipp.education.ui.model.MatchCourse


class MatchCourseRepository {
    val matchCourses: List<MatchCourse>
        get() = listOf(
            MatchCourse(1, "Digital Marketing", "12 courses available", R.drawable.education_2),
            MatchCourse(2, "Business", "50 courses available", R.drawable.education_3),
            MatchCourse(3, "Development", "265 courses available", R.drawable.education_4),
            MatchCourse(4, "Security", "18 courses available", R.drawable.education_1),
            MatchCourse(5, "Ethical Hacking", "36 courses available", R.drawable.education_5),
            MatchCourse(6, "Mobile", "145 courses available", R.drawable.education_6)
        )
}