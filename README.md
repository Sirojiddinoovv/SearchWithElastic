# SearchWithElastic

Проект `SearchWithElastic` — это Spring Boot-приложение на Kotlin, предназначенное для управления фильмами и поиска по названиям с использованием Elasticsearch с поддержкой автодополнения и анализа текста на русском языке.

## 📦 Функции

- Добавление фильмов
- Поиск фильмов по названию (autocomplete)
- Хранение описания и названия фильмов
- Elasticsearch интеграция

## 🚀 Запуск

1. Убедитесь, что у вас запущен Elasticsearch (например, на `http://localhost:9200`).
2. Создайте индекс `movies` с нужными настройками и анализаторами:

```bash
curl --location --request PUT 'http://localhost:9200/movies' \
--header 'Content-Type: application/json' \
--data '{
    "settings": {
        "analysis": {
            "analyzer": {
                "autocomplete": {
                    "tokenizer": "autocomplete_tokenizer",
                    "filter": [
                        "lowercase"
                    ]
                },
                "autocomplete_search": {
                    "tokenizer": "lowercase"
                }
            },
            "tokenizer": {
                "autocomplete_tokenizer": {
                    "type": "edge_ngram",
                    "min_gram": 2,
                    "max_gram": 15,
                    "token_chars": [
                        "letter",
                        "digit",
                        "whitespace"
                    ]
                }
            }
        }
    },
    "mappings": {
        "properties": {
            "title": {
                "type": "text",
                "analyzer": "russian",
                "search_analyzer": "autocomplete_search"
            },
            "description": {
                "type": "text"
            }
        }
    }
}'
```

3. Соберите и запустите проект:

```bash
./gradlew bootRun
```

## 📂 Структура проекта

```
src/
├── main/
│   ├── kotlin/uz/nodir/searchwithelastic/
│   │   ├── controller/        # REST-контроллеры
│   │   ├── model/             # DTO и сущности
│   │   ├── repository/        # Spring Data репозиторий
│   │   ├── service/           # DAO и бизнес-слой
│   └── resources/
│       └── application.yml    # Конфигурация Spring
└── test/
    └── kotlin/...
```

## 📬 Примеры API

- `POST /movies` — добавить фильм
- `GET /movies?query=Тро` — поиск по названию

## 🛠️ Технологии

- Kotlin
- Spring Boot
- Elasticsearch
- Gradle

## 📄 Лицензия

MIT
