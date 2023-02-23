package com.newlecture.app.console;

import com.newlecture.app.entity.Notice;
import com.newlecture.app.service.NoticeService;

import java.sql.SQLException;
import java.util.List;

public class NoticeConsole {
    private NoticeService service;
    private int page;
    private int count;


    public NoticeConsole(){
        service = new NoticeService();
        page = 1;
        count = 0;

    }
    public void printNoticeList() throws SQLException, ClassNotFoundException {
        List<Notice> list = service.getList(page);
        count = service.getCount();

        System.out.println("---------------------------------");
        System.out.printf("<공지사항> 총%d 게시글",12);
        System.out.println("---------------------------------");
        System.out.printf("%d. %s / %s /%s",12,"안녕하세요","newlec","20","2023-02-22");
        System.out.printf("             %d / %d pages",1,2);

    }

    public int inputNoticeMenu() {
        return 0;
    }
}
