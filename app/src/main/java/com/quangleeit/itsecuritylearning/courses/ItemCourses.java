package com.quangleeit.itsecuritylearning.courses;


public class ItemCourses {
    private String title;
    private String content;
    private String favorite;

    public ItemCourses(String title, String content, String favorite) {
        this.title = title;
        this.content = content;
        this.favorite = favorite;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getFavorite() {
        return favorite;
    }
}
