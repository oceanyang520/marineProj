package com.luvsea.blog.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.luvsea.blog.entity.Article;
import com.luvsea.blog.service.ArticleService;
import com.luvsea.common.json.PageResult;

@Controller
@RequestMapping("article")
public class ArticleController {
    
    private final Logger log = LoggerFactory.getLogger(Article.class);
    
    @Autowired
    private ArticleService articleService;

    @RequestMapping("articleList")
    public @ResponseBody  PageResult<List<Article>> articleList(Article article){
                
        System.out.println("come in article list");
        List<Article> articleList = articleService.articleList(article);
        //list转为json
        PageResult<List<Article>> pr = new PageResult<List<Article>>();
        pr.setRows(articleList);
        pr.setTotal(10);
//        return JSON.toJSONString(articleList);
        return pr;
    }
    
    @RequestMapping("addArticle")
    public String addArticle(Article article){
        
        log.info("添加文章");
        Long articleId = this.articleService.addArticle(article);
//        return  (null!=articleId?String.valueOf(articleId):0);
        System.out.println(articleId);
        return "";
    }
    
    @RequestMapping("toArticleList")
    public ModelAndView toArticleList(Article article){

        ModelAndView mode = new ModelAndView();
        mode.setViewName("manager/articleList");
        return mode;
    }
    
    @RequestMapping("getEggs")
    @ResponseBody
    public void getEggs(HttpServletResponse hsr,Integer eggs){
        
        try {
            PrintWriter pw = hsr.getWriter();
            pw.print("i'm chou "+(eggs==1?"baby dan":"xiao jia huo er")+" ,heihei");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
