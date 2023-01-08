# Localisation des pharmacies partie SpringBoot(backend)
Ce projet a pour but de mettre en place des api qui vont communiquer avec la partie mobile et la partie web de ce projet , ces api vont permettre de gerer les pharmacies 
leurs emplacements et les pharmacies qui sont en garde tout cela selon le type d'utulisateur (admin et client) .
# Fonctionalité
1. Gestion des villes
2. Gestion des zones
3. Gestion des gardes
4. Recuperer la liste des pharmacies
5. valider ou refuser les pharmacies en attente de validation en modifiant le champ "état"
6. Recuperer l'historique des gardes pour une pharmacie spécifique en utilisant son identifiant.
7. Calculer des statistiques sur le nombre de pharmacies par ville et par zone en utilisant des requêtes de groupement de données.
# Mise en place du projet
Pour mettre en place ce projet, vous aurez besoin des éléments suivants :
1. le framework spring boot (serveur et deploiement integré)
2. base de données MYSQL
2. Editeur de code INTELLIJ
# Déploiement
1. telecharger ou cloner le projet dans votre ordinateur
2. Ouvrez-le dans votre ordinateur
3. configurer la connexion avec MYSQL dans le fichier properties en indiquant le nom de la base de donnée et le port ou MYSQL est en fonction
4. lancer le projet en tant que springBoot Application
5. tester les api avec postman selon leur url dans les controllers
# Auteur
Ce projet a été réalisé par Ziz Ilyas.
