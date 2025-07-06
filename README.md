### Hexlet tests and linter status:
[![Actions Status](https://github.com/sergeycherkasovv/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/sergeycherkasovv/java-project-71/actions)

### My tests and linret status:
[![my-check](https://github.com/sergeycherkasovv/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/sergeycherkasovv/java-project-71/actions/workflows/main.yml)
<a href="https://codeclimate.com/github/sergeycherkasovv/java-project-71/test_coverage"><img src="https://api.codeclimate.com/v1/badges/9cfade9e6fd2faaff27b/test_coverage" /></a>
<a href="https://codeclimate.com/github/sergeycherkasovv/java-project-71/maintainability"><img src="https://api.codeclimate.com/v1/badges/9cfade9e6fd2faaff27b/maintainability" /></a>

**Gendiff** — это консольная утилита для определения различий между двумя файлами конфигурации. Поддерживает форматы JSON и YAML, а также предоставляет различные форматы вывода, включая стильный, плоский и JSON.

**Стек:** `Java`, `Picocli`, `Gradle`, `Git`, `Linux`, `JUnit5`, `JaCoCo`, `Checkstyle`, `Code Climate`, `Make`. 

### Использование
Сравните два файла и выведите разницу

**Опции:**
- `-f, --format [type]`  — формат вывода (по умолчанию: `stylish`)
```bash
./app file1.yml file2.json
```

**Доступные форматы вывода:**
- [stylish](https://asciinema.org/a/yMr990f3pQIlCHG5mN63C2Clm) или [stylish](https://asciinema.org/a/OVH4IUv5dgo1Tb87pp5YLod8K) — древовидный формат
```bash
./app filepath1.json filepath2.json
ИЛИ 
./app --format stylish file1.yml file2.json
```
- [plain](https://asciinema.org/a/bVNvM4CfASayBmI4lRIL8J3XT) — плоский текст
```bash
./app --format plain file1.yml file2.json
```
- [json](https://asciinema.org/a/QM1sFlRyoC6fS6lvKzLt5VVTn) — JSON
```bash
./app --format json file1.yml file2.json
```

## 📮 Автор
Разработано в рамках обучения на Hexlet.
Автор: [sergeycherkasovv](https://github.com/sergeycherkasovv)

Почта: iamcherkasov.job@gmail.com
