package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
    private int value = -1;
    Scanner scan = new Scanner(System.in);
    ArticleRepository articleRepository = new ArticleRepository();
    ArticleView articleView = new ArticleView();
    Person person;
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
            updateDetail(article);
        }else {
            System.out.println("존재하지 않는 게시물 번호입니다.");
        }
    }


    public void delete() {
        System.out.print("삭제할 게시물 번호 : ");
        int number = getNum(scan.nextLine(), value);
        Article article = articleRepository.findArticleNum(number);

        if (article != null){
            deleteDetail(article);
        }else {
            System.out.println("존재하지 않는 게시물 번호입니다.");
        }
    }

    public void detail() {
        System.out.print("상세보기할 게시물 번호를 입력해주세요 : ");
        int number = getNum(scan.nextLine(), value);
        Article article = articleRepository.findArticleNum(number);

        if (article != null){
            articleView.printArticle(article);

            while(person != null){
                System.out.print("상세보기 기능을 선택해주세요 (1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로 : ");
                String detailCmd = scan.nextLine();

                if (detailCmd.equals("5")){
                    break;
                }
                switch (detailCmd){
                    case "1" -> addComment(article);
                    case "2" -> goodButton(article);
                    case "3" -> updateDetail(article);
                    case "4" -> deleteDetail(article);
                    default -> System.out.println("올바른 기능을 선택해주세요.");
                }
            }
        }else {
            System.out.println("존재하지 않는 게시물 번호입니다.");
        }
    }

    private void goodButton(Article article) {
        if (article.getArticleGoodPerson().contains(person)){
            article.getArticleGoodPerson().remove(person);
        }else {
            article.getArticleGoodPerson().add(person);
        }
        System.out.println("좋아요 : " + article.getGoodPersonCount());
    }

    private void deleteDetail(Article article) {
        articleRepository.delete(article);
        System.out.println(article.getNum() + "번 게시물이 삭제되었습니다.");
    }

    private void updateDetail(Article article) {
        System.out.print("제목 : ");
        String newTitle = scan.nextLine();
        System.out.print("내용 : ");
        String newBody = scan.nextLine();

        articleRepository.update(article, newTitle, newBody);
        System.out.println(article.getNum() + "번 게시물이 수정되었습니다.");
    }

    private void addComment(Article article) {
        System.out.print("댓글 내용 : ");
        String comment = scan.nextLine();

        articleRepository.addComment(article, comment);
        System.out.println("댓글이 성공적으로 등록되었습니다.");
        articleView.printArticleComment(article);
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

    public void signup() {
        System.out.println("===회원가입을 진행합니다.===");
        System.out.print("아이디를 입력해주세요 : ");
        String id = scan.nextLine();
        System.out.print("비밀번호를 입력해주세요 : ");
        String password = scan.nextLine();
        System.out.print("닉네임을 입력해주세요 : ");
        String name = scan.nextLine();

        articleRepository.addPerson(id, password, name);
        System.out.println("==회원가입이 완료되었습니다.==");
    }

    public void login() {
        System.out.print("아이디 : ");
        String id = scan.nextLine();
        System.out.print("비밀번호 : ");
        String password = scan.nextLine();

        person = articleRepository.loginPerson(id, password);
        if (person != null){
            System.out.println(person.getName() + "님 환영합니다!");
        }else {
            System.out.println("비밀번호를 틀렸거나 잘못된 회원정보입니다.");
        }
    }

    public void loginCmd() {
        if (person != null){
            System.out.print("명령어를 입력해주세요 [" + person.getId() + "(" + person.getName() + ")] : ");
        }else {
            System.out.print("명령어를 입력해주세요 : ");
        }
    }

    public void logout() {
        person = null;
    }
}
