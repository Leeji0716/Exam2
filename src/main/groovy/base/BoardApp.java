package base;

import domain.ArticleController;

import java.util.Scanner;

public class BoardApp {
    public void run(){
        Scanner scan = new Scanner(System.in);
        ArticleController articleController = new ArticleController();

        while(true){
            articleController.loginCmd();
            String cmd = scan.nextLine();

            if (cmd.equals("exit")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            switch (cmd) {
                case "add" -> articleController.add();
                case "list" -> articleController.list();
                case "update" -> articleController.update();
                case "delete" -> articleController.delete();
                case "detail" -> articleController.detail();
                case "search" -> articleController.search();
                case "signup" -> articleController.signup();
                case "login" -> articleController.login();
                case "logout" -> articleController.logout();
                default -> System.out.println("올바른 명령어를 입력해주세요.");
            }
        }

    }
}
