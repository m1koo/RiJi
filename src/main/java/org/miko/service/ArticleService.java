package org.miko.service;

import org.miko.dto.Result;
import org.miko.dto.UploadExcution;
import org.miko.entity.Article;

/**
 * Created by Miko on 2017/3/7.
 */
public interface ArticleService {
    String insertArticle(Article article);

    Article searchArticle(String articleId);
}
