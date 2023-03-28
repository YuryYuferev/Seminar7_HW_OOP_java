Записная книжка на Java

Проект для практики по ООП на языке Java. Сделан с применением популярных концепций построения проекта и соблюдением
принципов SOLID.

На данном проекте показан пример консольного приложения для ведения записной книжки (блокнота).

## Основные пакеты

<details><summary><h4>model</h4></summary>

В [данном пакете](src/notebook/model) представлен класс основной модели [Note](src/notebook/model/Note.java),
а также подмодуль [repository](src/notebook/model/repository),
который необходим для корректного связывания логики работы контроллера с моделью.

Класс Note содержит поля, описанные в ТЗ, а также методы для взаимодействия с ними и переопределение метода toString.

В подмодуле repository представлен интерфейс [Operational](src/notebook/model/repository/Operational.java)
и класс, реализующий его методы: [NoteRepository](src/notebook/model/repository/impl/NoteRepository.java).

Интерфейс Operational описывает 6 абстрактных методов, необходимых для работы с моделью в БД. (В данном случае методы
CRUD-операций и метод save)

Класс NoteRepository реализует поведение интерфейса Operational для типа Note.

</details>

<details><summary><h4>view</h4></summary>

В [данном пакете](src/notebook/view) представлен абстрактный класс [View](src/notebook/view/View.java)
и его реализация: [ConsoleView](src/notebook/view/impl/ConsoleView.java).

В абстрактном классе View описаны 1 абстрактный метод и 1 поле, необходимые для работы представлений.

Класс ConsoleView реализует абстрактный метод родительского класса для модели Note. Также в этом классе реализованы 2
дополнительных метода
для ввода данных из консоли и создания нового объекта класса Note.

</details>

<details><summary><h4>controller</h4></summary>

В [данном пакете](src/notebook/controller) представлен абстрактный
класс [Controller](src/notebook/controller/Controller.java)
и его реализация: класс [NoteController](src/notebook/controller/impl/NoteController.java).

Пакет отвечает за связывание модели и представления посредством обработки поступающих от модели данных и преобразования
их в формат модели.

В абстрактном классе Controller описаны 5 методов (2 абстрактных и 3 обычных), а также 1 поле, которое необходимо для
связи контроллера и модели.

В классе NoteController реализовано поведение 2 абстрактных методов родительского класса для модели Note.

</details>

<details><summary><h4>util</h4></summary>

В [данном пакете](src/notebook/util) представлены класс-перечисление [Commands](src/notebook/util/Commands.java),
класс для работы с приложением [AppManager](src/notebook/util/AppManager.java), а также 2 подмодуля:
[connector](src/notebook/util/connector) для соединения с БД,
[mapper](src/notebook/util/mapper) для преобразования данных из одного типа в другой.

Класс-перечисление Commands содержит все команды, которые могут быть использованы в представлении.

Класс AppManager упрощает работу пользователя с приложением, создавая необходимые объекты классов.
(В перспективе можно реализовать геттеры и сеттеры для замены компонентов объекта, и дополнительные конструкторы)

В подмодуле connector представлен абстрактный класс [Connector](src/notebook/util/connector/Connector.java),
и его реализация: класс [FileDBConnector](src/notebook/util/connector/impl/FileDBConnector.java).

В абстрактном классе Connector описаны 1 абстрактный метод и 1 поле, необходимые для работы коннектора.

В классе FileDBConnector реализован абстрактный метод родительского класса.

В подмодуле mapper представлен интерфейс [Mappable](src/notebook/util/mapper/Mappable.java)
и класс, реализующий его методы: [NoteMapper](src/notebook/util/mapper/impl/NoteMapper.java).

Интерфейс Mappable описывает 2 абстрактных метода для преобразования данных из одного типа в другой, и наоборот.

Класс NoteMapper реализует поведение интерфейса Mappable для типов Note и String.
Также в этом классе реализованы 2 дополнительных метода для определения соответствия строк необходимым типам данных.
(В данном случае, типу Long и LocalDateTime)