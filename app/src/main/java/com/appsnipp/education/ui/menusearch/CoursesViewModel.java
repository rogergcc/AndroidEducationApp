/*
 * Copyright (c) 2021. rogergcc
 */

package com.appsnipp.education.ui.menusearch;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.appsnipp.education.data.CoursesRepository;
import com.appsnipp.education.ui.model.MatchCourse;

import java.util.List;

/**
 * Created on September.
 * year 2021 .
 */

public class CoursesViewModel extends ViewModel {
    private final MutableLiveData<List<MatchCourse>> mMatchedCourses;
    private final CoursesRepository repository;

    public CoursesViewModel(CoursesRepository repository) {
        this.repository = repository;
        this.mMatchedCourses = new MutableLiveData<>();
    }

    public LiveData<List<MatchCourse>> matchedCourses() {
        return mMatchedCourses;
    }

    public void fetchMatchedCourses() {
        List<MatchCourse> data = repository.matchedCourses();
        mMatchedCourses.postValue(data);
    }

    static class MyCoursesViewModelFactory implements ViewModelProvider.Factory {
        private final CoursesRepository repository;

        public MyCoursesViewModelFactory(CoursesRepository repository) {
            this.repository = repository;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            if (modelClass.isAssignableFrom(CoursesViewModel.class)) {
                return modelClass.cast(new CoursesViewModel(repository));
            }
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }

}

