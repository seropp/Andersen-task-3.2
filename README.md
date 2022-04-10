<h2>ANdERSEN TASK 3.2</h2>

![image](https://user-images.githubusercontent.com/85056996/162622323-788d0f05-6d4d-4479-9e11-6640144ded25.png)

(Разрешена лишь вертикальная ориентация - (через manifest))

<h2>Реализация</h2>
<h4>При реализации использовли следующее</h4>
<p>1. Сторонние библеотеки не были использованны</p>
<p>2. В качестве архитектуры использованно - Clean Arhcitecture (Ниже будет приведена схема проекта)</p>
<p>3. В качесве буффера между DOMAIN и PRESENTATION слоями исользован MVVM</p>
<p>4. Для CofigChanges использовалась LiveData</p>
<p>5. Также испольхованн Dagger для внидрения зависимостей</p>
<p>6. Для обращения к серверу использовали Coroutines</p>
<p>7. Для обработкиошибок использовался try-catch во ViewModel, который передавал null значение(bad practice) в Activity</p>

<h3>Проект схематично</h3>
<p>*без модулей (только пакеты)</p>

![image](https://user-images.githubusercontent.com/85056996/162624177-db569d8d-b6d3-4bd7-886a-26b20bcb3a1d.png)

<p>1. Создан 1 UseCase для получения изображения</p>
<p>2. Для Связи DOMAIN и DATA использовали интерфейс ImageLoader и его реализацию ImageLoaderImpl(в data)</p>
<p>3. Сам запрос к серверу проходил через класс ImageUploadWithoutLibrary, который реализовывал интерфейс Loader(для возможности расширения программы)</p>
<p>3.1. Запрос  через корутину</p>
<p>4. UseCase вызывался в ViewModel для этого (специфический конструктор) создали ViewModelFactory</p>
<p>4.1. В случае каких-либо ошибок Блок try-catch ловил (во ViewModel) и передавал в Activity null Значение где происходила проверка</p>
<p>5. Создали 3 класа с аннотацией @Module для внедрения зависимостей</p>
<p>6. Эти классы скомпоновали через интерфейс AppComponent(@Component)</p>
<p>7. Также добавили метод inject(mainActivity: MainActivity) для инъекции в MainActivity</p>
<p>8. Местом запуска сделали класс APP (который содержит интерфейс AppComponent)</p>
<p>9. Оставшаяся логика в Activity</p>
