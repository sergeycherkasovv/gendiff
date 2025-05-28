### Hexlet tests and linter status:
[![Actions Status](https://github.com/sergeycherkasovv/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/sergeycherkasovv/java-project-71/actions)

### My tests and linret status:
[![my-check](https://github.com/sergeycherkasovv/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/sergeycherkasovv/java-project-71/actions/workflows/main.yml)
<a href="https://codeclimate.com/github/sergeycherkasovv/java-project-71/test_coverage"><img src="https://api.codeclimate.com/v1/badges/9cfade9e6fd2faaff27b/test_coverage" /></a>
<a href="https://codeclimate.com/github/sergeycherkasovv/java-project-71/maintainability"><img src="https://api.codeclimate.com/v1/badges/9cfade9e6fd2faaff27b/maintainability" /></a>

**Gendiff** — это консольная утилита для определения различий между двумя файлами конфигурации. Поддерживает форматы JSON и YAML, а также предоставляет различные форматы вывода, включая стильный, плоский и JSON.

### Использование
Сравните два файла и выведите разницу

**Опции:**
- `-f, --format [type]`  — формат вывода (по умолчанию: `stylish`)
```bash
./app file1.yml file2.json
```

**Доступные форматы вывода:**
- `stylish` — древовидный формат
```bash
./app filepath1.json filepath2.json
ИЛИ 
./app --format stylish file1.yml file2.json
```
- `plain` — плоский текст
```bash
./app --format plain file1.yml file2.json
```
- `json` — JSON
```bash
./app --format json file1.yml file2.json
```

### Comparison of flat files (JSON)
[![asciicast](https://asciinema.org/a/yMr990f3pQIlCHG5mN63C2Clm.svg)](https://asciinema.org/a/yMr990f3pQIlCHG5mN63C2Clm)

### Formatter "stylish"
[![asciicast](https://asciinema.org/a/OVH4IUv5dgo1Tb87pp5YLod8K.svg)](https://asciinema.org/a/OVH4IUv5dgo1Tb87pp5YLod8K)

### Formatter "plain"
[![asciicast](https://asciinema.org/a/bVNvM4CfASayBmI4lRIL8J3XT.svg)](https://asciinema.org/a/bVNvM4CfASayBmI4lRIL8J3XT)

### Formatter "json"
[![asciicast](https://asciinema.org/a/QM1sFlRyoC6fS6lvKzLt5VVTn.svg)](https://asciinema.org/a/QM1sFlRyoC6fS6lvKzLt5VVTn)
