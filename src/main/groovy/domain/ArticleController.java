package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
    private int value = -1;
    Scanner scan = new Scanner(System.in);
    ArticleRepository articleRepository = new ArticleRepository();
    ArticleView articleView = new ArticleView();
    public void add() {
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String body = scan.nextLine();

        articleRepository.add(title, body);
        System.out.println("게시물이 등록되었습니다.");
    }

    public void list() {
        articleView.printArticleList(articleRepository.getArticleList());
    }
    private int getNum(String number, int value) {
        try {
            return Integer.parseInt(number);
        }catch (NumberFormatException e){
            System.out.println("숫자를 입력해주세요");
            return value;
        }
    }

    public void update() {
        System.out.print("수정할 게시물 번호 : ");
        int number = getNum(scan.nextLine(), value);
        Article article = articleRepository.findArticleNum(number);

        if (article != null){
            System.out.print("제목 : ");
            String newTitle = scan.nextLine();
            System.out.print("내용 : ");
            String newBody = scan.nextLine();

            articleRepository.update(article, newTitle, newBody);
            System.out.println(article.getNum() + "번 게시물이 수정되었습니다.");
        }
    }


    public void delete() {
        System.out.print("삭제할 게시물 번호 : ");
        int number = getNum(scan.nextLine(), value);
        Article article = articleRepository.findArticleNum(number);

        if (article != null){
            articleRepository.delete(article);
            System.out.println(article.getNum() + "번 게시물이 삭제되었습니다.");
        }
    }

    public void detail() {
        System.out.print("상세보기할 게시물 번호를 입력해주세요 : ");
        int number = getNum(scan.nextLine(), value);
        Article article = articleRepository.findArticleNum(number);

        if (article != null){
            articleView.printArticle(article);
        }
    }

    public void search() {
        System.out.print("검색키워드를 입력해주세요 : ");
        String keyword = scan.nextLine();
        ArrayList<Article> searchList = articleRepository.findKeyword(keyword);

        if (searchList.size() > 0){
            articleView.printArticleList(searchList);
        }else {
            System.out.println("검색 결과가 없습니다.");
        }
    }
}
