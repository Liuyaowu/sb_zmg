package com.mobei.bootlaunch.controller;

import com.mobei.bootlaunch.model.AjaxResponse;
import com.mobei.bootlaunch.model.Article;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 使用了lombok的@Slf4j注解（类的定义处）,就可以直接使用log变量打印日志,不需要写下面的这行代码:
 * private static final Logger log = LoggerFactory.getLogger(ArticleRestController.class);
 */
@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {

    //增加一篇Article:使用POST方法(produces = "application/json":设置响应数据格式,这里返回json格式,如果设置了responsebody注解则可以省略该属性)
    //@RequestMapping(value = "/article", method = POST, produces = "application/json")
    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "Article", httpMethod = "POST")
    @ApiResponses({
        @ApiResponse(code = 200, message = "成功", response = AjaxResponse.class),
        @ApiResponse(code = 400, message = "用户输入错误", response = AjaxResponse.class),
        @ApiResponse(code = 500, message = "系统内部错误", response = AjaxResponse.class)
    })
    @PostMapping("/article")
    public AjaxResponse saveArticle(@RequestBody Article article) {
        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        log.info("saveArticle：{}", article);
        return AjaxResponse.success(article);
    }

    /**
     * Post接收一个一个的参数:测试发现如果传的参数名称一致可以不用加@RequestParam注解,
     * 只有在客户端传入的参数与接收的参数名不一致时可以通过@RequestParam(name = "sid")指定
     * @param id
     * @param author
     * @return
     */
//    @PostMapping("/article")
//    public AjaxResponse saveArticle(@RequestParam("sid") String id,
//                                    @RequestParam String author) {
//        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
//        log.info("saveArticle：{}", author);
//        return AjaxResponse.success(author);
//    }


    /**
     * 删除一篇Article:使用DELETE方法,参数是id
     *  PathVariable用于URI上的{参数}:如下方法用于删除一篇文章,其中id为文章id。
     *  如：我们的请求URL为"/article/1",那么将匹配DeleteMapping并且PathVariable接收参数id=1
     */
    //@RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
    @ApiOperation(value = "删除文章", notes = "删除指定id的文章", tags = "Article", httpMethod = "DELETE")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功", response = AjaxResponse.class),
            @ApiResponse(code = 400, message = "用户输入错误", response = AjaxResponse.class),
            @ApiResponse(code = 500, message = "系统内部错误", response = AjaxResponse.class)
    })
    @DeleteMapping("/article/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id) {
        log.info("deleteArticle：{}", id);
        return AjaxResponse.success(id);
    }

    //更新一篇Article:使用PUT方法,以id为主键进行更新
    //@RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
    @PutMapping("/article/{id}")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);
        log.info("updateArticle：{}", article);
        return AjaxResponse.success(article);
    }

    //获取一篇Article:使用GET方法
    //@RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    @GetMapping("/article/{id}")
    public AjaxResponse getArticle(@PathVariable Long id) {
        //使用lombok提供的builder构建对象
        Article article1 = Article.builder()
                .id(1L)
                .author("mobei")
                .content("spring boot 2.X深入浅出")
                .createTime(new Date())
                .title("t1").build();
        return AjaxResponse.success(article1);
    }

    //获取一篇Article:使用GET方法
    //@RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    @GetMapping("/article")
    public AjaxResponse getArticleByPage(Article article) {
        //使用lombok提供的builder构建对象
        Article article1 = Article.builder()
                .id(1L)
                .author("mobei")
                .content("spring boot 2.X深入浅出")
                .createTime(new Date())
                .title("t1").build();
        return AjaxResponse.success(article1);
    }
}