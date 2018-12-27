<#import "blocks/common/head.ftl" as h>
<#import "blocks/common/navigation.ftl" as n>
<#import "blocks/common/footer.ftl" as f>
<#import "heroes/peter.ftl" as p>
<#import "heroes/lois.ftl" as l>
<#import "heroes/brian.ftl" as b>
<#import "heroes/stewie.ftl" as s>
<#import "heroes/chris.ftl" as c>
<#import "heroes/meg.ftl" as m>
<#import "heroes/quagmire.ftl" as q>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Персонажи сериала Гриффины | Family guy</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Персонажи ситкома «Гриффины», описание.">
    <meta property="og:title" content="Персонажи сериала Гриффины | Family guy">
    <meta property="og:description" content="Персонажи ситкома «Гриффины», описание.">
    <meta http-equiv="content-language" content="ru">
    <meta name="keywords"
          content="Гриффин, Смотреть, онлайн, все, сезон, Стьюи, Брайан, Лоис, Питер, Мег, Гриффин, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, серия">
    <@h.put_head/>
</head>
<body>
<div class="uk-container uk-container-expand" uk-height-viewport="expand: true">
    <@n.navigation/>
    <ul class="uk-flex-center" uk-tab>
        <li><a href="#" style="font-size: 120%; font-weight: bold">Питер</a></li>
        <li><a href="#" style="font-size: 120%; font-weight: bold">Лоис</a></li>
        <li><a href="#" style="font-size: 120%; font-weight: bold">Брайан</a></li>
        <li><a href="#" style="font-size: 120%; font-weight: bold">Стьюи</a></li>
        <li><a href="#" style="font-size: 120%; font-weight: bold">Крис</a></li>
        <li><a href="#" style="font-size: 120%; font-weight: bold">Мег</a></li>
        <li><a href="#" style="font-size: 120%; font-weight: bold">Гленн Куагмаер</a></li>
    </ul>
    <ul class="uk-switcher uk-margin">
        <li>
           <@p.peter/>
        </li>
        <li>
            <@l.lois/>
        </li>
        <li>
            <@b.brian/>
        </li>
        <li>
            <@s.stewie/>
        </li>
        <li>
            <@c.chris/>
        </li>
        <li>
            <@m.meg/>
        </li>
        <li>
            <@q.quagmire/>
        </li>
    </ul>
    <@f.footer/>
</div>
</body>
</html>