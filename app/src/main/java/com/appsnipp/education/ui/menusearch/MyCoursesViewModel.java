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

public class MyCoursesViewModel extends ViewModel {
    private final MutableLiveData<List<MatchCourse>> mLiveDataQrList;
    private final CoursesRepository repository;

    public MyCoursesViewModel(CoursesRepository repository) {
        this.repository = repository;
        this.mLiveDataQrList = new MutableLiveData<>();
    }


    public LiveData<List<MatchCourse>> getLiveDataQrList() {
        return mLiveDataQrList;
    }

    public void getDataQrListVM() {
        List<MatchCourse> data = repository.getData();
        mLiveDataQrList.postValue(data);
    }


}

class MyCoursesViewModelFactory implements ViewModelProvider.Factory {
    private final CoursesRepository repository;

    public MyCoursesViewModelFactory(CoursesRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MyCoursesViewModel.class)) {
            return (T) new MyCoursesViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}