### Hexlet tests and linter status:
[![Actions Status](https://github.com/FirefullHawk/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/FirefullHawk/java-project-78/actions)
[![Java-CI](https://github.com/FirefullHawk/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/FirefullHawk/java-project-78/actions/workflows/main.yml)
### Code Climate and test status:
[![Maintainability](https://api.codeclimate.com/v1/badges/d19031e0a4c994b6b5cb/maintainability)](https://codeclimate.com/github/FirefullHawk/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/d19031e0a4c994b6b5cb/test_coverage)](https://codeclimate.com/github/FirefullHawk/java-project-78/test_coverage)

# Валидатор

Данный проект - библиотека, предназначенная для валидации данных по заданным критериям. Всего реализовано три типа данных (Map, String, Integer)

# Описание функций

**StringScheme**

Схема для валидации строковых значений. Возможные правила для валидации следующие:

* _required_ - определяет, допускается ли валидация пустых строк или null. Если активно, валидация возвращает _false_ для данных значений. 

* _minLength_ - задание минимальной длины строки. Строка равная или длиннее пройдёт валидацию

* _contains_ - требование к содержанию в заданной на проверке строке символа или ряду символов. 

**NumberScheme**

Схема для валидации значений int. Возможные правила для валидации следующие:

* _required_ - определяет, допускается ли валидация null. Если активно, валидация возвращает _false_ для данного значения.

* _positive_ - определяет, допускается ли валидация отрицательных или нулевых значений 

* _range_ - задание минимального и максимального значения включительно для валидации.

**MapScheme**

Схема для валидации коллекции Map. Возможные правила для валидации следующие:

* _required_ - определяет, допускается ли валидация null. Если активно, валидация возвращает _false_ для данного значения.

* _sizeof_ - задание минимального размера Map. Map равная или больше пройдёт валидацию

* _shape_ - задание Map с правилами валидации для вложенных данных. Заполняется по принципу "ключ - правило валидации



### Автор

Симанов Дмитрий \ FirefullHawk