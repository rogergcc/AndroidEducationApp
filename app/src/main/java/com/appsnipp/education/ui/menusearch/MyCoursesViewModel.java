/*
 * Copyright (c) 2021. rogergcc
 */

package com.appsnipp.education.ui.menusearch;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appsnipp.education.ui.model.MatchCourse;

import java.util.List;

/**
 * Created on September.
 * year 2021 .
 */
class MyCoursesViewModel extends ViewModel {

    MutableLiveData<List<MatchCourse>> mLiveDataQrList;
    private MyQrListRepository repository;

    public MyCoursesViewModel(MyQrListRepository repository) {
        this.repository = repository;
        mLiveDataQrList = new MutableLiveData();
    }

    public void getDataQrListVM() {

        repository.getData(mLiveDataQrList);
    }
}
