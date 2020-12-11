/*
 * Copyright (c) 2020. rogergcc
 */

package com.appsnipp.education.ui.model;

public class CourseCard {

    private int Id;
    private int imageCourse;
    private String courseTitle;
    private String quantityCourses;
    private String urlCourse;

    public CourseCard(int id, int imageCourse, String courseTitle, String quantityCourses) {
        Id = id;
        this.imageCourse = imageCourse;
        this.courseTitle = courseTitle;
        this.quantityCourses = quantityCourses;
    }

    public CourseCard(int imageCourse, String courseTitle, String quantityCourses) {
        this.imageCourse = imageCourse;
        this.courseTitle = courseTitle;
        this.quantityCourses = quantityCourses;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getImageCourse() {
        return imageCourse;
    }

    public void setImageCourse(int imageCourse) {
        this.imageCourse = imageCourse;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getQuantityCourses() {
        return quantityCourses;
    }

    public void setQuantityCourses(String quantityCourses) {
        this.quantityCourses = quantityCourses;
    }

    public String getUrlCourse() {
        return urlCourse;
    }

    public void setUrlCourse(String urlCourse) {
        this.urlCourse = urlCourse;
    }

    @Override()
    public boolean equals(Object other) {
        // This is unavoidable, since equals() must accept an Object and not something more derived
        if (other instanceof CourseCard) {
            // Note that I use equals() here too, otherwise, again, we will check for referential equality.
            // Using equals() here allows the Model class to implement it's own version of equality, rather than
            // us always checking for referential equality.
            CourseCard courseCard = (CourseCard) other;
            return courseCard.getId()==(this.getId());
        }

        return false;
    }
}
