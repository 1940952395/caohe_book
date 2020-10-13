package com.lcd.controller;


import com.lcd.entiy.Book;
import com.lcd.entiy.BookMulv;
import com.lcd.service.BookService;
import com.lcd.service.BookMulvService;
import com.lcd.utils.IO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;


@Transactional
@Controller
public class BookController {

        @Autowired
        private BookService bookService;

        @Autowired
        private BookMulvService book_mulvService;



    //书籍主页
    @RequestMapping("/tobook")
    public String tobook(Model model){
        Book book  = bookService.findbookId(29);
        System.out.println(book);
        model.addAttribute("book",book);
        return "book";
    }

    //书籍目录
    @RequestMapping(value = "/tobook_mulu")
    public String tobook_mulu(Integer bookid, Model model){
        Book book  = bookService.findbookId(bookid);
        List<BookMulv> bookMulvs = book_mulvService.findbyname(bookid);
        model.addAttribute("book_mulv",bookMulvs);
        model.addAttribute("book",book);
        return "book_molu";
    }

    //书籍text页
    @RequestMapping("/tobook_text")
    public String tobook_text(Integer bookId,Integer bookmulvId,Model model) throws IOException {
        System.out.println(bookId);
        System.out.println(bookmulvId);
        Book book = this.bookService.findbookId(bookId);
        BookMulv bookMulv = this.book_mulvService.findbyId(bookmulvId);
        StringBuffer str = IO.read("D:/桌面/小说/ "+book.getBookName()+"/ "+bookMulv.getBookDirectory()+".text");
        model.addAttribute("text",str);
        model.addAttribute("book",bookMulv.getBookDirectory());
        System.out.println(str);
        return "book_text";
    }
}
