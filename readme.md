# Shopping list application
A sample application on Spring Boot framework, uses Thymeleaf for front-end (see pages [index](https://github.com/vilasha/ShoppingList/blob/master/src/main/resources/templates/index.html), [login](https://github.com/vilasha/ShoppingList/blob/master/src/main/resources/templates/login.html) and [register](https://github.com/vilasha/ShoppingList/blob/master/src/main/resources/templates/register.html) in /resources/templates), Spring security for user authentication and MySQL database for persistence layer (optionally can switch to H2 database in [application.properties](https://github.com/vilasha/ShoppingList/blob/master/src/main/resources/application.properties) file).

#####How to deploy on Heroku:
1. Register on heroku.com
2. Install [heroku cli](https://devcenter.heroku.com/articles/heroku-cli)
3. Reboot computer if needed. Command "heroku" in terminal should show version and list of commands.
4. In terminal run "heroku login" and press any button. This will redirect your browser to heroku login page.
5. Launch Docker (Desktop or Tools).
6. In terminal run "heroku container:login", the response should be "Login Succeeded". This will give Docker access to Heroku repositories.
7. Launch file heroku-create-app (.bat or .sh depending on your OS: bat is for Windows, sh is for Linux or Mac). Be aware, that Heroku app name, specified in this file, should be unique across all the Heroku users.
8. Build the project 
9. Run Dockerfile, in "Edit run configurations" container name should be the same as name of artifact (shopping-list-demo1) and the same as Heroku app name.
10. Launch file heroku-deploy-app (.bat or .sh depending on your OS: bat is for Windows, sh is for Linux or Mac).
11. If the app didn't go live straight away, in terminal run again release command: "heroku container:release web --app=shopping-list-demo1"