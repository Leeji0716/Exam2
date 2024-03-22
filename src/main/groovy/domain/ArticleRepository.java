package domain;

import base.CommonUtill;

import java.util.ArrayList;

public class ArticleRepository {
    private int num = 4;
    CommonUtill commonUtill = new CommonUtill();

    public ArrayList<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(ArrayList<Article> articleList) {
        this.articleList = articleList;
    }


    ArrayList<Article> articleList = new ArrayList<>();
    ArrayList<Person> personList = new ArrayList<>();

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    public ArticleRepository(){
        Article a1 = new Article(1, "안녕하세요 반갑습니다. 자바공부중이에요.", "냉무", commonUtill.getDate());
        Article a2 = new Article(2, "자바 질문좀할게요~", "냉무", commonUtill.getDate());
        Article a3 = new Article(3, "정처기 따야하나요?", "냉무", commonUtill.getDate());
        articleList.add(a1);
        articleList.add(a2);
        articleList.add(a3);
    }
    public void add(String title, String body) {
        Article article = new Article(num, title, body, commonUtill.getDate());
        num++;
        articleList.add(article);
    }

    public Article findArticleNum(int number) {
        for (Article article : articleList){
            if (article.getNum() == number){
                return article;
            }
        }
        return null;
    }

    public void update(Article article, String newTitle, String newBody) {
        article.setTitle(newTitle);
        article.setBody(newBody);
        article.setDate(commonUtill.getDate());
    }

    public void delete(Article article) {
        articleList.remove(article);
    }

    public ArrayList<Article> findKeyword(String keyword) {
        ArrayList<Article> searchList = new ArrayList<>();
        for (Article article : articleList){
            if (article.getTitle().contains(keyword)){
                searchList.add(article);
            }
        }
        return searchList;
    }

    public void addComment(Article article, String comment) {
        Comments comments = new Comments(comment, commonUtill.getDate());
        article.getCommentList().add(comments);
    }

    public void addPerson(String id, String password, String name) {
        Person person = new Person(id, password, name);
        personList.add(person);
    }

    public Person loginPerson(String id, String password) {
        for (Person person : personList){
            if (person.getId().equals(id) && person.getPassword().equals(password)){
                return person;
            }
        }
        return null;
    }
}
