# projetCV

Projet de 5A sur la création d'un site de CV en lignes. Ce site doit permettre à son utilisateur d'éditer librement son CV via une interface dédiée et de le mettre en ligne sous la forme d'un site qui permet à des personnes extérieures de le visualiser. Ce projet nous a permit d'utiliser pour la première fois Springboot et Thymeleaf. 

 ### Contexte du projet:
 
 Projet réalisé en 2020 au cours de ma cinquième année qui correspond à ma dernière année du cursus ingénieur en informatique et numérique. 
 
 ### Logiciel: 
- Intellij 

 ### Framework:
- Springboot 

 ### Languages: 
- HTML, CSS, JS, THYMELEAF

 ## Installation du projet
        
  - Importer le projet dans IntelliJ IDEA en important le fichier "pom.xml" à la racine de ce répertoire en tant que Maven project.

  - Exécuter votre DB mysql. Si vous avez docker, vous pouvez utiliser la commande suivante:
```
docker run --name mariadb --rm -e MYSQL_ROOT_PASSWORD=toor -e MYSQL_DATABASE=defaultdb -p 3306:3306 -v "`pwd`/initdb:/docker-entrypoint-initdb.d" mariadb
```

  - Si vous n'avez pas Docker, et que vous avez un serveur MariaDB custom, vérifiez bien que vos utilisateurs / mdp sont les bons par rapport au fichier de configuration (src/main/resources/application.properties), et exécutez les scripts présents dans le dossier `initdb`

  - Tous les scripts sql contenus dans le dossier initdb seront exécutés automatiquement lors du premier chargement de la DB.

  - Lancez l'application via IntelliJ, et vérifiez qu'elle fonctionne sur http://localhost:8080/index/1

 ### Equipe : 
 
 Ce projet à été réalisé par les étudiantes suivantes: 

 - CHARLET Solène
 - GUICHARD Ingrid (moi-même)
 - ORTEGA COLLADO Elena
