<#import "../../blocks/common/head.ftl" as h>
<#import "../../blocks/common/navigation.ftl" as n>
<#import "../../blocks/common/footer.ftl" as f>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Гриффины (Family guy) | Редактировать сезон</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <@h.put_head/>
</head>
<body>
<div class="uk-container uk-container-expand">
    <@n.navigation/>
    <table class="uk-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Серия</th>
            <th>Сезон</th>
            <th>Название (rus)</th>
            <th>Название (eng)</th>
            <th>Описание</th>
            <th>Перевод</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Table Data</td>
            <td>Table Data</td>
            <td>Table Data</td>
            <td>Table Data <div class="uk-inline">
                    <a href="#" class="uk-icon-link uk-margin-small-right" uk-icon="file-edit"></a>
                    <div uk-dropdown="mode: click">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt.</div>
                </div></td>
            <td>Table Data <a href="#" class="uk-icon-link uk-margin-small-right" uk-icon="file-edit"></a></td>
            <td>Table Data <a href="#" class="uk-icon-link uk-margin-small-right" uk-icon="file-edit"></a></td>
            <td>Table Data <a href="#" class="uk-icon-link uk-margin-small-right" uk-icon="file-edit"></a></td>
        </tr>
        </tbody>
    </table>
    <@f.footer/>
</div>
</body>
</html>