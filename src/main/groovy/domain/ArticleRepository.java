package domain;

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
        System.out.println("존재하지 않는 게시물 번호입니다.");
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
}
