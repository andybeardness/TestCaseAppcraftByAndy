# TestCaseAppcraftByAndy

## Тестовое задания для AppCraft

Гид по пакетам приложения :

- [AndroidManifest](https://github.com/andybeardness/TestCaseAppcraftByAndy/blob/main/app/src/main/AndroidManifest.xml) - манифест
- [testcaseappcraftbyandy](https://github.com/andybeardness/TestCaseAppcraftByAndy/tree/main/app/src/main/java/com/beardness/testcaseappcraftbyandy) — весь код тут
- - [adapters](https://github.com/andybeardness/TestCaseAppcraftByAndy/tree/main/app/src/main/java/com/beardness/testcaseappcraftbyandy/adapters) — адаптеры
- - [models](https://github.com/andybeardness/TestCaseAppcraftByAndy/tree/main/app/src/main/java/com/beardness/testcaseappcraftbyandy/models) — модели
- - [retrofit](https://github.com/andybeardness/TestCaseAppcraftByAndy/tree/main/app/src/main/java/com/beardness/testcaseappcraftbyandy/retrofit) — для Retrofit
- - [room](https://github.com/andybeardness/TestCaseAppcraftByAndy/tree/main/app/src/main/java/com/beardness/testcaseappcraftbyandy/room) — для Romm
- - [ui](https://github.com/andybeardness/TestCaseAppcraftByAndy/tree/main/app/src/main/java/com/beardness/testcaseappcraftbyandy/ui) — UI

Что сделал :

- I и II пункты из задания 

Что сделаю :

- III пункт, всю реализацию по про [сервисы](https://github.com/andybeardness/TestCaseAppcraftByAndy/blob/main/app/src/main/java/com/beardness/testcaseappcraftbyandy/ui/ServiceActivity.kt)
- В классе [MainActivity](https://github.com/andybeardness/TestCaseAppcraftByAndy/blob/main/app/src/main/java/com/beardness/testcaseappcraftbyandy/ui/MainActivity.kt) можно реализовать нажатия на кнопки с помощью onClickListener'ов, а их получать либо через DI, либо через фабрику
- В классе [DatabaseActivity](https://github.com/andybeardness/TestCaseAppcraftByAndy/blob/main/app/src/main/java/com/beardness/testcaseappcraftbyandy/ui/DatabaseActivity.kt) реализую доступ к БД в отдельном потоке с помощью Rx
- В классе [NetworkActivity](https://github.com/andybeardness/TestCaseAppcraftByAndy/blob/main/app/src/main/java/com/beardness/testcaseappcraftbyandy/ui/NetworkActivity.kt) сделаю инъекцию объекта Retrofit, так как он дважды используется в приложении и не стоит создавать различные экземпляры одного и того же. Также сделаю красивую реализацию метода onFailure для обработки ошибок
- В классе [PhotosActivity](https://github.com/andybeardness/TestCaseAppcraftByAndy/blob/main/app/src/main/java/com/beardness/testcaseappcraftbyandy/ui/PhotosActivity.kt) приведу в порядок инициализацию albumTitle, albumID и userID, чтобы не дублировать одни и те же значения. Ещё сделаю обработку ошибок БД в fabSave.setOnClickListener и fabDelete.setOnClickListener для корректной работы
- Дополнительно можно будет перенести все Активити в Фрагменты, чтобы сделать Single-Activity приложение
