package domain;

import java.util.ArrayList;

public class Article {
    private int num;
    private String title;
    private String body;
    private String date;
    private int hit = 0;
    public int getGoodPersonCount(){
        return getArticleGoodPerson().size();
    }

    public ArrayList<Person> getArticleGoodPerson() {
        return articleGoodPerson;
    }

    public void setArticleGoodPerson(ArrayList<Person> articleGoodPerson) {
        this.articleGoodPerson = articleGoodPerson;
    }

    ArrayList<Person> articleGoodPerson = new ArrayList<>();
    ArrayList<Comments> commentList = new ArrayList<>();
    public Article(int num, String title, String body, String date){
        this.num = num;
        this.title = title;
        this.body = body;
        this.date = date;
    }

    public ArrayList<Comments> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<Comments> commentList) {
        this.commentList = commentList;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
class Comments {
    private String comment;
    private String commentDate;
    public Comments(String comment, String commentDate){
        this.comment = comment;
        this.commentDate = commentDate;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
