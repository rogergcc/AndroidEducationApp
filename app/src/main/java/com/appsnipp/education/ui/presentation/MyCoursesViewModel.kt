/*
 * Copyright (c) 2024. rogergcc
 */

package com.appsnipp.education.ui.presentation


/**
 * Created on mayo.
 * year 2024 .
 */

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.appsnipp.education.data.MatchCourseRepository
import com.appsnipp.education.ui.model.MatchCourse


class MyCoursesViewModel(private val matchCourseRepository: MatchCourseRepository) : ViewModel() {
    private val _matchCourses = MutableLiveData<List<MatchCourse>>()

    val matchCourses: LiveData<List<MatchCourse>> get() = _matchCourses

    fun fetchCourses() {
        _matchCourses.value = matchCourseRepository.matchCourses
    }
}