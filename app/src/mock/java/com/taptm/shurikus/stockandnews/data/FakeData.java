package com.taptm.shurikus.stockandnews.data;


import com.taptm.shurikus.stockandnews.data.source.remote.api.Content;
import com.taptm.shurikus.stockandnews.data.source.remote.api.Token;

import java.util.ArrayList;
import java.util.List;

public class FakeData {


    public static List<Content> getFakeContentList(){
        Content content = new Content();
        content.setId(144);
        content.setContentTypeId(0);
        content.setHeader("Внутренняя ссылка");
        content.setImgPreviewUrl("");
        content.setPublishTime("23-11-2015 10:32:03");
        content.setShortText("Новая функция - ссылки внутри каталога");
        content.setImgUrl("[\"http://service-retailmob.rhcloud.com/images/105/content/121/image/465b1291cf25c89e96fe6335b1a07f45.jpg\"]");
        content.setFullText("Теперь вы можете указать ссылку на подкатегорию каталога или конкретный товар. Нажмите на кнопку \"ПОДРОБНЕЕ\", чтобы увидеть, как это работает.");
        content.setLink("www.google.ru");


        Content contentAPI2 = new Content();
        contentAPI2.setId(145);
        contentAPI2.setContentTypeId(0);
        contentAPI2.setHeader("6-й ланч в подарок!");
        contentAPI2.setImgPreviewUrl("http://service-retailmob.rhcloud.com/images/105/contentAPI/121/preview/preview484de67a998f0ad6be4c96744ffb8b90.jpg");
        contentAPI2.setPublishTime("12-10-2015 10:16:16");
        contentAPI2.setShortText("Собирайте купоны и обедайте в Бенто Wok.");
        contentAPI2.setImgUrl("");
        contentAPI2.setFullText("тест 4");
        contentAPI2.setLink("www.ya.ru");

        Content contentAPI3 = new Content();
        contentAPI3.setId(146);
        contentAPI3.setContentTypeId(1);
        contentAPI3.setHeader("Мы на Web&Tech Ready 2015!");
        contentAPI3.setImgPreviewUrl("http://service-retailmob.rhcloud.com/images/105/contentAPI/107/preview/preview679b1812e3508b191159343b9837209d.png");
        contentAPI3.setPublishTime("21-09-2015 13:13:28");
        contentAPI3.setShortText("SalesBlast принял участие в самом крупном отечественном отборе молодых ИТ-проектов Web&Tech Ready 2015 в номинациях Seed и Retail Performance.");
        contentAPI3.setImgUrl("[\"http://service-retailmob.rhcloud.com/images/105/content/121/image/465b1291cf25c89e96fe6335b1a07f45.jpg\"]");
        contentAPI3.setFullText("<p>Соберите 5 купонов, полученных при покупке ланчей в Бенто Wok, и получите шестой ланч в подарок! Предложение действует бессрочно.</p>");
        contentAPI3.setLink("");

        List<Content> contentAPIList = new ArrayList<>();
        contentAPIList.add(content);
        contentAPIList.add(contentAPI2);
        contentAPIList.add(contentAPI3);

        return contentAPIList;
    }

    public static Token getFakeToken(){
        Token token = new Token();
        token.setUID("c34b1319d38cb2e1507b824a113f466b");
        return token;
    }

}



