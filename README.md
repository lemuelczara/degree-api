<h1 align="center">Degree API</h1>

<p align="center">
  <img alt="Java Logo" src="https://img.shields.io/badge/Java-00143c?logo=java&labelColor=fff&logoColor=red">
</p>

<br>

## :open_book: About

Development of a Java REST API to generate certificates for students.

<br>

## :closed_book: Endpoints of API

Create a new Subject

`POST /subjects`

```json
// (HttpRequest) Body

{
    "name": "Matematica"
}
```

<br>

Create a new Student

`POST /students`

```json
// (HttpRequest) Body

{
    "name": "Lemuel Coelho Zara",
    "subjects": [
        {
            "id": "337",
            "grade": "9"
        },
        {
            "id": "531",
            "grade": "10"
        }
    ]
}
```

<br>

Create a new Certificate

`POST /certificates/{studentId}`


<br>