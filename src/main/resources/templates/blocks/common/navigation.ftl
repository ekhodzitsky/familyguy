<#macro navigation>
    <nav class="uk-navbar-container uk-margin-medium-bottom" style="background-color: transparent;" uk-navbar>
        <div class="uk-navbar-left">
            <a class="uk-navbar-toggle btn-menu" uk-toggle="target: #menu">
                <span uk-icon="icon: menu; ratio: 2"></span> <span class="uk-margin-small-left" style="font-size: 150%; font-weight: bold; font-family: 'Neucha', cursive">Меню</span>
            </a>
        </div>
        <div id="menu" uk-offcanvas="overlay: true">
            <div class="uk-offcanvas-bar uk-flex uk-flex-column">
                <button class="uk-offcanvas-close" type="button" uk-close></button>
                <ul class="uk-nav uk-nav-primary uk-nav-center uk-margin-auto-vertical">
                    <li class="uk-active"><a href="/">www.familyguy.space</a></li>
                    <li class="uk-nav-divider"></li>
                    <li><a href="/heroes"><span class="uk-margin-small-right"></span>Персонажи</a></li>
                    <li><a href="/authors"><span class="uk-margin-small-right"></span>О создателях сериала</a></li>
                    <li><a href="https://vk.com/familyguy.space"><span class="uk-margin-small-right"></span>Группа ВКонтакте</a></li>
                    <li class="uk-nav-divider"></li>
                    <li><a href="/license"><span class="uk-margin-small-right"></span>Пользовательское соглашение</a></li>
                    <li><a href="/rights"><span class="uk-margin-small-right" ></span>Правообладателям</a></li>
                </ul>
            </div>
        </div>
        <div class="uk-navbar-center">
            <ul class="uk-navbar-nav">
                <a class="uk-navbar-item uk-logo fg-logo" href="/">Family Guy</a>
            </ul>
        </div>
        <div class="uk-navbar-right">
            <a class="uk-navbar-toggle btn-menu" href="/admin" uk-icon="icon: sign-in; ratio: 1.4"></a>
        </div>
    </nav>
</#macro>