# Museo

progetto per Sistemi Informativi su Web


## Info

Questo sito è un sistema informativo di un piccolo museo.

Nel museo ci sono più collezioni: ogni collezione è gestita da un curatore (un dipendente del museo) e contiene una o più opere. Ogni collezione ha un nome e una descrizione. Un curatore può gestire una o più collezioni. Per ogni curatore sono di interesse nome, cognome, data e luogo di nascita, indirizzo di posta elettronica, numero di telefono, matricola.

Per ogni opera esposta nelle collezioni del museo sono memorizzati il titolo, l’anno in cui è stata realizzata, una descrizione. Ogni opera è stata realizzata da un artista. Per ogni artista, sono di interesse nome, cognome, data di nascita e luogo di nascita, data e luogo di morte (che potrebbero non essere presenti se l’artista è ancora in vita), nazionalità. Ogni artista può essere autore di più opere.


```text
Museo/
├── java/
│   ├── it.uniroma3.siw/...
│   ├── it.uniroma3.siw.authentication/...
│   ├── it.uniroma3.siw.spring.controller/...
│   ├── it.uniroma3.siw.spring.controller.validator/...
│   ├── it.uniroma3.siw.spring.model/...
│   ├── it.uniroma3.siw.spring.repository/...
│   ├── it.uniroma3.siw.spring.service/...
└── resources/
    ├── messages/
        ├── message_IT
        ├── message
    ├── static/
        ├── css
        ├── fonts
        ├── img
        ├── js
    ├── templates/
        ├── admin/...
        ├── fragments/...
        ├── ...
    ├── application.properties
```
