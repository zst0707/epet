package front;

import java.util.Scanner;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 郑思婷
 * @Date 2019/6/13 13:20
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Menus f = new Menus();
        f.Start();
        boolean time = true;
        while(time)
        {
            System.out.println("——————————————");
            System.out.println("请选择进入登录模式\n1:宠物主人登录\n2:宠物商店登录\n3:退出");
            int num = in.nextInt();
            time = f.login(num);
        }

    }
}

