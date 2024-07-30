/*
 * Copyright (c) 2020. rogergcc
 */

package com.appsnipp.education.ui.model;

public class CourseCard {

    private int id;
    private String title;
    private String quantityCourses;
    private int imageResource;

    private String urlCourse;

    public CourseCard(int id, String title, String quantityCourses, int imageResource) {
        this.id = id;
        this.title = title;
        this.quantityCourses = quantityCourses;
        this.imageResource = imageResource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageCourse() {
        return imageResource;
    }

    public void setImageCourse(int imageCourse) {
        this.imageResource = imageCourse;
    }

    public String getCourseTitle() {
        return title;
    }

    public void setCourseTitle(String courseTitle) {
        this.title = courseTitle;
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
