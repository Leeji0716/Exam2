package domain;

import java.util.ArrayList;

public class ArticleView {
    public void printArticleList(ArrayList<Article> articleList) {
        System.out.println("========================");
        for (Article article : articleList){
            System.out.println("번호 : " + article.getNum());
            System.out.println("제목 : " + article.getTitle());
            System.out.println("========================");
        }
    }

    public void printArticle(Article article) {
        article.setHit(article.getHit()+1);
        System.out.println("========================");
        System.out.println("번호 : " + article.getNum());
        System.out.println("제목 : " + article.getTitle());
        System.out.println("내용 : " + article.getBody());
        System.out.println("등록날짜 : " + article.getDate());
        System.out.println("조회수 : " + article.getHit());
        System.out.println("========================");
    }
}
