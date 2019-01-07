<#import "blocks/common/head.ftl" as h>
<#import "blocks/common/navigation.ftl" as n>
<#import "blocks/common/footer.ftl" as f>
<#import "blocks/heroes/peter.ftl" as p>
<#import "blocks/heroes/lois.ftl" as l>
<#import "blocks/heroes/brian.ftl" as b>
<#import "blocks/heroes/stewie.ftl" as s>
<#import "blocks/heroes/chris.ftl" as c>
<#import "blocks/heroes/meg.ftl" as m>
<#import "blocks/heroes/quagmire.ftl" as q>
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
    <meta name="keywords" content="персонаж, сериал, гриффин, Питер, Лоис, Брайан, Стьюи, Крис, Мег, Куагмаер">
    <@h.put_head/>
</head>
<body>
<@n.navigation/>
<div class="uk-container uk-container-expand" uk-height-viewport="expand: true">
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