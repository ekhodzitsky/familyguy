<#macro navigation>
    <#include "../../security.ftl">
    <nav class="uk-navbar-container" style="background-color: white;" uk-navbar>
        <div class="uk-navbar-left">
            <ul class="uk-navbar-nav">
                <a class="uk-navbar-item uk-logo fg-logo" href="/">Family Guy</a>
            </ul>
        </div>
        <div class="uk-navbar-right">
            <ul class="uk-navbar-nav">
                <li class="uk-active uk-text-center uk-margin-medium-right">
                    www.familyguy.space
                    <div class="uk-navbar-subtitle">Микросервис, посвященный любимому сериалу</div>
                </li>
            </ul>
            <#if isAdmin>
                <a class="uk-navbar-toggle btn-menu" href="/admin" uk-icon="icon: sign-in; ratio: 1.4"></a>
            </#if>
        </div>
    </nav>
    <nav class="uk-navbar-container uk-margin-medium-bottom" style="background-color: #ffd152;" uk-navbar>
        <div class="uk-navbar-left">
            <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size" href="/">Главная</a>
            <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size" href="/moments">Нарезки<sup
                        style="color: red; font-size: 65%">new</sup></a>
            <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size" href="/heroes">Персонажи</a>
            <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size" href="/authors">Создатели
                сериала</a>
        </div>
        <div class="uk-navbar-right">
            <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size"
               href="/login">Войти</a>
            <a class="uk-button uk-button-default uk-button-small btn-nav-without-increasing-size"
               href="https://vk.com/familyguy.space">Группа ВК</a>
        </div>
    </nav>
</#macro>